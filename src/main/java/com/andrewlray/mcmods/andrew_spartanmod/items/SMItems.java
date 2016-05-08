package com.andrewlray.mcmods.andrew_spartanmod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
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
	public static ArmorMaterial leatherF[];

	/** The armor material for the feathered iron helmet. */
	public static ArmorMaterial ironF = EnumHelper.addArmorMaterial("IronF", Constants.MODID + ":" + Constants.ironHelmFName, 15, new int[] { 2, 6, 5, 2 }, 9);

	/** The armor material for the feathered gold helmet. */
	public static ArmorMaterial goldF = EnumHelper.addArmorMaterial("GoldF", Constants.MODID + ":" + Constants.goldHelmFName, 7, new int[] { 2, 5, 3, 1 }, 25);

	/** The armor material for the feathered diamond helmet. */
	public static ArmorMaterial diamondF = EnumHelper.addArmorMaterial("DiamondF", Constants.MODID + ":" + Constants.diamHelmFName, 33, new int[] { 3, 8, 6, 3 }, 10);

	/** The colored feathers */
	public static Item colored_feather;
	
	/** The feathered leather cap. */
	public static Item leathCapF[];

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

			leatherF = new ArmorMaterial[16];
			for (int i = 0; i < 16; ++i) {
				leatherF[i] = EnumHelper.addArmorMaterial("LeatherF" + i, Constants.MODID + ":" + Constants.leathCapFName + i, 5, new int[] { 1, 3, 2, 1 }, 15);
				leatherF[i].customCraftingMaterial = Items.leather;
			}
			
			ironF.customCraftingMaterial = Items.iron_ingot;
			goldF.customCraftingMaterial = Items.gold_ingot;
			diamondF.customCraftingMaterial = Items.diamond;
			
			leathCapF = new Item[16];
			for (int i = 0; i < 16; ++i) {
				leathCapF[i] = new FeatheredArmor(leatherF[i], Constants.leathCapFID * 16 + i, 0, true).setUnlocalizedName(Constants.leathCapFName + i);
			}

			colored_feather = new ColoredFeather().setUnlocalizedName(Constants.featherName);
			ironHelmF = new FeatheredArmor(ironF, Constants.ironHelmFID, 0, false).setUnlocalizedName(Constants.ironHelmFName);
			goldHelmF = new FeatheredArmor(goldF, Constants.goldHelmFID, 0, false).setUnlocalizedName(Constants.goldHelmFName);
			diamHelmF = new FeatheredArmor(diamondF, Constants.diamHelmFID, 0, false).setUnlocalizedName(Constants.diamHelmFName);
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
			GameRegistry.registerItem(colored_feather, Constants.featherName);
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(leathCapF[i], Constants.leathCapFName + i);
			}
			GameRegistry.registerItem(ironHelmF, Constants.ironHelmFName);
			GameRegistry.registerItem(goldHelmF, Constants.goldHelmFName);
			GameRegistry.registerItem(diamHelmF, Constants.diamHelmFName);

			if (side == Side.CLIENT) {
				RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
				
				for (int i = 0; i < 16; ++i) {
					renderItem.getItemModelMesher().register(leathCapF[i], 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.leathCapFName + i, "inventory"));
				}
				renderItem.getItemModelMesher().register(ironHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.ironHelmFName, "inventory"));
				renderItem.getItemModelMesher().register(goldHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.goldHelmFName, "inventory"));
				renderItem.getItemModelMesher().register(diamHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.diamHelmFName, "inventory"));
				for (int i = 0; i < 15; i++) {
					ModelBakery.addVariantName(colored_feather, Constants.MODID + ":" + Constants.featherName + "_" + EnumDyeColor.byDyeDamage(i).getUnlocalizedName());
					renderItem.getItemModelMesher().register(colored_feather, i, new ModelResourceLocation(Constants.MODID + ":" + Constants.featherName + "_" + EnumDyeColor.byDyeDamage(i).getUnlocalizedName(), "inventory"));
				}
			}

		}
		initialized = true;
	}

}
