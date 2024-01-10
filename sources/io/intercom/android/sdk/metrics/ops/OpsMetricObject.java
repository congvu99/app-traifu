package io.intercom.android.sdk.metrics.ops;

import kotlinx.serialization.json.internal.JsonLexerKt;

public class OpsMetricObject {
    private final String id;
    private final String name;
    private final String type;
    private final long value;

    public OpsMetricObject(String str, String str2, long j, String str3) {
        this.type = str;
        this.name = str2;
        this.value = j;
        this.id = str3;
    }

    public String getId() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OpsMetricObject opsMetricObject = (OpsMetricObject) obj;
        if (this.value == opsMetricObject.value && this.type.equals(opsMetricObject.type) && this.name.equals(opsMetricObject.name)) {
            return this.id.equals(opsMetricObject.id);
        }
        return false;
    }

    public int hashCode() {
        long j = this.value;
        return (((((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "OpsMetricObject{type='" + this.type + '\'' + ", name='" + this.name + '\'' + ", value=" + this.value + ", id='" + this.id + '\'' + JsonLexerKt.END_OBJ;
    }
}
