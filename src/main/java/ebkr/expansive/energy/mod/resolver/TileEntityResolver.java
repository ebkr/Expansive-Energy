package ebkr.expansive.energy.mod.resolver;

import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.annotations.registry.info.ValidBlocksForTile;
import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.type.IsTile;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TileEntityResolver {

    public static void registerAllTiles(RegistryEvent.Register<TileEntityType<?>> event) {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(IsTile.class);
        items.forEach(aClass -> {
            try {
                Constructor<TileEntity> tileEntityConstructor = (Constructor<TileEntity>) aClass.getConstructor(TileEntityType.class);
                TileEntity tileEntity = tileEntityConstructor.newInstance((TileEntityType) null);

                List<Block> blockList = Arrays
                        .stream(tileEntity.getClass().getAnnotation(ValidBlocksForTile.class).value())
                        .map(blockClass -> new ResolvedStorage<Block>().get(blockClass))
                        .collect(Collectors.toList());

                Block[] blockArray = blockList.toArray(new Block[0]);

                TileEntityType resolved = TileEntityType.Builder.create(() -> {
                    try {
                        return tileEntityConstructor
                                .newInstance(new ResolvedStorage<TileEntityType>().get(tileEntity.getClass()));
                    } catch (Exception e) {
                        return null;
                    }
                }, blockArray).build(null);

                ResourceLocation location = new ResourceLocation(ExpansiveEnergy.MOD_ID,
                        tileEntity.getClass().getAnnotation(RegistryName.class).value());
                resolved.setRegistryName(location);
                event.getRegistry().register(resolved);
                new ResolvedStorage<TileEntityType>().set(tileEntity.getClass(), resolved);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
