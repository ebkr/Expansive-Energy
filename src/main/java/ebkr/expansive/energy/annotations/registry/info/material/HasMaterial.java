package ebkr.expansive.energy.annotations.registry.info.material;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HasMaterial {
    BlockMaterials value();
}
