package ebkr.expansive.energy.mod.resolver;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.type.IsItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import org.reflections.Reflections;

import java.util.Set;

public class ItemResolver {

    public static void registerAllItems(RegistryEvent.Register<Item> event) {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(IsItem.class);
        items.forEach(aClass -> {
            try {
                Item resolved = (Item) aClass.getConstructor(Item.Properties.class)
                        .newInstance(new Item.Properties());
                ResourceLocation location = new ResourceLocation(ExpansiveEnergy.MOD_ID,
                        resolved.getClass().getAnnotation(RegistryName.class).value());
                resolved.setRegistryName(location);
                event.getRegistry().register(resolved);
                new ResolvedStorage<Item>().set(resolved.getClass(), resolved);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        BlockResolver.registerItemBlocks(event);
    }

}
