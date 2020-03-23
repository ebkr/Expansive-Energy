package ebkr.expansive.energy.annotations.registry.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DisplayName {
    String en_us() default "";
}
