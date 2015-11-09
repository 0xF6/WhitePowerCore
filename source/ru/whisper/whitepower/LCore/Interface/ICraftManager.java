//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.Interface;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
public interface ICraftManager
{
	void loadRecipes();
	ItemStack getFluidBucket(FluidStack stack);
}
