package ebkr.expansive.energy.annotations.registry.info.material;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

import java.util.function.Supplier;

public enum BlockMaterials {

    AIR(() -> Material.AIR),
    STRUCTURE_VOID(() -> Material.STRUCTURE_VOID),
    PORTAL(() -> Material.PORTAL),
    CARPET(() -> Material.CARPET),
    PLANTS(() -> Material.PLANTS),
    OCEAN_PLANT(() -> Material.OCEAN_PLANT),
    TALL_PLANTS(() -> Material.TALL_PLANTS),
    SEA_GRASS(() -> Material.SEA_GRASS),
    WATER(() -> Material.WATER),
    BUBBLE_COLUMN(() -> Material.BUBBLE_COLUMN),
    LAVA(() -> Material.LAVA),
    SNOW(() -> Material.SNOW),
    FIRE(() -> Material.FIRE),
    MISCELLANEOUS(() -> Material.MISCELLANEOUS),
    WEB(() -> Material.WEB),
    REDSTONE_LIGHT(() -> Material.REDSTONE_LIGHT),
    CLAY(() -> Material.CLAY),
    EARTH(() -> Material.EARTH),
    ORGANIC(() -> Material.ORGANIC),
    PACKED_ICE(() -> Material.PACKED_ICE),
    SAND(() -> Material.SAND),
    SPONGE(() -> Material.SPONGE),
    SHULKER(() -> Material.SHULKER),
    WOOD(() -> Material.WOOD),
    BAMBOO_SAPLING(() -> Material.BAMBOO_SAPLING),
    BAMBOO(() -> Material.BAMBOO),
    WOOL(() -> Material.WOOL),
    TNT(() -> Material.TNT),
    LEAVES(() -> Material.LEAVES),
    GLASS(() -> Material.GLASS),
    ICE(() -> Material.ICE),
    CACTUS(() -> Material.CACTUS),
    ROCK(() -> Material.ROCK),
    IRON(() -> Material.IRON),
    SNOW_BLOCK(() -> Material.SNOW_BLOCK),
    ANVIL(() -> Material.ANVIL),
    BARRIER(() -> Material.BARRIER),
    PISTON(() -> Material.PISTON),
    CORAL(() -> Material.CORAL),
    GOURD(() -> Material.GOURD),
    DRAGON_EGG(() -> Material.DRAGON_EGG),
    CAKE(() -> Material.CAKE),

    // Custom
    ENERGY_ROUTER(() -> new Material(
            MaterialColor.PURPLE,
            false,
            true,
            true,
            true,
            true,
            true,
            false,
            PushReaction.BLOCK)
    );

    private Supplier<Material> materialSupplier;

    BlockMaterials(Supplier<Material> materialSupplier) {
        this.materialSupplier = materialSupplier;
    }

    public Material get() {
        return this.materialSupplier.get();
    }
}
