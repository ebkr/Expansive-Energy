package ebkr.expansive.energy.mod.resolver;


import ebkr.expansive.energy.ExpansiveEnergy;
import ebkr.expansive.energy.annotations.registry.info.DisplayName;
import ebkr.expansive.energy.annotations.registry.type.IsBlock;
import ebkr.expansive.energy.annotations.registry.type.IsItem;
import ebkr.expansive.energy.annotations.registry.type.IsLootTable;
import ebkr.expansive.energy.annotations.registry.type.IsRecipe;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.lang.reflect.Field;
import java.util.Set;

public class DataGenResolver {

    public static void addRecipeProviders(GatherDataEvent event) {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(IsRecipe.class);
        items.forEach(aClass -> {
            try {
                RecipeProvider resolved = (RecipeProvider) aClass.getConstructor(event.getGenerator().getClass())
                        .newInstance(event.getGenerator());
                event.getGenerator().addProvider(resolved);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void addLootTableProviders(GatherDataEvent event) {
        Reflections reflections = new Reflections("ebkr.expansive.energy");
        Set<Class<?>> items = reflections.getTypesAnnotatedWith(IsLootTable.class);
        items.forEach(aClass -> {
            try {
                LootTableProvider resolved = (LootTableProvider) aClass.getConstructor(event.getGenerator().getClass())
                        .newInstance(event.getGenerator());
                event.getGenerator().addProvider(resolved);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void addLangProviders(DataGenerator generator) {
        generator.addProvider(new LanguageProvider(generator, ExpansiveEnergy.MOD_ID, "en_us") {
            @Override
            protected void addTranslations() {
                Reflections reflections = new Reflections(
                        "ebkr.expansive.energy",
                        new FieldAnnotationsScanner(),
                        new TypeAnnotationsScanner(),
                        new SubTypesScanner()
                );
                Set<Class<?>> items = reflections.getTypesAnnotatedWith(DisplayName.class);
                items.forEach(aClass -> {
                    String en_us = aClass.getAnnotation(DisplayName.class).en_us();
                    if (!en_us.isEmpty() && aClass.getAnnotation(IsBlock.class) != null) {
                        Block block = new ResolvedStorage<Block>().get(aClass);
                        add(block, en_us);
                    } else if (!en_us.isEmpty() && aClass.getAnnotation(IsItem.class) != null) {
                        Item item = new ResolvedStorage<Item>().get(aClass);
                        add(item, en_us);
                    }
                });
                Set<Field> fields = reflections.getFieldsAnnotatedWith(DisplayName.class);
                fields.forEach(field -> {
                    String en_us = field.getAnnotation(DisplayName.class).en_us();
                    if (!en_us.isEmpty() && field.getType().equals(ItemGroup.class)) {
                        try {
                            ItemGroup itemGroup = (ItemGroup) field.get(field.getDeclaringClass());
                            add(itemGroup.getTranslationKey(), en_us);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

}
