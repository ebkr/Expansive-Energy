package ebkr.expansive.energy.mod.common.forge;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.mod.resolver.ItemResolver;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExpansiveEnergy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistrySubscriber {

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        ItemResolver.registerAllItems(event);
    }

}
