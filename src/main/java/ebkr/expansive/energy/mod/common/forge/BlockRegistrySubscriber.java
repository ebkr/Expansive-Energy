package ebkr.expansive.energy.mod.common.forge;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.mod.resolver.BlockResolver;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = ExpansiveEnergy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistrySubscriber {

    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onRegisterBlocks(final RegistryEvent.Register<Block> event) {
        BlockResolver.registerAllBlocks(event);
    }

}
