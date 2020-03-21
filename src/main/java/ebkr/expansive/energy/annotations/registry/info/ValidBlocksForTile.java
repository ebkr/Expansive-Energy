package ebkr.expansive.energy.annotations.registry.info;

import net.minecraft.block.Block;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBlocksForTile {
    Class<? extends Block>[] value();
}
