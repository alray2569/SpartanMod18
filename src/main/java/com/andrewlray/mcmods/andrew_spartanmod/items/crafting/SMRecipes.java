package com.andrewlray.mcmods.andrew_spartanmod.items.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.andrewlray.mcmods.andrew_spartanmod.items.ColoredFeather;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

public final class SMRecipes {
	
	private static boolean initialized = false;
	
	public static void init() {
		if (!initialized) {
		// Converter recipes for old helmets.
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(SMItems.oldLeathCapF, 1, OreDictionary.WILDCARD_VALUE)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(SMItems.oldIronHelmF, 1, OreDictionary.WILDCARD_VALUE)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(SMItems.oldGoldHelmF, 1, OreDictionary.WILDCARD_VALUE)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(SMItems.oldDiamondHelmF, 1, OreDictionary.WILDCARD_VALUE)));
			
			for (int i = 0; i < ColoredFeather.SUBS; ++i) {
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
			
			for (int i = 0; i < ColoredFeather.SUBS; ++i) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.colored_feather, 1, i), new ItemStack(Items.feather, 1), new ItemStack(Items.dye, 1, i)));
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(SMItems.colored_feather, 1, i), new ItemStack(SMItems.colored_feather, 1), new ItemStack(Items.dye, 1, i)));
			}
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.feather, 1), new ItemStack(SMItems.colored_feather, 1), new ItemStack(Items.dye, 1, 15)));
			
			// Dye converters
			String colorNames[] = new String[] { "Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White" };
			for (int i = 0; i < ItemDye.dyeColors.length; ++i) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.dye, 1, i), "dye" + colorNames[i]));
			}
		}
		initialized = true;
	}
}
