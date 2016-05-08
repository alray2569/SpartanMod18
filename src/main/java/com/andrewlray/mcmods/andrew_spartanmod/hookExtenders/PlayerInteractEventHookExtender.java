package com.andrewlray.mcmods.andrew_spartanmod.hookExtenders;

import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.andrewlray.mcmods.andrew_spartanmod.items.FeatheredArmor;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;

/**
 * Forge Hooks for using a cauldron to remove dye from a leather feathered cap.
 * 
 * @author Andrew Ray
 * @see MinecraftForge
 * @see SubscribeEvent
 */
public class PlayerInteractEventHookExtender {

	/** true iff this class has been initialized. */
	private static boolean init = false;

	/**
	 * ForgeHook for {@linkplain PlayerInteractEvent}. If a player interacts
	 * with a block, this function is called. If the player has right-clicked on
	 * a non-empty cauldron with a dyed feathered leather cap, the color is
	 * removed from the cap and the water level is decreased.
	 * 
	 * @param pie The PlayerInteractionEvent
	 * @see PlayerInteractEvent
	 * @see BlockCauldron
	 * @see FeatheredArmor#removeColor(ItemStack)
	 */
	@SubscribeEvent
	public void blockClick(PlayerInteractEvent pie) {
		if (pie.action == Action.RIGHT_CLICK_BLOCK) {
			IBlockState block = pie.world.getBlockState(pie.pos);
			if (block.getBlock() == Blocks.cauldron) {
				cauldron_onRightClick(pie, block);
			}
		}
	}
	
	private static void cauldron_onRightClick(PlayerInteractEvent pie, IBlockState ibs) {
		ItemStack item = pie.entityPlayer.getCurrentEquippedItem();
		if (item != null && item.getItem() instanceof FeatheredArmor) {
			FeatheredArmor farmor = (FeatheredArmor) item.getItem();
			int meta = (Integer) ibs.getProperties().get(BlockCauldron.LEVEL);
			if (farmor.isLeather && farmor.hasColor(item) && meta != 0) {
				farmor.removeColor(item);
				pie.world.setBlockState(pie.pos, ibs.withProperty(BlockCauldron.LEVEL, meta - 1));
			}
		}
	}

	/**
	 * Initializes the CauldronExtender and registers it with the Forge Event
	 * bus.
	 * 
	 * @see cpw.mods.fml.common.eventhandler.EventBus#register(Object)
	 *      EventBus.register(Object)
	 */
	public static void init() {
		if (!init) {
			MinecraftForge.EVENT_BUS.register(new PlayerInteractEventHookExtender());
		}
		init = true;
	}
}
