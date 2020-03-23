package ebkr.expansive.energy.mod.common.tab;

import ebkr.expansive.energy.annotations.registry.info.DisplayName;
import ebkr.expansive.energy.mod.common.item.ExpansiveWrenchItem;
import ebkr.expansive.energy.mod.resolver.ResolvedStorage;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Tabs {

    @DisplayName(en_us = "Expansive Energy")
    public static ItemGroup EXPANSIVE_ENERGY = new ItemGroup("expansiveenergy") {
        @Override
        public ItemStack createIcon() {
            return new ResolvedStorage<ExpansiveWrenchItem>().get(ExpansiveWrenchItem.class).asItem()
                    .getDefaultInstance();
        }
    };

}
