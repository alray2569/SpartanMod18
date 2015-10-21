package com.andrewlray.mcmods.andrew_spartanmod.lib;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class SMUtil {

	/**
	 * Strips the leading tile., item., entity., etc. from the ulname.
	 * 
	 * @param unlocalizedName
	 *            The ulname.
	 * @return the ulname with the prefix stripped.
	 */
	public static final String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
	}

	/**
	 * Returns the resource name (MODID:NAME)
	 * 
	 * @param item
	 *            the {@linkplain Item} to get the resource name for.
	 * @return the resource name
	 */
	public static final String getResourceName(Item item) {
		// Does this need to override getUnlocalizedName()?
		return String.format("%s:%s", Constants.MODID, getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
	}

	/**
	 * Returns the resource name (MODID:NAME)
	 * 
	 * @param block
	 *            the {@linkplain Block} to get the resource name for.
	 * @return the resource name
	 */
	public static final String getResourceName(Block block) {
		return String.format("%s:%s", Constants.MODID, getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
	}

}
