package com.andrewlray.mcmods.andrew_spartanmod.items.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

public final class SMRecipes {
	
	private static boolean initialized = false;
	
	public static void init() {
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(SMItems.oldLeathCapF, 1)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(SMItems.oldIronHelmF, 1)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(SMItems.oldGoldHelmF, 1)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(SMItems.oldDiamondHelmF, 1)));
		
		if (!initialized) {
			for (int i = 0; i < 15; ++i) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.leathCapF[i], 1, 0), new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.ironHelmF[i], 1, 0), new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.goldHelmF[i], 1, 0), new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.diamHelmF[i], 1, 0), new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(SMItems.colored_feather, 1, i)));
			}
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.leathCapF[15], 1, 0), new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.ironHelmF[15], 1, 0), new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.goldHelmF[15], 1, 0), new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.diamHelmF[15], 1, 0), new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new RecipesFeatheredArmorDyes());
			for (int i = 0; i < 15; i++) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.colored_feather, 1, i), new ItemStack(Items.feather, 1), new ItemStack(Items.dye, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.colored_feather, 1, i), new ItemStack(SMItems.colored_feather, 1), new ItemStack(Items.dye, 1, i)));
			}
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.feather, 1), new ItemStack(SMItems.colored_feather, 1), new ItemStack(Items.dye, 1, 15)));
		}
		initialized = true;
	}
}
