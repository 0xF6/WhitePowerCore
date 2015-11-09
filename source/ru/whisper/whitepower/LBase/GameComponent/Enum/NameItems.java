//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.GameComponent.Enum;

public enum NameItems
{
	Debugger,
	//TODO: Ignot
	IgnotTorrium,
	//TODO: Plate
	PlateArgone,
	PlateLuurium,
	PlateTorrium,
	//TODO: Gear Mount
	GearWoodMount,
	GearStoneMount,
	GearIronMount,
	//TODO: Gear Refl
	GearWoodRefl,
	GearStoneRefl,
	GearIronRefl,
	//TODO: Gear Muft
	GearWoodMuft,
	GearStoneMuft,
	GearIronMuft,
	//TODO: Device
	DeviceMicro1,
	DeviceMicro2,
	DeviceMicro3;

	public static int getItemMaxStack(NameItems t)
	{
		switch (t)
		{
			case Debugger:
				return 1;
			case DeviceMicro1:
				return 1;
			case DeviceMicro2:
				return 1;
			case DeviceMicro3:
				return 1;
			default:
				return 64;
		}
	}
	public static String getFolderDomainOf(NameItems t)
	{
		switch (t)
		{
			case Debugger:
				return "debugger/";
			case IgnotTorrium:
				return "ignot/";
			default:
				return "";
		}
	}
}
