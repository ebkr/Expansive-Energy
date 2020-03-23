package ebkr.expansive.energy.mod.common.block;

import ebkr.expansive.energy.annotations.registry.info.DisplayName;
import ebkr.expansive.energy.annotations.registry.info.material.BlockMaterials;
import ebkr.expansive.energy.annotations.registry.info.material.HasMaterial;
import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.type.IsBlock;
import net.minecraft.block.Block;

@IsBlock
@RegistryName("powered_obsidian")
@DisplayName(en_us = "Powered Obsidian")
@HasMaterial(BlockMaterials.SHULKER)
public class PoweredObsidianBlock extends Block {

    private static Properties build(Properties properties) {
        properties.hardnessAndResistance(500, 2000);
        return properties;
    }

    public PoweredObsidianBlock(Properties properties) {
        super(build(properties));
    }

}
