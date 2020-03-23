package ebkr.expansive.energy.mod.data.loottables;

import ebkr.expansive.energy.annotations.registry.type.IsLootTable;
import ebkr.expansive.energy.mod.common.block.EnergyBankBlock;
import ebkr.expansive.energy.mod.resolver.ResolvedStorage;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;

import java.util.Objects;

@IsLootTable
public class EnergyBankBlockLootTable extends BaseLootTableProvider {

    public EnergyBankBlockLootTable(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    public void addTables() {
        Block block = new ResolvedStorage<Block>().get(EnergyBankBlock.class);
        lootTables.put(block, createStandardTable(Objects.requireNonNull(block.getRegistryName()).toString(), block));
    }
}
