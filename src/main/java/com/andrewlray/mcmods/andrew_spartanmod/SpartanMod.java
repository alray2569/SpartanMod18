package com.andrewlray.mcmods.andrew_spartanmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.andrewlray.mcmods.andrew_spartanmod.hookExtenders.PlayerInteractEventHookExtender;
import com.andrewlray.mcmods.andrew_spartanmod.items.SMItems;
import com.andrewlray.mcmods.andrew_spartanmod.items.crafting.SMRecipes;
import com.andrewlray.mcmods.andrew_spartanmod.lib.Constants;
import com.andrewlray.mcmods.andrew_spartanmod.proxy.CommonProxy;

/**
 * The mod class for SpartanMod.
 * 
 * @author Andrew Ray
 */
@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = "1.8_1.2")
public class SpartanMod {

	/**
	 * The single static instance of the SpartanMod class.<br>
	 * <br>
	 * "There can only be one."
	 */
	@Mod.Instance(Constants.MODID)
	public static SpartanMod instance;

	/**
	 * The single static instance of the SpartanMod proxy. For calls made on the
	 * client side, the value is the
	 * {@linkplain com.andrewlray.mcmods.andrew_spartanmod.proxy.ClientProxy
	 * ClientProxy}. For calls made on the server side, the value is the
	 * {@linkplain com.andrewlray.mcmods.andrew_spartanmod.proxy.CommonProxy
	 * CommonProxy}.<br>
	 * <br>
	 * "Like in quantum physics, the value is unknowable until it is observed.
	 * When observed, its value changes based on its observer."
	 */
	@SidedProxy(clientSide = Constants.PROXY_CLIENT, serverSide = Constants.PROXY_COMMON)
	public static CommonProxy proxy;

	/**
	 * The EventHandler that handles FMLPreInitializationEvents. It calls the
	 * various preInit functions for the handlers, registers, and proxies in
	 * SpartanMod.<br>
	 * <br>
	 * "Bring out the penguins."
	 * 
	 * @param e
	 *            The {@linkplain FMLPreInitializationEvent}.
	 * @see com.andrewlray.mcmods.andrew_spartanmod.items.SMItems#preInit
	 *      SMItems.preInit()
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		SMItems.preInit();
	}

	/**
	 * The EventHandler that handles FMLInitializationEvents. It calls the various init functions for the handlers, registers, and proxies in SpartanMod.<br>
	 * <br>
	 * "Resistance is futile."
	 * 
	 * @param e The {@linkplain FMLInitializationEvent}.
	 * @see CommonProxy#registerProxies()
	 * @see SMItems#init()
	 * @see SMRecipes#init()
	 * @see PlayerInteractEventHookExtender#init()
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.registerProxies();
		SMItems.init(e.getSide());
		SMRecipes.init();
		PlayerInteractEventHookExtender.init();
	}

	/**
	 * The EventHandler that would handle FMLPostInitializationEvents. It would
	 * call the various postInit functions for the handlers, registers, and
	 * proxies in SpartanMod if any of them had one.<br>
	 * <br>
	 * "Huh? What's this thing doing here?"
	 * 
	 * @param e
	 *            The {@linkplain FMLPostInitializationEvent}.
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

}
