package io.intercom.android.sdk.models.carousel;

import io.intercom.android.sdk.blocks.lib.models.Block;
import java.util.List;

final class AutoValue_CarouselScreen extends CarouselScreen {
    private final List<ScreenAction> actions;
    private final String backgroundColor;
    private final List<Block> blocks;
    private final String id;
    private final String textColor;
    private final String verticalAlignment;

    AutoValue_CarouselScreen(String str, String str2, String str3, List<Block> list, List<ScreenAction> list2, String str4) {
        if (str != null) {
            this.id = str;
            if (str2 != null) {
                this.backgroundColor = str2;
                if (str3 != null) {
                    this.textColor = str3;
                    if (list != null) {
                        this.blocks = list;
                        if (list2 != null) {
                            this.actions = list2;
                            if (str4 != null) {
                                this.verticalAlignment = str4;
                                return;
                            }
                            throw new NullPointerException("Null verticalAlignment");
                        }
                        throw new NullPointerException("Null actions");
                    }
                    throw new NullPointerException("Null blocks");
                }
                throw new NullPointerException("Null textColor");
            }
            throw new NullPointerException("Null backgroundColor");
        }
        throw new NullPointerException("Null id");
    }

    public String getId() {
        return this.id;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public List<ScreenAction> getActions() {
        return this.actions;
    }

    public String getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public String toString() {
        return "CarouselScreen{id=" + this.id + ", backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ", blocks=" + this.blocks + ", actions=" + this.actions + ", verticalAlignment=" + this.verticalAlignment + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CarouselScreen)) {
            return false;
        }
        CarouselScreen carouselScreen = (CarouselScreen) obj;
        if (!this.id.equals(carouselScreen.getId()) || !this.backgroundColor.equals(carouselScreen.getBackgroundColor()) || !this.textColor.equals(carouselScreen.getTextColor()) || !this.blocks.equals(carouselScreen.getBlocks()) || !this.actions.equals(carouselScreen.getActions()) || !this.verticalAlignment.equals(carouselScreen.getVerticalAlignment())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((this.id.hashCode() ^ 1000003) * 1000003) ^ this.backgroundColor.hashCode()) * 1000003) ^ this.textColor.hashCode()) * 1000003) ^ this.blocks.hashCode()) * 1000003) ^ this.actions.hashCode()) * 1000003) ^ this.verticalAlignment.hashCode();
    }
}
