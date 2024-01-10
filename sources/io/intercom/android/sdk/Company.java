package io.intercom.android.sdk;

import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.utilities.CustomAttributeValidator;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class Company {
    private static final String COMPANY_ID = "id";
    private static final String CREATED_AT = "created_at";
    private static final String CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String MONTHLY_SPEND = "monthly_spend";
    private static final String NAME = "name";
    private static final String PLAN = "plan";
    /* access modifiers changed from: private */
    public static final Twig TWIG = LumberMill.getLogger();
    private final Map<String, Object> attributes;
    private final Map<String, Object> customAttributes;

    Company(Builder builder) {
        this.attributes = builder.attributes;
        this.customAttributes = builder.customAttributes;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getAttributes() {
        if (!this.customAttributes.isEmpty()) {
            this.attributes.put(CUSTOM_ATTRIBUTES, this.customAttributes);
        }
        return this.attributes;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Company company = (Company) obj;
        if (!this.attributes.equals(company.attributes)) {
            return false;
        }
        return this.customAttributes.equals(company.customAttributes);
    }

    public int hashCode() {
        return (this.attributes.hashCode() * 31) + this.customAttributes.hashCode();
    }

    public String toString() {
        return "Company{attributes=" + this.attributes + ", customAttributes=" + this.customAttributes + JsonLexerKt.END_OBJ;
    }

    public static final class Builder {
        final Map<String, Object> attributes = new HashMap();
        final Map<String, Object> customAttributes = new HashMap();

        public Company build() {
            return new Company(this);
        }

        public Builder withCompanyId(String str) {
            this.attributes.put("id", str);
            return this;
        }

        public Builder withName(String str) {
            this.attributes.put("name", str);
            return this;
        }

        public Builder withCreatedAt(Long l) {
            this.attributes.put(Company.CREATED_AT, l);
            return this;
        }

        public Builder withMonthlySpend(Integer num) {
            this.attributes.put(Company.MONTHLY_SPEND, num);
            return this;
        }

        public Builder withPlan(String str) {
            this.attributes.put(Company.PLAN, str);
            return this;
        }

        public Builder withCustomAttribute(String str, Object obj) {
            if (str == null) {
                Twig access$000 = Company.TWIG;
                access$000.w("The key you provided was null for the attribute " + obj, new Object[0]);
            } else if (CustomAttributeValidator.isValid(obj)) {
                this.customAttributes.put(str, obj);
            } else {
                Twig access$0002 = Company.TWIG;
                access$0002.w("The custom company attribute " + str + " was of type " + obj.getClass().getSimpleName() + " We only accept the following types: " + CustomAttributeValidator.getAcceptedTypes(), new Object[0]);
            }
            return this;
        }

        public Builder withCustomAttributes(Map<String, ?> map) {
            if (map == null) {
                Company.TWIG.w("The map of attributes you provided was null.", new Object[0]);
            } else {
                for (Map.Entry next : map.entrySet()) {
                    if (CustomAttributeValidator.isValid(next.getValue())) {
                        this.customAttributes.put((String) next.getKey(), next.getValue());
                    } else {
                        Twig access$000 = Company.TWIG;
                        access$000.w("The custom company attribute " + ((String) next.getKey()) + " was of type " + next.getClass().getSimpleName() + " We only accept the following types: " + CustomAttributeValidator.getAcceptedTypes(), new Object[0]);
                    }
                }
            }
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            if (!this.attributes.equals(builder.attributes)) {
                return false;
            }
            return this.customAttributes.equals(builder.customAttributes);
        }

        public int hashCode() {
            return (this.attributes.hashCode() * 31) + this.customAttributes.hashCode();
        }

        public String toString() {
            return "Builder{attributes=" + this.attributes + ", customAttributes=" + this.customAttributes + JsonLexerKt.END_OBJ;
        }
    }
}
