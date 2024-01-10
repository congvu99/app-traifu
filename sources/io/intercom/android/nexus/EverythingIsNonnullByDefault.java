package io.intercom.android.nexus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@TypeQualifierDefault({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Nonnull
@Retention(RetentionPolicy.SOURCE)
@interface EverythingIsNonnullByDefault {
}
