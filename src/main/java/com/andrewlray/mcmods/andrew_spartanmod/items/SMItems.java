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

	/** 
	 * The armor material for the feathered leather cap 
	 * 
	 * @since version 1.1
	 */
	public static ArmorMaterial leatherF[];

	/** 
	 * The armor material for the feathered iron helmet.  
	 * 
	 * @since version 1.1
	 */
	public static ArmorMaterial ironF[];

	/** 
	 * The armor material for the feathered gold helmet.  
	 * 
	 * @since version 1.1
	 */
	public static ArmorMaterial goldF[];

	/** 
	 * The armor material for the feathered diamond helmet.  
	 * 
	 * @since version 1.1
	 */
	public static ArmorMaterial diamondF[];

	/** 
	 * The colored feathers  
	 * 
	 * @since version 1.1
	 */
	public static Item colored_feather;

	/** 
	 * The feathered leather cap.  
	 * 
	 * @since version 1.1
	 */
	public static Item leathCapF[];

	/** 
	 * The feathered iron helmet.  
	 * 
	 * @since version 1.1
	 */
	public static Item ironHelmF[];

	/** 
	 * The feathered gold helmet.  
	 * 
	 * @since version 1.1
	 */
	public static Item goldHelmF[];

	/** 
	 * The feathered diamond helmet.  
	 * 
	 * @since version 1.1
	 */
	public static Item diamHelmF[];

	/**
	 * Old Leather F Material
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static ArmorMaterial oldLeatherF;

	/**
	 * Old Iron F Material
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static ArmorMaterial oldIronF;

	/**
	 * Old Gold F Material
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static ArmorMaterial oldGoldF;

	/**
	 * Old Diamond F Material
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static ArmorMaterial oldDiamondF;

	/**
	 * Old Leather Helmet
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldLeathCapF;

	/**
	 * Old Iron Helmet
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldIronHelmF;

	/**
	 * Old Gold Helmet
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldGoldHelmF;

	/**
	 * Old Diamond Helmet
	 * 
	 * @deprecated version 1.1
	 */
	@Deprecated
	public static Item oldDiamondHelmF;

	/**
	 * Preinitializes the SMItems class by initializing the armor materials and
	 * armor.
	 */
	public static void preInit() {
		if (!preinitialized) /* Only run once! */ {

			leatherF = new ArmorMaterial[16];
			ironF = new ArmorMaterial[16];
			goldF = new ArmorMaterial[16];
			diamondF = new ArmorMaterial[16];
			for (int i = 0; i < 16; ++i) {
				leatherF[i] = EnumHelper.addArmorMaterial("LeatherF" + i, Constants.MODID + ":" + Constants.leathCapFName + i, 5, new int[] { 1, 3, 2, 1 }, 15);
				leatherF[i].customCraftingMaterial = Items.leather;
				ironF[i] = EnumHelper.addArmorMaterial("IronF", Constants.MODID + ":" + Constants.ironHelmFName + i, 15, new int[] { 2, 6, 5, 2 }, 9);
				ironF[i].customCraftingMaterial = Items.iron_ingot;
				goldF[i] = EnumHelper.addArmorMaterial("GoldF", Constants.MODID + ":" + Constants.goldHelmFName + i, 7, new int[] { 2, 5, 3, 1 }, 25);
				goldF[i].customCraftingMaterial = Items.gold_ingot;
				diamondF[i] = EnumHelper.addArmorMaterial("DiamondF", Constants.MODID + ":" + Constants.diamHelmFName + i, 33, new int[] { 3, 8, 6, 3 }, 10);
				diamondF[i].customCraftingMaterial = Items.diamond;
			}

			oldLeatherF = EnumHelper.addArmorMaterial("LeatherF", Constants.MODID + ":" + Constants.leathCapFName, 5, new int[] { 1, 3, 2, 1 }, 15);
			oldIronF = EnumHelper.addArmorMaterial("IronF", Constants.MODID + ":" + Constants.ironHelmFName, 15, new int[] { 2, 6, 5, 2 }, 9);
			oldGoldF = EnumHelper.addArmorMaterial("GoldF", Constants.MODID + ":" + Constants.goldHelmFName, 5, new int[] { 2, 5, 3, 1 }, 25);
			oldDiamondF = EnumHelper.addArmorMaterial("DiamondF", Constants.MODID + ":" + Constants.diamHelmFName, 33, new int[] { 3, 8, 6, 3 }, 10);

			leathCapF = new Item[16];
			ironHelmF = new Item[16];
			goldHelmF = new Item[16];
			diamHelmF = new Item[16];
			for (int i = 0; i < 16; ++i) {
				leathCapF[i] = new FeatheredArmor(leatherF[i], Constants.leathCapFID * 16 + i, 0, true).setUnlocalizedName(Constants.leathCapFName + i);
				ironHelmF[i] = new FeatheredArmor(ironF[i], Constants.ironHelmFID * 16 + i, 0, false).setUnlocalizedName(Constants.ironHelmFName + i);
				goldHelmF[i] = new FeatheredArmor(goldF[i], Constants.goldHelmFID * 16 + i, 0, false).setUnlocalizedName(Constants.goldHelmFName + i);
				diamHelmF[i] = new FeatheredArmor(diamondF[i], Constants.diamHelmFID * 16 + i, 0, false).setUnlocalizedName(Constants.diamHelmFName + i);
			}
			
			oldLeathCapF = new FeatheredArmor(oldLeatherF, Constants.leathCapFID, 0, true).setUnlocalizedName(Constants.leathCapFName);
			oldIronHelmF = new FeatheredArmor(oldIronF, Constants.ironHelmFID, 0, false).setUnlocalizedName(Constants.ironHelmFName);
			oldGoldHelmF = new FeatheredArmor(oldGoldF, Constants.goldHelmFID, 0, false).setUnlocalizedName(Constants.goldHelmFName);
			oldDiamondHelmF = new FeatheredArmor(oldDiamondF, Constants.diamHelmFID, 0, false).setUnlocalizedName(Constants.diamHelmFName);

			colored_feather = new ColoredFeather().setUnlocalizedName(Constants.featherName);
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
		if (!initialized) /* Only run once! */ {
			GameRegistry.registerItem(colored_feather, Constants.featherName);
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(leathCapF[i], Constants.leathCapFName + i);
			}
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(ironHelmF[i], Constants.ironHelmFName + i);
			}
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(goldHelmF[i], Constants.goldHelmFName + i);
			}
			for (int i = 0; i < 16; ++i) {
				GameRegistry.registerItem(diamHelmF[i], Constants.diamHelmFName + i);
			}
			
			GameRegistry.registerItem(oldLeathCapF, Constants.leathCapFName);
			GameRegistry.registerItem(oldIronHelmF, Constants.ironHelmFName);
			GameRegistry.registerItem(oldGoldHelmF, Constants.goldHelmFName);
			GameRegistry.registerItem(oldDiamondHelmF, Constants.diamHelmFName);

			if (side == Side.CLIENT) {
				RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
				
				renderItem.getItemModelMesher().register(oldLeathCapF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.leathCapFName, "inventory"));
				renderItem.getItemModelMesher().register(oldIronHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.ironHelmFName, "inventory"));
				renderItem.getItemModelMesher().register(oldGoldHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.goldHelmFName, "inventory"));
				renderItem.getItemModelMesher().register(oldDiamondHelmF, 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.diamHelmFName, "inventory"));

				for (int i = 0; i < 16; ++i) {
					renderItem.getItemModelMesher().register(leathCapF[i], 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.leathCapFName + i, "inventory"));
					renderItem.getItemModelMesher().register(ironHelmF[i], 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.ironHelmFName + i, "inventory"));
					renderItem.getItemModelMesher().register(goldHelmF[i], 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.goldHelmFName + i, "inventory"));
					renderItem.getItemModelMesher().register(diamHelmF[i], 0, new ModelResourceLocation(Constants.MODID + ":" + Constants.diamHelmFName + i, "inventory"));
				}
				for (int i = 0; i < 15; i++) {
					ModelBakery.addVariantName(colored_feather, Constants.MODID + ":" + Constants.featherName + "_" + EnumDyeColor.byDyeDamage(i).getUnlocalizedName());
					renderItem.getItemModelMesher().register(colored_feather, i, new ModelResourceLocation(Constants.MODID + ":" + Constants.featherName + "_" + EnumDyeColor.byDyeDamage(i).getUnlocalizedName(), "inventory"));
				}
			}

		}
		initialized = true;
	}

}
