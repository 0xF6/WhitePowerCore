//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.api.ProjectRed;

import ru.whisper.whitepower.LBase.api.ProjectRed.RPBandle.RPBundleConnector;
import cpw.mods.fml.common.Optional;
import mrtjp.projectred.api.IBundledTileInteraction;
import mrtjp.projectred.api.ProjectRedAPI;
import net.minecraft.world.World;


@Optional.Interface(modid = "ProjRed|Transmission", iface = "mrtjp.projectred.api.IBundledTileInteraction", striprefs = true)
public final class PRBundledTileInteraction implements IBundledTileInteraction
{
	public static PRBundledTileInteraction Interaction;

	private PRBundledTileInteraction()
	{
		Interaction = this;
	}

	static
	{
		new PRBundledTileInteraction();
	}
	@Optional.Method(modid = "ProjRed|Transmission")
	public void register()
	{
		ProjectRedAPI.transmissionAPI.registerBundledTileInteraction(this);
	}
	@Override @Optional.Method(modid = "ProjRed|Transmission")
	public boolean isValidInteractionFor(World world, int i, int i1, int i2)
	{
		return RPBundleConnector.isValidInteractionFor(world, i, i1, i2);
	}
	@Override @Optional.Method(modid = "ProjRed|Transmission")
	public boolean canConnectBundled(World world, int i, int i1, int i2, int i3)
	{
		return RPBundleConnector.canConnectBundled(world, i, i1, i2, i3);
	}
	@Override @Optional.Method(modid = "ProjRed|Transmission")
	public byte[] getBundledSignal(World world, int i, int i1, int i2, int i3)
	{
		return RPBundleConnector.getBundledSignal(world, i, i1, i2, i3);
	}

	public static void RegisterHandleBridge()
	{
		Interaction.register();
	}
}
