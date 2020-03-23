package ebkr.expansive.energy.mod.data.recipes;

import ebkr.expansive.energy.annotations.registry.type.IsRecipe;
import ebkr.expansive.energy.mod.common.block.PoweredObsidianBlock;
import ebkr.expansive.energy.mod.resolver.ResolvedStorage;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

@IsRecipe
public class PoweredObsidianRecipe extends RecipeProvider {

    public PoweredObsidianRecipe(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        Block poweredObsidian = new ResolvedStorage<Block>().get(PoweredObsidianBlock.class);
        ShapedRecipeBuilder.shapedRecipe(poweredObsidian)
                .patternLine("rrr")
                .patternLine("ror")
                .patternLine("rrr")
                .key('r', Tags.Items.DUSTS_REDSTONE)
                .key('o', Tags.Items.OBSIDIAN)
                .addCriterion("has_obsidian", this.hasItem(Tags.Items.OBSIDIAN))
                .addCriterion("has_redstone", this.hasItem(Tags.Items.DUSTS_REDSTONE))
                .build(consumer);
    }

}
