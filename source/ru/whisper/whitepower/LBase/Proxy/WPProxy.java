//==============================================================//
//   Copyright � Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.Proxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import ru.whisper.whitepower.LCore.Lib.CoreLib;
import ru.whisper.whitepower.LCore.Lib.RenderLib;
import ru.whisper.whitepower.LCore.WhitePowerLib;

import java.util.ArrayList;

public class WPProxy
{
	@Mod.Instance("WPProxy")
	public static WPProxy instance;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderGameOverlayEvent event)
	{
		if(event.type == RenderGameOverlayEvent.ElementType.TEXT)
		{
			try
			{
				if(WhitePowerLib.Managed.MCInstance.gameSettings.showDebugInfo)
				{
					ArrayList<String> list = new ArrayList<String>();

					for(int i = 0; i != CoreLib.DEBUG_FORGE_COUNT_TEXT_LINE_RIGHT; i++) // Cap Forge Text
					{ list.add((String)null); }
					list.add(CoreLib.RPLColor("Rc.Core   : %9enabled%r  (%28.2.1.5525%r);"));
					list.add(CoreLib.RPLColor("Rc.Turbine: %4disabled%r    (%4unknown%r);"));
					RenderLib.RenderString(list, false);
					list = new ArrayList<String>();

					for(int i = 0; i != CoreLib.DEBUG_FORGE_COUNT_TEXT_LINE_LEFT; i++) // Cap Forge Text
					{ list.add((String)null); }
					list.add(CoreLib.RPLColor("Rc.Core   : %9enabled%r  (%28.2.1.5525%r);"));
					list.add(CoreLib.RPLColor("Rc.Turbine: %4disabled%r    (%4unknown%r);"));
					RenderLib.RenderString(list, true);
				}
			}
			catch (Exception ignored) {}
		}
	}
}
