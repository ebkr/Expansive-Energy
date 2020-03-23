package ebkr.expansive.energy.mod.common.block;

import ebkr.expansive.energy.annotations.registry.info.DisplayName;
import ebkr.expansive.energy.annotations.registry.info.material.BlockMaterials;
import ebkr.expansive.energy.annotations.registry.info.material.HasMaterial;
import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.type.IsBlock;
import ebkr.expansive.energy.mod.common.tile.EnergyRouterTile;
import ebkr.expansive.energy.mod.resolver.ResolvedStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

@IsBlock
@RegistryName("energy_router")
@DisplayName(en_us = "Energy Router")
@HasMaterial(BlockMaterials.ENERGY_ROUTER)
public class EnergyRouterBlock extends Block {

    private static Properties build(Properties properties) {
        properties.notSolid()
                .hardnessAndResistance(200, 2);
        return properties;
    }

    public EnergyRouterBlock(Properties properties) {
        super(build(properties));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ResolvedStorage<TileEntityType>().get(EnergyRouterTile.class).create();
    }
}
