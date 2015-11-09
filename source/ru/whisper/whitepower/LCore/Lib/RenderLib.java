//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.Lib;

import cofh.lib.util.helpers.ColorHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import ru.whisper.whitepower.LCore.WhitePowerLib;

import java.util.ArrayList;

public class RenderLib
{
	public static boolean isShadow = true;
	public static void RenderString(ArrayList arList, boolean isLeft)
	{
		ScaledResolution scala = new ScaledResolution(WhitePowerLib.Managed.MCInstance, WhitePowerLib.Managed.MCInstance.displayWidth, WhitePowerLib.Managed.MCInstance.displayHeight);
		int width = scala.getScaledWidth();
		int height = scala.getScaledHeight();

		if(isLeft)
		{
			for(int x = 0; x < arList.size(); x++)
			{
				String str = (String)arList.get(x);
				if(str != null)
					WhitePowerLib.Managed.MCInstance.fontRenderer.drawString(str, 2, 2 + x * 10, ColorHelper.DYE_WHITE, isShadow);
			}
		}
		else
		{
			for(int x = 0; x < arList.size(); x++)
			{
				String str = (String)arList.get(x);
				if(str != null)
				{
					int w = WhitePowerLib.Managed.MCInstance.fontRenderer.getStringWidth(str);
					WhitePowerLib.Managed.MCInstance.fontRenderer.drawString(str, width - w - 10, 2 + x * 10, ColorHelper.DYE_WHITE, isShadow);
				}
			}
		}
	}
}
