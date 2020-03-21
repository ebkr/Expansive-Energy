package ebkr.expansive.energy.mod.resolver;

import ebkr.expansive.energy.annotations.registry.info.RenderLayer;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderTypeLookup;
import org.reflections.Reflections;

import java.util.Set;

public class RenderLayerResolver {

    public static void resolveRenderLayers() {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(RenderLayer.class);
        items.forEach(aClass -> {
            try {
                Block block = new ResolvedStorage<Block>().get(aClass);
                RenderTypeLookup.setRenderLayer(block, aClass.getAnnotation(RenderLayer.class)
                        .value()
                        .get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
