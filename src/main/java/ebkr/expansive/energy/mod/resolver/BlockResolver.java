package ebkr.expansive.energy.mod.resolver;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.annotations.registry.info.HasMaterial;
import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.type.IsBlock;
import ebkr.expansive.energy.annotations.registry.type.IsBlockItemOf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import org.reflections.Reflections;

import java.util.Set;

public class BlockResolver {

    public static void registerAllBlocks(RegistryEvent.Register<Block> event) {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(IsBlock.class);
        items.forEach(aClass -> {
            try {
                Material material = aClass.getAnnotation(HasMaterial.class)
                        .value()
                        .get();

                Block resolved = (Block) aClass.getConstructor(Block.Properties.class)
                        .newInstance(Block.Properties.create(material));

                ResourceLocation location = new ResourceLocation(ExpansiveEnergy.MOD_ID,
                        resolved.getClass().getAnnotation(RegistryName.class).value());
                resolved.setRegistryName(location);
                event.getRegistry().register(resolved);
                new ResolvedStorage<Block>().set(resolved.getClass(), resolved);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(IsBlockItemOf.class);
        items.forEach(aClass -> {
            try {
                Class blockClass = aClass.getAnnotation(IsBlockItemOf.class).value();
                Item.Properties properties = new Item.Properties();
                Item resolved = (Item) aClass.getConstructor(Item.Properties.class).newInstance(properties);
                Block block = new ResolvedStorage<Block>().get(blockClass);
                BlockItem blockItem = new BlockItem(block, properties);
                ResourceLocation location = new ResourceLocation(ExpansiveEnergy.MOD_ID,
                        block.getClass().getAnnotation(RegistryName.class).value());
                blockItem.setRegistryName(location);
                event.getRegistry().register(blockItem);
                new ResolvedStorage<BlockItem>().set(resolved.getClass(), blockItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
