package ebkr.expansive.energy.annotations.registry.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IsBlockItemOf {
    Class value();
}
