package com.andrewlray.mcmods.andrew_spartanmod.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ColoredFeather extends Item {

	public static final int SUBS = 15;

	/**
	 * Creates a new instance of ColoredFeather.
	 */
	public ColoredFeather() {
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	/**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
	@Override
    public String getUnlocalizedName(ItemStack stack) {
        int i = stack.getMetadata();
        return super.getUnlocalizedName() + "." + EnumDyeColor.byDyeDamage(i).getUnlocalizedName();
    }
	
	/**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     *  
     * @param subItems The List of sub-items. This is a List of ItemStacks.
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
    {
        for (int i = 0; i < SUBS; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
	
}
