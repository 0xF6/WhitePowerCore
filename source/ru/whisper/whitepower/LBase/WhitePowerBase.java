//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase;

import cofh.core.CoFHProps;
import cofh.core.util.*;
import cofh.mod.BaseMod;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import ru.whisper.whitepower.LBase.GUI.GuiHandler;
import ru.whisper.whitepower.LBase.GameComponent.*;
import ru.whisper.whitepower.LBase.Item.*;
import ru.whisper.whitepower.LBase.Proxy.WPProxy;

import java.io.File;

@Mod(modid = WhitePowerBase.ModInfo.modid, name = WhitePowerBase.ModInfo.name, version = WhitePowerBase.ModInfo.version, dependencies = WhitePowerBase.ModInfo.dependencies)
public class WhitePowerBase extends BaseMod
{
	public class ModInfo
	{
		public static final String modid = "WhitePowerBase";
		public static final String name = "WhitePower Base";
		public static final String version = "1.5a28";
		public static final String dependencies = "required-after:WLib";
	}
	@Instance("WhitePowerBase")
	public static WhitePowerBase instance;
	@SidedProxy(
			clientSide = "ru.whisper.whitepower.LBase.Proxy.WPProxyClient",
			serverSide = "ru.whisper.whitepower.LBase.Proxy.WPProxy"
	)
	public static WPProxy proxy;
	public static ItemDebug itemDebug;
	public static ItemIgnotTorrium itemIgnotTorrium;
	public static final ConfigHandler config = new ConfigHandler("1.7.10-1.5a28");
	public static final GuiHandler guiHandler = new GuiHandler();
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

	}

	@EventHandler
	public void initialize(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);
		MinecraftForge.EVENT_BUS.register(proxy);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		setupItem();
		MinecraftForge.EVENT_BUS.register(proxy);
	}
	private static void setupItem()
	{
		itemDebug = new ItemDebug();
		itemIgnotTorrium = new ItemIgnotTorrium();
	}
	@Override
	public String getModId()
	{
		return WhitePowerBase.ModInfo.modid;
	}
	@Override
	public String getModName()
	{
		return WhitePowerBase.ModInfo.name;
	}
	@Override
	public String getModVersion()
	{
		return WhitePowerBase.ModInfo.version;
	}
}
