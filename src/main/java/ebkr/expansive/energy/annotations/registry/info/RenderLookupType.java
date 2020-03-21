package ebkr.expansive.energy.annotations.registry.info;

import net.minecraft.client.renderer.RenderType;

import java.util.function.Supplier;

public enum RenderLookupType {

    SOLID(RenderType::getSolid),
    CUTOUT_MIPPED(RenderType::getCutoutMipped),
    CUTOUT(RenderType::getCutout),
    TRANSLUCENT(RenderType::getTranslucent),
    TRANSLUCENT_NO_CRUMBLING(RenderType::getTranslucentNoCrumbling),
    LEASH(RenderType::getLeash),
    WATER_MASK(RenderType::getWaterMask),
    GLINT(RenderType::getGlint),
    ENTITY_GLINT(RenderType::getEntityGlint),
    LIGHTNING(RenderType::getLightning),
    LINES(RenderType::getLines);

    private Supplier<RenderType> supplier;

    RenderLookupType(Supplier<RenderType> supplier) {
        this.supplier = supplier;
    }

    public RenderType get() {
        return supplier.get();
    }
}
