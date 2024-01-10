package kotlinx.coroutines.debug;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/* renamed from: kotlinx.coroutines.debug.-$$Lambda$AgentPremain$6vy0kBIPkuO0a1izx5ONKfM-3Ss  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AgentPremain$6vy0kBIPkuO0a1izx5ONKfM3Ss implements SignalHandler {
    public static final /* synthetic */ $$Lambda$AgentPremain$6vy0kBIPkuO0a1izx5ONKfM3Ss INSTANCE = new $$Lambda$AgentPremain$6vy0kBIPkuO0a1izx5ONKfM3Ss();

    private /* synthetic */ $$Lambda$AgentPremain$6vy0kBIPkuO0a1izx5ONKfM3Ss() {
    }

    public final void handle(Signal signal) {
        AgentPremain.m6955installSignalHandler$lambda1(signal);
    }
}
