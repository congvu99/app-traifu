package com.trainerfu.android;

public enum CopyPlanTemplateTaskType {
    FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT(1),
    FOR_COPYING_TO_MANY_CLIENTS(2),
    FOR_COPYING_TO_SEGMENTS(3),
    FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP(4);
    
    private final int mask;

    private CopyPlanTemplateTaskType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static CopyPlanTemplateTaskType getCopyPlanTemplateTaskType(int i) {
        if (i == 1) {
            return FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT;
        }
        if (i == 2) {
            return FOR_COPYING_TO_MANY_CLIENTS;
        }
        if (i == 3) {
            return FOR_COPYING_TO_SEGMENTS;
        }
        if (i == 4) {
            return FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP;
        }
        throw new IllegalArgumentException();
    }
}
