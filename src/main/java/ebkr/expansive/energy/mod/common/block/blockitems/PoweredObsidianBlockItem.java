package ebkr.expansive.energy.mod.common.block.blockitems;

import ebkr.expansive.energy.annotations.registry.type.IsBlockItemOf;
import ebkr.expansive.energy.mod.common.block.PoweredObsidianBlock;
import ebkr.expansive.energy.mod.common.tab.Tabs;
import net.minecraft.item.Item;

@IsBlockItemOf(PoweredObsidianBlock.class)
public class PoweredObsidianBlockItem extends Item {

    public PoweredObsidianBlockItem(Properties properties) {
        super(properties.group(Tabs.EXPANSIVE_ENERGY));
    }

}
