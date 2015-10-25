package com.andrewlray.mcmods.andrew_spartanmod.items.crafting;

import java.util.ArrayList;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import com.andrewlray.mcmods.andrew_spartanmod.items.FeatheredArmor;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

/**
 * This class contains the crafting data necessary to allow leather feathered
 * helmets to be dyed.
 * 
 * @author Andrew Ray
 * @see IRecipe
 * @see FeatheredArmor
 */
public class RecipesFeatheredArmorDyes
		implements IRecipe {

	/**
	 * Returns true <abbr name="if and only if">iff</abbr> the configuration of
	 * items in the crafting window is a valid dyeing pattern, i.e. if the
	 * contents of the crafting window are exactly one leather feathered helmet
	 * and a non-zero number of various dyes.
	 * 
	 * @param ic
	 *            The {@linkplain InventoryCrafting}
	 * @param world
	 *            The {@linkplain World} in which the crafting is taking place.
	 * @return true iff the configuration of items in the crafting window is a
	 *         valid dyeing pattern.
	 */
	@Override
	public boolean matches(InventoryCrafting ic, World world) {
		ItemStack stack = null;
		ArrayList arrayList = new ArrayList();

		for (int i = 0; i < ic.getSizeInventory(); i++) {
			ItemStack stack1 = ic.getStackInSlot(i);

			if (stack1 != null) {
				if (stack1.getItem() instanceof FeatheredArmor) {
					FeatheredArmor farmor = (FeatheredArmor) stack1.getItem();

					if (farmor.getArmorMaterial() != SMItems.leatherF || stack != null) {
						return false;
					}

					stack = stack1;
				} else {
					if (stack1.getItem() != Items.dye) {
						return false;
					}
					arrayList.add(stack1);
				}
			}
		}

		return stack != null && !arrayList.isEmpty();
	}

	/**
	 * Returns the result of crafting if matches returns true. If matches
	 * returns false, returns null.
	 * 
	 * @param ic
	 *            The {@linkplain InventoryCrafting}
	 * @return the result of crafting, or null if none.
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting ic) {
		ItemStack stack = null;
		int[] ints = new int[3];
		int a = 0;
		int b = 0;
		FeatheredArmor farmor = null;
		int c, d, d1;
		float f, f1;

		for (c = 0; c < ic.getSizeInventory(); c++) {
			ItemStack stack1 = ic.getStackInSlot(c);

			if (stack1 != null) {
				if (stack1.getItem() instanceof FeatheredArmor) {
					farmor = (FeatheredArmor) stack1.getItem();

					if (farmor.getArmorMaterial() != SMItems.leatherF || stack != null) {
						return null;
					}

					stack = stack1.copy();
					stack.stackSize = 1;

					if (farmor.hasColor(stack1)) {
						d = farmor.getColor(stack);
						f = (float) (d >> 16 & 255) / 255F;
						f1 = (float) (d >> 8 & 255) / 255F;
						float f2 = (float) (d & 255) / 255F;
						a = (int) ((float) a + Math.max(f, Math.max(f1, f2)) * 255F);
						ints[0] = (int) ((float) ints[0] + f * 255F);
						ints[1] = (int) ((float) ints[1] + f1 * 255F);
						ints[2] = (int) ((float) ints[2] + f2 * 255F);
						b++;
					}
				} else {
					if (stack1.getItem() != Items.dye) {
						return null;
					}

					float[] afloat = EntitySheep.func_175513_a(EnumDyeColor.byDyeDamage(stack1.getMetadata()));
					int b1 = (int) (afloat[0] * 255F);
					int c1 = (int) (afloat[1] * 255F);
					d1 = (int) (afloat[2] * 255F);
					a += Math.max(b1, Math.max(c1, d1));
					ints[0] += b1;
					ints[1] += c1;
					ints[2] += d1;
					b++;
				}
			}
		}

		if (farmor == null) {
			return null;
		} else {
			c = ints[0] / b;
			int a1 = ints[1] / b;
			d = ints[2] / b;
			f = (float) a / (float) b;
			f1 = (float) Math.max(c, Math.max(a1, d));
			c = (int) ((float) c * f / f1);
			a1 = (int) ((float) a1 * f / f1);
			d = (int) ((float) d * f / f1);
			d1 = (c << 8) + a1;
			d1 = (d1 << 8) + d;
			farmor.setColor(stack, d1);
			return stack;
		}
	}

	/**
	 * Gets the size of this type of recipe.
	 * 
	 * @return The size of this recipe.
	 */
	@Override
	public int getRecipeSize()
	{
		return 10;
	}

	/**
	 * Returns null.
	 * @return null
	 */
	@Override
	public ItemStack getRecipeOutput()
	{
		return null;
	}

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting inv) //getRecipeLeftovers
    {
        return ForgeHooks.defaultRecipeGetRemainingItems(inv);
    }

}
