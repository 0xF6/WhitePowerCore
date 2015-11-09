//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LBase.GameComponent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ru.whisper.whitepower.LCore.Interface.ICraftManager;

public class CraftManager implements ICraftManager
{
	@Override
	public void loadRecipes()
	{

	}
	@Override
	public ItemStack getFluidBucket(FluidStack stack)
	{
		stack = stack.copy();
		stack.amount = 1000;
		return FluidContainerRegistry.fillFluidContainer(stack, FluidContainerRegistry.EMPTY_BUCKET);
	}
}