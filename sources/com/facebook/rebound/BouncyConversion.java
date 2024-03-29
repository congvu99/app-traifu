package com.facebook.rebound;

import com.github.mikephil.charting.utils.Utils;

public class BouncyConversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final double mBounciness;
    private final double mBouncyFriction;
    private final double mBouncyTension;
    private final double mSpeed;

    private double linear_interpolation(double d, double d2, double d3) {
        return (d3 * d) + ((1.0d - d) * d2);
    }

    private double normalize(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }

    private double project_normal(double d, double d2, double d3) {
        return d2 + (d * (d3 - d2));
    }

    public BouncyConversion(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        this.mSpeed = d3;
        this.mBounciness = d4;
        double d5 = d4 / 1.7d;
        double project_normal = project_normal(normalize(d5, Utils.DOUBLE_EPSILON, 20.0d), Utils.DOUBLE_EPSILON, 0.8d);
        double project_normal2 = project_normal(normalize(d3 / 1.7d, Utils.DOUBLE_EPSILON, 20.0d), 0.5d, 200.0d);
        this.mBouncyTension = project_normal2;
        this.mBouncyFriction = quadratic_out_interpolation(project_normal, b3_nobounce(project_normal2), 0.01d);
    }

    public double getSpeed() {
        return this.mSpeed;
    }

    public double getBounciness() {
        return this.mBounciness;
    }

    public double getBouncyTension() {
        return this.mBouncyTension;
    }

    public double getBouncyFriction() {
        return this.mBouncyFriction;
    }

    private double quadratic_out_interpolation(double d, double d2, double d3) {
        return linear_interpolation((2.0d * d) - (d * d), d2, d3);
    }

    private double b3_friction1(double d) {
        return ((Math.pow(d, 3.0d) * 7.0E-4d) - (Math.pow(d, 2.0d) * 0.031d)) + (d * 0.64d) + 1.28d;
    }

    private double b3_friction2(double d) {
        return ((Math.pow(d, 3.0d) * 4.4E-5d) - (Math.pow(d, 2.0d) * 0.006d)) + (d * 0.36d) + 2.0d;
    }

    private double b3_friction3(double d) {
        return ((Math.pow(d, 3.0d) * 4.5E-7d) - (Math.pow(d, 2.0d) * 3.32E-4d)) + (d * 0.1078d) + 5.84d;
    }

    private double b3_nobounce(double d) {
        if (d <= 18.0d) {
            return b3_friction1(d);
        }
        if (d <= 18.0d || d > 44.0d) {
            return d > 44.0d ? b3_friction3(d) : Utils.DOUBLE_EPSILON;
        }
        return b3_friction2(d);
    }
}
