//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.GameComponent;

import cofh.lib.util.helpers.StringHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.apache.logging.log4j.Level;
import ru.whisper.whitepower.LBase.GUI.ExCreativeTabs;
import ru.whisper.whitepower.LBase.GameComponent.Enum.NameItems;
import ru.whisper.whitepower.LCore.BaseComponent.ItemBase;
import ru.whisper.whitepower.LCore.WhitePowerLib;
import java.util.List;

public class ItemIgnotTorrium extends ItemBase
{
	public ItemIgnotTorrium()
	{
		super(NameItems.IgnotTorrium);
		setRarity(EnumRarity.common.ordinal());
		setCreativeTab(ExCreativeTabs.tabWPCore);
	}
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "item.itemIgnotTorrium";
	}
	@Override
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown())
			var3.add(StringHelper.shiftForDetails());
		if(StringHelper.isShiftKeyDown())
			var3.add(StringHelper.getInfoText(WhitePowerLib.lexiconDomain + "." + getUnlocalizedName(var1)));
	}
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int dmg)
	{
		return BoxIIcon.get(0);
	}
	@Override
	public int getDamage(ItemStack stack)
	{
		return 0;
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister reg)
	{
		WhitePowerLib.logBase.log(Level.INFO, "load " + WhitePowerLib.textureDomain + ":" + NameItems.getFolderDomainOf(thisName) + "item" + thisName.name());
		BoxIIcon.add(reg.registerIcon(WhitePowerLib.textureDomain + ":" + NameItems.getFolderDomainOf(thisName) + "item" + thisName.name()));
	}
}
