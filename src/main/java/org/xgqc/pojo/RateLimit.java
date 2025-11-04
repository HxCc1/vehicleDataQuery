package org.xgqc.pojo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {
    int time() default 60;

    int count() default 10;

    LimitType limitType() default RateLimit.LimitType.USER;

    public static enum LimitType {
        IP,
        USER;

        private LimitType() {
        }
    }
}
