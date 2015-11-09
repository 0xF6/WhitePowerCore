//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.Item;

import cofh.lib.util.helpers.StringHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import org.apache.logging.log4j.Level;
import ru.whisper.whitepower.LBase.GUI.ExCreativeTabs;
import ru.whisper.whitepower.LBase.GameComponent.Enum.NameItems;
import ru.whisper.whitepower.LCore.BaseComponent.ItemBase;
import ru.whisper.whitepower.LCore.Interface.IDebuggable;
import ru.whisper.whitepower.LCore.Lib.CoreLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.whisper.whitepower.LCore.WhitePowerLib;

import java.util.List;

public class ItemDebug extends ItemBase
{
	public ItemDebug()
	{
		super(NameItems.Debugger);
		setRarity(EnumRarity.epic.ordinal());
		this.setCreativeTab(ExCreativeTabs.tabWPItem);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister reg)
	{
		WhitePowerLib.logBase.log(Level.INFO, "load " + WhitePowerLib.textureDomain + ":" + NameItems.getFolderDomainOf(thisName) + "item" + thisName.name());
		this.BoxIIcon.add(reg.registerIcon(WhitePowerLib.textureDomain + ":" + NameItems.getFolderDomainOf(thisName) + "item" + thisName.name()));
		WhitePowerLib.logBase.log(Level.INFO, "load " + WhitePowerLib.textureDomain + ":" + NameItems.getFolderDomainOf(thisName) + "item" + thisName.name() + "Active");
		this.BoxIIcon.add(reg.registerIcon(WhitePowerLib.textureDomain + ":" + NameItems.getFolderDomainOf(thisName) + "item" + thisName.name() + "Active"));
	}
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		if(CoreLib.getOrCreateNbtData(itemstack).getBoolean("active"))
			return "item.itemDebugger.active";
		else
			return "item.itemDebugger";
	}
	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		//WhitePowerLib.Managed.MCInstance.ingameGUI.drawString(WhitePowerLib.Managed.MCInstance.fontRenderer, "RC.Core", (100 - WhitePowerLib.Managed.MCInstance.fontRenderer.getStringWidth("RC.Core")) / 2, 4, -1);
		if(StringHelper.isShiftKeyDown())
		{
			NBTTagCompound nbtData = CoreLib.getOrCreateNbtData(var1);
			if(nbtData.getBoolean("active"))
				nbtData.setBoolean("active", false);
			else
				nbtData.setBoolean("active", true);
			var1.setTagCompound(nbtData);
		}
		return super.onItemRightClick(var1, var2, var3);
	}
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(!stack.getTagCompound().getBoolean("active"))
		{
			CoreLib.SendToChat(player, StringHelper.getInfoText(WhitePowerLib.lexiconDomain + "." + getUnlocalizedName(stack) + ".pshift"));
			return false;
		}
		TileEntity ent = world.getTileEntity(x, y, z);
		if(ent instanceof IDebuggable)
		{
			String[] strDebug = ((IDebuggable)ent).getDebugInfo();
			for(int i = 0; i != strDebug.length; i++)
				CoreLib.SendToChat(player, strDebug[i]);
			return true;
		}
		else
			return false;
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
	public IIcon getIcon(ItemStack stack, int pass)
	{
		if(CoreLib.getOrCreateNbtData(stack).getBoolean("active"))
			return this.BoxIIcon.get(1);
		else
			return this.BoxIIcon.get(0);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int dmg)
	{
		if(dmg == 1)
			return this.BoxIIcon.get(1);
		else
			return this.BoxIIcon.get(0);
	}
	@Override
	public int getDamage(ItemStack stack)
	{
		if(CoreLib.getOrCreateNbtData(stack).getBoolean("active"))
			return 1;
		else
			return 0;
	}
}
