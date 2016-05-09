package com.andrewlray.mcmods.andrew_spartanmod.items.crafting;

import com.andrewlray.mcmods.andrew_spartanmod.items.ColoredFeather;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Handles Ore Dictionary registration for things that need it.
 * 
 * @author Andrew Ray
 * @since version 1.1.0.1
 * @version 1.1.0.1
 */
public class SMOreDictHandler {

	private static boolean initialized = false;

	/**
	 * Initializes Ore Dictionary synonyms
	 * 
	 * @since version 1.1.0.1
	 * @version 1.1.0.1
	 */
	public static final void init() {
		if (!initialized) {
			for (int i = 0; i < ColoredFeather.SUBS; ++i) {
				OreDictionary.registerOre(
						"feather", new ItemStack(SMItems.colored_feather, 0, i));
			}
			initialized = true;
		}
	}
}