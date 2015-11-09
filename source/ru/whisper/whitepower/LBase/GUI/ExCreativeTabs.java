//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.GUI;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExCreativeTabs
{
	public static CreativeTabs tabWPCore = new CreativeTabs(CreativeTabs.getNextID(), "wpcore")
	{
		@Override public ItemStack getIconItemStack()
		{
			return new ItemStack(Items.blaze_powder, 1, 3);
		}
		@Override public Item getTabIconItem()
		{
			return null;
		}
	};
	public static CreativeTabs tabWPItem = new CreativeTabs(CreativeTabs.getNextID(), "wpitem")
	{
		@Override public ItemStack getIconItemStack()
		{
			return new ItemStack(Items.quartz, 1, 3);
		}
		@Override public Item getTabIconItem()
		{
			return null;
		}
	};
}
