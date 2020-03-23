package ebkr.expansive.energy.mod.common.forge;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.mod.resolver.DataGenResolver;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = ExpansiveEnergy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenSubscriber {

    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void registerRecipes(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        LOGGER.warn("ADDING PROVIDER");
        DataGenResolver.addLangProviders(generator);
        if (event.includeServer()) {
            DataGenResolver.addRecipeProviders(event);
            DataGenResolver.addLootTableProviders(event);
        }
    }

}
