package ebkr.expansive.energy.mod.common.item;

import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.type.IsItem;
import ebkr.expansive.energy.mod.common.tab.Tabs;
import net.minecraft.item.Item;

@IsItem
@RegistryName("expansive_wrench")
public class ExpansiveWrenchItem extends Item {

    private static Properties build(Properties properties) {
        properties.group(Tabs.EXPANSIVE_ENERGY);
        return properties;
    }

    public ExpansiveWrenchItem(Properties properties) {
        super(build(properties));
    }
}
