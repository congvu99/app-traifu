package com.facebook.rebound;

import com.github.mikephil.charting.utils.Utils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Spring {
    private static int ID = 0;
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private final PhysicsState mCurrentState = new PhysicsState();
    private double mDisplacementFromRestThreshold = 0.005d;
    private double mEndValue;
    private final String mId;
    private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet<>();
    private boolean mOvershootClampingEnabled;
    private final PhysicsState mPreviousState = new PhysicsState();
    private double mRestSpeedThreshold = 0.005d;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mTempState = new PhysicsState();
    private double mTimeAccumulator = Utils.DOUBLE_EPSILON;
    private boolean mWasAtRest = true;

    private static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem != null) {
            this.mSpringSystem = baseSpringSystem;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i = ID;
            ID = i + 1;
            sb.append(i);
            this.mId = sb.toString();
            setSpringConfig(SpringConfig.defaultConfig);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public String getId() {
        return this.mId;
    }

    public Spring setSpringConfig(SpringConfig springConfig) {
        if (springConfig != null) {
            this.mSpringConfig = springConfig;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public Spring setCurrentValue(double d) {
        return setCurrentValue(d, true);
    }

    public Spring setCurrentValue(double d, boolean z) {
        this.mStartValue = d;
        this.mCurrentState.position = d;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z) {
            setAtRest();
        }
        return this;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    public Spring setEndValue(double d) {
        if (this.mEndValue == d && isAtRest()) {
            return this;
        }
        this.mStartValue = getCurrentValue();
        this.mEndValue = d;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public Spring setVelocity(double d) {
        if (d == this.mCurrentState.velocity) {
            return this;
        }
        this.mCurrentState.velocity = d;
        this.mSpringSystem.activateSpring(getId());
        return this;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public Spring setRestSpeedThreshold(double d) {
        this.mRestSpeedThreshold = d;
        return this;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public Spring setRestDisplacementThreshold(double d) {
        this.mDisplacementFromRestThreshold = d;
        return this;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public Spring setOvershootClampingEnabled(boolean z) {
        this.mOvershootClampingEnabled = z;
        return this;
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        return this.mSpringConfig.tension > Utils.DOUBLE_EPSILON && ((this.mStartValue < this.mEndValue && getCurrentValue() > this.mEndValue) || (this.mStartValue > this.mEndValue && getCurrentValue() < this.mEndValue));
    }

    /* access modifiers changed from: package-private */
    public void advance(double d) {
        boolean z;
        boolean isAtRest = isAtRest();
        if (!isAtRest || !this.mWasAtRest) {
            double d2 = MAX_DELTA_TIME_SEC;
            if (d <= MAX_DELTA_TIME_SEC) {
                d2 = d;
            }
            this.mTimeAccumulator += d2;
            double d3 = this.mSpringConfig.tension;
            double d4 = this.mSpringConfig.friction;
            double d5 = this.mCurrentState.position;
            double d6 = this.mCurrentState.velocity;
            double d7 = this.mTempState.position;
            double d8 = this.mTempState.velocity;
            while (true) {
                double d9 = this.mTimeAccumulator;
                if (d9 < SOLVER_TIMESTEP_SEC) {
                    break;
                }
                double d10 = d9 - SOLVER_TIMESTEP_SEC;
                this.mTimeAccumulator = d10;
                if (d10 < SOLVER_TIMESTEP_SEC) {
                    this.mPreviousState.position = d5;
                    this.mPreviousState.velocity = d6;
                }
                double d11 = this.mEndValue;
                double d12 = ((d11 - d7) * d3) - (d4 * d6);
                double d13 = d6 + (d12 * SOLVER_TIMESTEP_SEC * 0.5d);
                double d14 = ((d11 - (((d6 * SOLVER_TIMESTEP_SEC) * 0.5d) + d5)) * d3) - (d4 * d13);
                double d15 = d6 + (d14 * SOLVER_TIMESTEP_SEC * 0.5d);
                double d16 = ((d11 - (d5 + ((d13 * SOLVER_TIMESTEP_SEC) * 0.5d))) * d3) - (d4 * d15);
                double d17 = d5 + (d15 * SOLVER_TIMESTEP_SEC);
                double d18 = d6 + (d16 * SOLVER_TIMESTEP_SEC);
                d5 += (d6 + ((d13 + d15) * 2.0d) + d18) * 0.16666666666666666d * SOLVER_TIMESTEP_SEC;
                d6 += (d12 + ((d14 + d16) * 2.0d) + (((d11 - d17) * d3) - (d4 * d18))) * 0.16666666666666666d * SOLVER_TIMESTEP_SEC;
                d7 = d17;
                d8 = d18;
            }
            this.mTempState.position = d7;
            this.mTempState.velocity = d8;
            this.mCurrentState.position = d5;
            this.mCurrentState.velocity = d6;
            double d19 = this.mTimeAccumulator;
            if (d19 > Utils.DOUBLE_EPSILON) {
                interpolate(d19 / SOLVER_TIMESTEP_SEC);
            }
            boolean z2 = true;
            if (isAtRest() || (this.mOvershootClampingEnabled && isOvershooting())) {
                if (d3 > Utils.DOUBLE_EPSILON) {
                    double d20 = this.mEndValue;
                    this.mStartValue = d20;
                    this.mCurrentState.position = d20;
                } else {
                    double d21 = this.mCurrentState.position;
                    this.mEndValue = d21;
                    this.mStartValue = d21;
                }
                setVelocity(Utils.DOUBLE_EPSILON);
                isAtRest = true;
            }
            if (this.mWasAtRest) {
                this.mWasAtRest = false;
                z = true;
            } else {
                z = false;
            }
            if (isAtRest) {
                this.mWasAtRest = true;
            } else {
                z2 = false;
            }
            Iterator<SpringListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                SpringListener next = it.next();
                if (z) {
                    next.onSpringActivate(this);
                }
                next.onSpringUpdate(this);
                if (z2) {
                    next.onSpringAtRest(this);
                }
            }
        }
    }

    public boolean systemShouldAdvance() {
        return !isAtRest() || !wasAtRest();
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public boolean isAtRest() {
        return Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold && (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringConfig.tension == Utils.DOUBLE_EPSILON);
    }

    public Spring setAtRest() {
        this.mEndValue = this.mCurrentState.position;
        this.mTempState.position = this.mCurrentState.position;
        this.mCurrentState.velocity = Utils.DOUBLE_EPSILON;
        return this;
    }

    private void interpolate(double d) {
        PhysicsState physicsState = this.mCurrentState;
        double d2 = 1.0d - d;
        physicsState.position = (physicsState.position * d) + (this.mPreviousState.position * d2);
        PhysicsState physicsState2 = this.mCurrentState;
        physicsState2.velocity = (physicsState2.velocity * d) + (this.mPreviousState.velocity * d2);
    }

    public Spring addListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.add(springListener);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    public Spring removeListener(SpringListener springListener) {
        if (springListener != null) {
            this.mListeners.remove(springListener);
            return this;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public boolean currentValueIsApproximately(double d) {
        return Math.abs(getCurrentValue() - d) <= getRestDisplacementThreshold();
    }
}
