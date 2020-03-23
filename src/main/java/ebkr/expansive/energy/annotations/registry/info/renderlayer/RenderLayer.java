package ebkr.expansive.energy.annotations.registry.info.renderlayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RenderLayer {
    RenderLookupType value();
}
