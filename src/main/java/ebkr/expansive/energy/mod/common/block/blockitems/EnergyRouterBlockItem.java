package ebkr.expansive.energy.mod.common.block.blockitems;

import ebkr.expansive.energy.annotations.registry.type.IsBlockItemOf;
import ebkr.expansive.energy.mod.common.block.EnergyRouterBlock;
import ebkr.expansive.energy.mod.common.tab.Tabs;
import net.minecraft.item.Item;

@IsBlockItemOf(EnergyRouterBlock.class)
public class EnergyRouterBlockItem extends Item {

    public EnergyRouterBlockItem(Properties properties) {
        super(properties.group(Tabs.EXPANSIVE_ENERGY));
    }
}
