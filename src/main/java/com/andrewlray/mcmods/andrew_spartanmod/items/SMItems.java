package com.andrewlray.mcmods.andrew_spartanmod.items;

import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.diamHelmFID;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.diamHelmFName;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.goldHelmFID;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.goldHelmFName;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.ironHelmFID;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.ironHelmFName;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.leathCapFID;
import static com.andrewlray.mcmods.andrew_spartanmod.lib.Constants.leathCapFName;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;

public class SMItems {

	/** true iff this class has been preinitialized. */
	private static boolean preinitialized = false;

	/** true iff this class has been initialized. */
	private static boolean initialized = false;

	/** The armor material for the feathered leather cap */
	public static ArmorMaterial leatherF = EnumHelper.addArmorMaterial("LeatherF", Constants.MODID + ":" + Constants.leathCapFName, 5, new int[] { 1, 3, 2, 1 }, 15);

	/** The armor material for the feathered iron helmet. */
	public static ArmorMaterial ironF = EnumHelper.addArmorMaterial("IronF", Constants.MODID + ":" + Constants.ironHelmFName, 15, new int[] { 2, 6, 5, 2 }, 9);

	/** The armor material for the feathered gold helmet. */
	public static ArmorMaterial goldF = EnumHelper.addArmorMaterial("GoldF", Constants.MODID + ":" + Constants.goldHelmFName, 7, new int[] { 2, 5, 3, 1 }, 25);

	/** The armor material for the feathered diamond helmet. */
	public static ArmorMaterial diamondF = EnumHelper.addArmorMaterial("DiamondF", Constants.MODID + ":" + Constants.diamHelmFName, 33, new int[] { 3, 8, 6, 3 }, 10);

	/** The feathered leather cap. */
	public static Item leathCapF;

	/** The feathered iron helmet. */
	public static Item ironHelmF;

	/** The feathered gold helmet. */
	public static Item goldHelmF;

	/** The feathered diamond helmet. */
	public static Item diamHelmF;

	/**
	 * Preinitializes the SMItems class by initializing the armor materials and
	 * armor.
	 */
	public static void preInit() {
		if (!preinitialized) /* Only run once! */{

			leatherF.customCraftingMaterial = Items.leather;
			ironF.customCraftingMaterial = Items.iron_ingot;
			goldF.customCraftingMaterial = Items.gold_ingot;
			diamondF.customCraftingMaterial = Items.diamond;

			leathCapF = new FeatheredArmor(leatherF, leathCapFID, 0).setUnlocalizedName(leathCapFName);
			ironHelmF = new FeatheredArmor(ironF, ironHelmFID, 0).setUnlocalizedName(ironHelmFName);
			goldHelmF = new FeatheredArmor(goldF, goldHelmFID, 0).setUnlocalizedName(goldHelmFName);
			diamHelmF = new FeatheredArmor(diamondF, diamHelmFID, 0).setUnlocalizedName(diamHelmFName);
		}
		preinitialized = true;
	}

	/**
	 * Initializes the SMItems class by registering the armor with the
	 * GameRegistry.
	 * 
	 * @see GameRegistry#registerItem(Item, String)
	 */
	public static void init(Side side) {
		if (!initialized) /* Only run once! */{
			GameRegistry.registerItem(leathCapF, leathCapFName);
			GameRegistry.registerItem(ironHelmF, ironHelmFName);
			GameRegistry.registerItem(goldHelmF, goldHelmFName);
			GameRegistry.registerItem(diamHelmF, diamHelmFName);

			if (side == Side.CLIENT) {
				RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

				renderItem.getItemModelMesher().register(leathCapF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.leathCapFName, "inventory"));
				renderItem.getItemModelMesher().register(ironHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.ironHelmFName, "inventory"));
				renderItem.getItemModelMesher().register(goldHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.goldHelmFName, "inventory"));
				renderItem.getItemModelMesher().register(diamHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.diamHelmFName, "inventory"));
			}

		}
		initialized = true;
	}

}
