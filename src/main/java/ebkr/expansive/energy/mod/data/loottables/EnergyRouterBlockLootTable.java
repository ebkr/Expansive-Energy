package ebkr.expansive.energy.mod.data.loottables;

import ebkr.expansive.energy.annotations.registry.type.IsLootTable;
import ebkr.expansive.energy.mod.common.block.EnergyRouterBlock;
import ebkr.expansive.energy.mod.resolver.ResolvedStorage;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;

import java.util.Objects;

@IsLootTable
public class EnergyRouterBlockLootTable extends BaseLootTableProvider {

    public EnergyRouterBlockLootTable(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        Block block = new ResolvedStorage<Block>().get(EnergyRouterBlock.class);
        lootTables.put(block, createStandardTable(Objects.requireNonNull(block.getRegistryName()).toString(), block));
    }
}
