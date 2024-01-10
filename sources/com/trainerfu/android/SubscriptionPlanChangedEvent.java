package com.trainerfu.android;

public class SubscriptionPlanChangedEvent {
    public boolean savedToServerSuccessfully;

    public SubscriptionPlanChangedEvent(boolean z) {
        this.savedToServerSuccessfully = z;
    }
}
