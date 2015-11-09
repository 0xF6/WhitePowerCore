//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.api.ProjectRed.RPBandle;

import mrtjp.projectred.transmission.BundledCommons$;
import net.minecraft.world.World;


public final class RPBundleConnector
{
	public static boolean isValidInteractionFor(World world, int x, int y, int z)
	{
		//TileEntity tile = world.getTileEntity(x, y, z);
		//if(tile != null && tile instanceof TileIOExpander)
		//{
		//	return true;
		//}
		//else
		//	return false;
		return false;
	}
	public static boolean canConnectBundled(World world, int x, int y, int z, int side)
	{
		// tile = world.getTileEntity(x, y, z);
		//return tile != null && tile instanceof TileIOExpander && ((TileIOExpander) tile).canConnectBundled(side);
		return false;
	}
	public static byte[] getBundledSignal(World world, int x, int y, int z, int side)
	{
		//TileEntity tile = world.getTileEntity(x, y, z);
		//if(tile != null && tile instanceof TileIOExpander)
		//	return BundledCommons$.MODULE$.unpackDigital((byte[]) null, ((TileIOExpander) tile).getBundledSignal(side));
		//else
		//	return BundledCommons$.MODULE$.unpackDigital((byte[])null, 0);
		return BundledCommons$.MODULE$.unpackDigital((byte[])null, 0);
	}
}
