package io.intercom.android.sdk.models.carousel;

import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.models.carousel.CarouselScreen;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;

public abstract class Carousel {
    public static final int ENTITY_TYPE = 44;
    public static final Carousel NULL;
    public static final Builder NULL_BUILDER;

    public abstract String getInstanceId();

    public abstract List<CarouselScreen> getScreens();

    public abstract boolean isDismissible();

    static {
        Builder builder = new Builder();
        NULL_BUILDER = builder;
        NULL = builder.build();
    }

    static Carousel create(List<CarouselScreen> list, boolean z, String str) {
        return new AutoValue_Carousel(list, z, str);
    }

    public static final class Builder {
        Boolean dismissible;
        String instance_id;
        List<CarouselScreen.Builder> screens;

        public Builder withScreens(List<CarouselScreen.Builder> list) {
            this.screens = list;
            return this;
        }

        public Builder withDismissible(Boolean bool) {
            this.dismissible = bool;
            return this;
        }

        public Builder withInstanceId(String str) {
            this.instance_id = str;
            return this;
        }

        public Carousel build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.screens));
            List<CarouselScreen.Builder> list = this.screens;
            if (list != null) {
                for (CarouselScreen.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            return Carousel.create(arrayList, NullSafety.valueOrDefault(this.dismissible, true), NullSafety.valueOrEmpty(this.instance_id));
        }
    }
}
