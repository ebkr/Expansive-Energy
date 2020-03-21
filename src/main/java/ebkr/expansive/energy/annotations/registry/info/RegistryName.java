package ebkr.expansive.energy.annotations.registry.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RegistryName {
    String value();
}
