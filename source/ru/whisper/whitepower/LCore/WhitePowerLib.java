//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Mod(modid = WhitePowerLib.ModInfo.modid, name = WhitePowerLib.ModInfo.name, version = WhitePowerLib.ModInfo.version, dependencies = WhitePowerLib.ModInfo.dependencies)
public class WhitePowerLib
{
	public static class SettingCore
	{
		public static boolean isDebug = true;
	}
	public class ModInfo
	{
		public static final String modid = "WLib";
		public static final String name = "WhiteLib - Awa";
		public static final String version = "1.5a28";
		public static final String dependencies = "required-after:CoFHCore@[1.7.10R3.0.3,)";//;required-after:ProjRed|Transmission@[4.7.0pre9.92,)
	}
	public static class Managed
	{
		public static Minecraft MCInstance;
	}
	public static final String textureDomain = "whitepower";
	public static final String lexiconDomain = "info.whitepower.lexicon";
	public static final String achievementDomain = "achievement.whitepower";
	public static Logger logLib = LogManager.getLogger("WhiteLib");
	public static Logger logBase = LogManager.getLogger("WhitePowerBase");
	public static Logger logAPI = LogManager.getLogger("WhitePowerAPI");
	@Instance("WhitePowerLib")
	public static WhitePowerLib instance;
	@EventHandler public void preInit(FMLPreInitializationEvent event)
	{
		Managed.MCInstance = FMLClientHandler.instance().getClient();
		if(SettingCore.isDebug)
		{
			logLib.log(Level.INFO, "#***************************************************************************#");
			logLib.log(Level.INFO, "#Name				:" + ModInfo.name);
			logLib.log(Level.INFO, "#ModID				:" + ModInfo.modid);
			logLib.log(Level.INFO, "#VersionLib			:" + ModInfo.version);
			logLib.log(Level.INFO, "#Dependencies		:" + ModInfo.dependencies);
			logLib.log(Level.INFO, "#textureDomain		:" + textureDomain);
			logLib.log(Level.INFO, "#lexiconDomain		:" + lexiconDomain);
			logLib.log(Level.INFO, "#achievementDomain	:" + achievementDomain);
			logLib.log(Level.INFO, "#***************************************************************************#");
			logLib.log(Level.INFO, "pre initialize Complete.");
		}
	}
	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent var1)
	{ }
	@EventHandler public void initialize(FMLInitializationEvent event)
	{
		if(SettingCore.isDebug) logLib.log(Level.INFO, "initialize Complete.");
	}
	@EventHandler public void load(FMLInitializationEvent event)
	{
		if(SettingCore.isDebug) logLib.log(Level.INFO, "Loading Complete.");
	}
	@EventHandler public void postInit(FMLPostInitializationEvent event)
	{
		if(SettingCore.isDebug) logLib.log(Level.INFO, "post initialize Complete.");
	}
}