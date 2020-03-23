package ebkr.expansive.energy.mod.common.block.blockitems;

import ebkr.expansive.energy.annotations.registry.type.IsBlockItemOf;
import ebkr.expansive.energy.mod.common.block.EnergyBankBlock;
import ebkr.expansive.energy.mod.common.tab.Tabs;
import net.minecraft.item.Item;

@IsBlockItemOf(EnergyBankBlock.class)
public class EnergyBankBlockItem extends Item {

    public EnergyBankBlockItem(Properties properties) {
        super(properties.group(Tabs.EXPANSIVE_ENERGY));
    }

}
