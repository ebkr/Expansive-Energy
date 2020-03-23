package ebkr.expansive.energy.mod.common.block;

import ebkr.expansive.energy.annotations.registry.info.*;
import ebkr.expansive.energy.annotations.registry.info.material.BlockMaterials;
import ebkr.expansive.energy.annotations.registry.info.material.HasMaterial;
import ebkr.expansive.energy.annotations.registry.info.renderlayer.RenderLayer;
import ebkr.expansive.energy.annotations.registry.info.renderlayer.RenderLookupType;
import ebkr.expansive.energy.annotations.registry.type.IsBlock;
import net.minecraft.block.Block;

@IsBlock
@RegistryName("energy_bank")
@DisplayName(en_us = "Energy Bank")
@HasMaterial(BlockMaterials.ENERGY_ROUTER)
@RenderLayer(RenderLookupType.CUTOUT_MIPPED)
public class EnergyBankBlock extends Block {

    private static Properties build(Properties properties) {
        properties.notSolid()
                .hardnessAndResistance(200, 2);
        return properties;
    }

    public EnergyBankBlock(Properties properties) {
        super(build(properties));
    }
}
