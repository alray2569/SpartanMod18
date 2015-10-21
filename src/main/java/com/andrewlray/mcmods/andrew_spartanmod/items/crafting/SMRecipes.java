package com.andrewlray.mcmods.andrew_spartanmod.items.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

public final class SMRecipes {
	
	private static boolean initialized = false;
	
	public static void init() {
		if (!initialized) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.leathCapF, 1, 0), new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.ironHelmF, 1, 0), new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.goldHelmF, 1, 0), new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.diamHelmF, 1, 0), new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(Items.feather, 1)));
			GameRegistry.addRecipe(new RecipesFeatheredArmorDyes());
		}
		initialized = true;
	}
}
