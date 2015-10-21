package com.andrewlray.mcmods.andrew_spartanmod.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.lib.SMUtil;
import com.andrewlray.mcmods.andrew_spartanmod.proxy.ClientProxy;

/**
 * This class contains information relevant to the existance of feathered
 * helmets.
 * 
 * @author Andrew Ray
 *
 */
public class FeatheredArmor
		extends ItemArmor {

	/**
	 * Creates a new instance of feathered armor with the given material, id,
	 * and type.
	 * 
	 * @param material
	 *            The {@linkplain ArmorMaterial} to use for this armor.
	 * @param id
	 *            The render index of this armor.
	 * @param slot
	 *            The type of this armor.
	 */
	public FeatheredArmor(ArmorMaterial material, int id, int slot) {
		super(material, id, slot);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
	}

	/**
	 * Returns the armor texture location.
	 * 
	 * @param stack
	 *            The {@linkplain ItemStack} to get the texture for.
	 * @param entity
	 *            The {@linkplain Entity} wearing the armor.
	 * @param slot
	 *            The type of the armor.
	 * @param layer
	 *            Either "overlay" for the overlay layer or null for the main
	 *            layer.
	 * @return The texture for this armor
	 */
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (slot == 0 && layer == null) {
			String name = SMUtil.getUnwrappedUnlocalizedName(this.getUnlocalizedName());
			return String.format("%s:textures/model/%s.png", Constants.MODID, name);
		}
		if (slot == 0 && layer == "overlay" && this.getArmorMaterial() == SMItems.leatherF) {
			String name = SMUtil.getUnwrappedUnlocalizedName(this.getUnlocalizedName());
			return String.format("%s:textures/model/%s_overlay.png", Constants.MODID, name);
		}
		return null;
	}

	/**
	 * Registers icons as necessary with the icon register
	 * 
	 * @param iconRegister
	 *            The {@linkplain IIconRegister} with which to register icons.
	 * @see IIcon
	 */

	/**
	 * Returns the armor model for this armor.
	 * 
	 * @param entityLiving
	 *            The {@linkplain EntityLivingBase} that is wearing this armor.
	 *            Some modded armor stands will use null.
	 * @param stack
	 *            The {@linkplain ItemStack} to get the model for.
	 * @param armorSlot
	 *            The inventory slot which contains the armor.
	 * @return A {@linkplain ModelBiped} which can be used to render the armor.
	 * @see ClientProxy#armorModels
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot) {
		ModelBiped model = ClientProxy.armorModels.get(this);

		// Fix various stuff
		if (entityLiving != null) {
			model.isSneak = entityLiving.isSneaking();
			model.isRiding = entityLiving.isRiding();
			model.isChild = entityLiving.isChild();
		}

		return model;
	}

	/**
	 * Returns true iff the given {@linkplain ItemStack} is a leather feathered
	 * helmet and has a color associated with it.
	 * 
	 * @param stack
	 *            The ItemStack to check for a color.
	 * @return true iff the given ItemStack is a colored leather feathered
	 *         helmet.
	 */
	@Override
	public boolean hasColor(ItemStack stack) {
		return this.getArmorMaterial() != SMItems.leatherF ? false : (!stack.hasTagCompound() ? false : (!stack.getTagCompound().hasKey("display", 10) ? false : stack.getTagCompound().getCompoundTag("display").hasKey("color", 3)));
	}

	/**
	 * Returns the color of the given ItemStack if it has a color, 10511680 if
	 * it is an uncolored feathered leather helmet, or -1 if it is not a leather
	 * feathered helmet.
	 *
	 * @param stack
	 *            The ItemStack to check
	 * @return The color of the ItemStack, or 10511680 if none.
	 */
	@Override
	public int getColor(ItemStack stack) {
		if (this.getArmorMaterial() == SMItems.leatherF) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null)
				return 10511680;
			NBTTagCompound nbt1 = nbt.getCompoundTag("display");
			return nbt1 == null ? 10511680 : (nbt1.hasKey("color", 3) ? nbt1.getInteger("color") : 10511680);
		}

		return -1;
	}

	/**
	 * <b>addColor</b><br>
	 * Adds the given color to the given stack.
	 * 
	 * @param stack
	 *            The {@linkplain ItemStack} to add the color to
	 * @param color
	 *            The color to add
	 * @see NBTTagCompound
	 * @exception UnsupportedOperationException
	 *                if the armor material is not leatherF.
	 */
	@Override
	public void setColor(ItemStack stack, int color) {
		if (this.getArmorMaterial() != SMItems.leatherF) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
				stack.setTagCompound(nbt);
			}

			NBTTagCompound nbt1 = nbt.getCompoundTag("display");

			if (!nbt.hasKey("display", 10))
				nbt.setTag("display", nbt1);

			nbt1.setInteger("color", color);
		}
	}

	/**
	 * Removes the color from the given stack.
	 * 
	 * @param stack
	 *            The {@linkplain ItemStack} to remove the color from.
	 * @see NBTTagCompound
	 */
	@Override
	public void removeColor(ItemStack stack) {
		if (this.getArmorMaterial() == SMItems.leatherF)
		{
			NBTTagCompound nbttagcompound = stack.getTagCompound();

			if (nbttagcompound != null)
			{
				NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

				if (nbttagcompound1.hasKey("color"))
				{
					nbttagcompound1.removeTag("color");
				}
			}
		}
	}

	/**
	 * Not sure how this works or what it does.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int x) {
		if (x > 0) {
			return 16777215;
		} else {
			int j = this.getColor(stack);
			if (j < 0) {
				j = 16777215;
			}
			return j;
		}
	}
}
