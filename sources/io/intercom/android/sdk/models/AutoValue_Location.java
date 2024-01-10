package io.intercom.android.sdk.models;

final class AutoValue_Location extends Location {
    private final String cityName;
    private final String countryName;
    private final Integer timezoneOffset;

    AutoValue_Location(String str, String str2, Integer num) {
        if (str != null) {
            this.cityName = str;
            if (str2 != null) {
                this.countryName = str2;
                this.timezoneOffset = num;
                return;
            }
            throw new NullPointerException("Null countryName");
        }
        throw new NullPointerException("Null cityName");
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public Integer getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public String toString() {
        return "Location{cityName=" + this.cityName + ", countryName=" + this.countryName + ", timezoneOffset=" + this.timezoneOffset + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        if (this.cityName.equals(location.getCityName()) && this.countryName.equals(location.getCountryName())) {
            Integer num = this.timezoneOffset;
            if (num == null) {
                if (location.getTimezoneOffset() == null) {
                    return true;
                }
            } else if (num.equals(location.getTimezoneOffset())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.cityName.hashCode() ^ 1000003) * 1000003) ^ this.countryName.hashCode()) * 1000003;
        Integer num = this.timezoneOffset;
        return hashCode ^ (num == null ? 0 : num.hashCode());
    }
}
