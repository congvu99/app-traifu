package io.intercom.android.sdk.models;

final class AutoValue_OperatorClientCondition extends OperatorClientCondition {
    private final String conditionId;
    private final String id;

    AutoValue_OperatorClientCondition(String str, String str2) {
        if (str != null) {
            this.id = str;
            if (str2 != null) {
                this.conditionId = str2;
                return;
            }
            throw new NullPointerException("Null conditionId");
        }
        throw new NullPointerException("Null id");
    }

    public String id() {
        return this.id;
    }

    public String conditionId() {
        return this.conditionId;
    }

    public String toString() {
        return "OperatorClientCondition{id=" + this.id + ", conditionId=" + this.conditionId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OperatorClientCondition)) {
            return false;
        }
        OperatorClientCondition operatorClientCondition = (OperatorClientCondition) obj;
        if (!this.id.equals(operatorClientCondition.id()) || !this.conditionId.equals(operatorClientCondition.conditionId())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.id.hashCode() ^ 1000003) * 1000003) ^ this.conditionId.hashCode();
    }
}
