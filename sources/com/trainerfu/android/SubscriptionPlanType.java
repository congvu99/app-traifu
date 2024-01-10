package com.trainerfu.android;

import androidx.compose.material.TextFieldImplKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imagepipeline.common.RotationOptions;
import org.apache.http.HttpStatus;

public enum SubscriptionPlanType {
    APP_FREEMIUM(1),
    APP_PREMIUM(2),
    WEB_TRAINER(3),
    WEB_TRAINER_PLUS(4),
    WEB_STUDIO(5),
    OTHER(7),
    APP_TRAINER_BASIC(110),
    APP_TRAINER_STANDARD(120),
    APP_TRAINER_PLUS(130),
    APP_STUDIO_BASIC(140),
    APP_STUDIO_STANDARD(TextFieldImplKt.AnimationDuration),
    APP_STUDIO_PLUS(160),
    APP_GYM(170),
    APP_GYM_PRO(RotationOptions.ROTATE_180),
    WEB_TRAINER_BASIC(310),
    WEB_TRAINER_STANDARD(320),
    WEB_TRAINER_PLUS_2(330),
    WEB_STUDIO_BASIC(340),
    WEB_STUDIO_STANDARD(350),
    WEB_STUDIO_PLUS(360),
    WEB_GYM(370),
    WEB_GYM_PRO(380),
    WEB_TRAINER_BASIC_YEARLY(HttpStatus.SC_GONE),
    WEB_TRAINER_STANDARD_YEARLY(420),
    WEB_TRAINER_PLUS_2_YEARLY(430),
    WEB_STUDIO_BASIC_YEARLY(440),
    WEB_STUDIO_STANDARD_YEARLY(450),
    WEB_STUDIO_PLUS_YEARLY(460),
    WEB_GYM_YEARLY(470),
    WEB_GYM_PRO_YEARLY(480),
    BRANDED_TRAINER_BASIC(TypedValues.PositionType.TYPE_POSITION_TYPE),
    BRANDED_TRAINER_STANDARD(520),
    BRANDED_TRAINER_PLUS_2(530),
    BRANDED_STUDIO_BASIC(540),
    BRANDED_STUDIO_STANDARD(550),
    BRANDED_STUDIO_PLUS(560),
    BRANDED_GYM(570),
    BRANDED_GYM_PRO(580),
    BRANDED_TRAINER_BASIC_YEARLY(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS),
    BRANDED_TRAINER_STANDARD_YEARLY(620),
    BRANDED_TRAINER_PLUS_2_YEARLY(630),
    BRANDED_STUDIO_BASIC_YEARLY(640),
    BRANDED_STUDIO_STANDARD_YEARLY(650),
    BRANDED_STUDIO_PLUS_YEARLY(660),
    BRANDED_GYM_YEARLY(670),
    BRANDED_GYM_PRO_YEARLY(680);
    
    private final int mask;

    private SubscriptionPlanType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static String getProductId(SubscriptionPlanType subscriptionPlanType) {
        if (subscriptionPlanType == APP_PREMIUM) {
            return "trainer_premium_monthly";
        }
        if (subscriptionPlanType == APP_TRAINER_BASIC) {
            return "trainer_basic_monthly_1";
        }
        if (subscriptionPlanType == APP_TRAINER_STANDARD) {
            return "trainer_standard_monthly_1";
        }
        if (subscriptionPlanType == APP_TRAINER_PLUS) {
            return "trainer_plus_monthly_1";
        }
        if (subscriptionPlanType == APP_STUDIO_BASIC) {
            return "studio_basic_monthly_1";
        }
        if (subscriptionPlanType == APP_STUDIO_STANDARD) {
            return "studio_standard_monthly_1";
        }
        if (subscriptionPlanType == APP_STUDIO_PLUS) {
            return "studio_plus_monthly_1";
        }
        if (subscriptionPlanType == APP_GYM) {
            return "gym_monthly_1";
        }
        throw new IllegalArgumentException();
    }

    public static SubscriptionPlanType getSubscriptionPlanType(int i) {
        if (i == 1) {
            return APP_FREEMIUM;
        }
        if (i == 2) {
            return APP_PREMIUM;
        }
        if (i == 3) {
            return WEB_TRAINER;
        }
        if (i == 4) {
            return WEB_TRAINER_PLUS;
        }
        if (i == 5) {
            return WEB_STUDIO;
        }
        if (i == 7) {
            return OTHER;
        }
        if (i == 110) {
            return APP_TRAINER_BASIC;
        }
        if (i == 120) {
            return APP_TRAINER_STANDARD;
        }
        if (i == 130) {
            return APP_TRAINER_PLUS;
        }
        if (i == 140) {
            return APP_STUDIO_BASIC;
        }
        if (i == 150) {
            return APP_STUDIO_STANDARD;
        }
        if (i == 160) {
            return APP_STUDIO_PLUS;
        }
        if (i == 310) {
            return WEB_TRAINER_BASIC;
        }
        if (i == 320) {
            return WEB_TRAINER_STANDARD;
        }
        if (i == 330) {
            return WEB_TRAINER_PLUS_2;
        }
        if (i == 340) {
            return WEB_STUDIO_BASIC;
        }
        if (i == 350) {
            return WEB_STUDIO_STANDARD;
        }
        if (i == 360) {
            return WEB_STUDIO_PLUS;
        }
        if (i == 370) {
            return WEB_GYM;
        }
        if (i == 380) {
            return WEB_GYM_PRO;
        }
        if (i == 410) {
            return WEB_TRAINER_BASIC_YEARLY;
        }
        if (i == 420) {
            return WEB_TRAINER_STANDARD_YEARLY;
        }
        if (i == 430) {
            return WEB_TRAINER_PLUS_2_YEARLY;
        }
        if (i == 440) {
            return WEB_STUDIO_BASIC_YEARLY;
        }
        if (i == 450) {
            return WEB_STUDIO_STANDARD_YEARLY;
        }
        if (i == 460) {
            return WEB_STUDIO_PLUS_YEARLY;
        }
        if (i == 470) {
            return WEB_GYM_YEARLY;
        }
        if (i == 480) {
            return WEB_GYM_PRO_YEARLY;
        }
        if (i == 510) {
            return BRANDED_TRAINER_BASIC;
        }
        if (i == 520) {
            return BRANDED_TRAINER_STANDARD;
        }
        if (i == 530) {
            return BRANDED_TRAINER_PLUS_2;
        }
        if (i == 540) {
            return BRANDED_STUDIO_BASIC;
        }
        if (i == 550) {
            return BRANDED_STUDIO_STANDARD;
        }
        if (i == 560) {
            return BRANDED_STUDIO_PLUS;
        }
        if (i == 570) {
            return BRANDED_GYM;
        }
        if (i == 580) {
            return BRANDED_GYM_PRO;
        }
        if (i == 610) {
            return BRANDED_TRAINER_BASIC_YEARLY;
        }
        if (i == 620) {
            return BRANDED_TRAINER_STANDARD_YEARLY;
        }
        if (i == 630) {
            return BRANDED_TRAINER_PLUS_2_YEARLY;
        }
        if (i == 640) {
            return BRANDED_STUDIO_BASIC_YEARLY;
        }
        if (i == 650) {
            return BRANDED_STUDIO_STANDARD_YEARLY;
        }
        if (i == 660) {
            return BRANDED_STUDIO_PLUS_YEARLY;
        }
        if (i == 670) {
            return BRANDED_GYM_YEARLY;
        }
        if (i == 680) {
            return BRANDED_GYM_PRO_YEARLY;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isAppPremiumPlan(SubscriptionPlanType subscriptionPlanType) {
        if (subscriptionPlanType != APP_PREMIUM) {
            return subscriptionPlanType.getMask() >= 100 && subscriptionPlanType.getMask() < 300;
        }
        return true;
    }
}
