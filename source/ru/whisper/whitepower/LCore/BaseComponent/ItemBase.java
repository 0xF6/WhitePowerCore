//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.BaseComponent;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import ru.whisper.whitepower.LBase.GameComponent.Enum.*;

import java.util.*;
/**
 * Base class of wp item
 */
public class ItemBase extends Item
{
	protected ArrayList<IIcon> BoxIIcon;
	protected final NameItems thisName;
	private int Rarity;

	public ItemBase(NameItems it)
	{
		this.setMaxStackSize(NameItems.getItemMaxStack(it));
		this.thisName = it;
		GameRegistry.registerItem(this, it.name());
		BoxIIcon = new ArrayList<IIcon>();
	}
	/**
	 * Get an item texture folder
	 */
	public String getTextureFolder()
	{
		return null;
	}
	/**
	 * Set an item rarity
	 */
	public ItemBase setRarity(int aRarity)
	{
		this.Rarity = aRarity;
		return this;
	}
	/**
	 * Return an item rarity from EnumRarity
	 */
	@Override @SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack item)
	{
		return EnumRarity.values()[this.Rarity];
	}
}
