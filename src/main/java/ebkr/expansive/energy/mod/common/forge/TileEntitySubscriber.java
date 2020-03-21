package ebkr.expansive.energy.mod.common.forge;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.mod.resolver.TileEntityResolver;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExpansiveEnergy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileEntitySubscriber {

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event) {
        TileEntityResolver.registerAllTiles(event);
    }

}
