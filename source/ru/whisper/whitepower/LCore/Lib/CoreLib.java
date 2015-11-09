package ru.whisper.whitepower.LCore.Lib;

import cofh.lib.util.helpers.StringHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraftforge.common.DimensionManager;
import ru.whisper.whitepower.LCore.System.minecraft.WorldCoord;
import cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException;
import cpw.mods.fml.relauncher.ReflectionHelper.UnableToFindFieldException;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class CoreLib
{
	public enum ColorBundleID
	{
		white,
		orange,
		magenta,
		lightBlue,
		yellow,
		lime,
		pink,
		gray,
		silver,
		cyan,
		purple,
		blue,
		brown,
		green,
		red,
		black;
		public static int getNumToBundleID(ColorBundleID bundle)
		{
			switch (bundle)
			{
				case white:
					return 1;
				case orange:
					return 2;
				case magenta:
					return 3;
				case lightBlue:
					return 4;
				case yellow:
					return 5;
				case lime:
					return 6;
				case pink:
					return 7;
				case gray:
					return 8;
				case silver:
					return 9;
				case cyan:
					return 10;
				case purple:
					return 11;
				case blue:
					return 12;
				case brown:
					return 13;
				case green:
					return 14;
				case red:
					return 15;
				case black:
					return 16;
				default:
					return 0;
			}
		}
	}
	public static String[] rawColorNames = new String[]{"white", "orange", "magenta", "lightBlue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black"};
	public static String[] enColorNames = new String[]{"White", "Orange", "Magenta", "Light Blue", "Yellow", "Lime", "Pink", "Gray", "Light Gray", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};
	public static int[] paintColors = new int[]{0xFFFFFF, 0xFF8000, 0xFF00FF, 0x6C80FF, 0xFFFF00, 0xFF00, 0xFF6480, 0x535353, 0x939393, 0xFFFF, 0x8000FF, 0xFF, 0x4F2700, 0x8000, 0xFF0000, 0x1F1F1F};
	public static final Material materialWhitePower = new Material(MapColor.woodColor);

	public static final int DEBUG_FORGE_COUNT_TEXT_LINE_RIGHT = 9;
	public static final int DEBUG_FORGE_COUNT_TEXT_LINE_LEFT = 13;

	public static String RPLColor(String t)
	{
		// Костыль, ибо ебучая кодировка
		return t.replace("%0", StringHelper.BLACK)
				.replace("%1", StringHelper.BLUE)
				.replace("%2", StringHelper.GREEN)
				.replace("%3", StringHelper.TEAL)
				.replace("%4", StringHelper.RED)
				.replace("%5", StringHelper.PURPLE)
				.replace("%6", StringHelper.ORANGE)
				.replace("%7", StringHelper.LIGHT_GRAY)
				.replace("%8", StringHelper.GRAY)
				.replace("%9", StringHelper.LIGHT_BLUE)
				.replace("%a", StringHelper.BRIGHT_GREEN)
				.replace("%b", StringHelper.BRIGHT_BLUE)
				.replace("%c", StringHelper.LIGHT_RED)
				.replace("%d", StringHelper.PINK)
				.replace("%e", StringHelper.YELLOW)
				.replace("%f", StringHelper.WHITE)
				.replace("%r", StringHelper.END);
	}

	public static boolean isClient(World world)
	{
		return world.isRemote;
	}
	public static void updateAllLightTypes(World world, int x, int y, int z)
	{
		world.updateLightByType(EnumSkyBlock.Block, x, y, z);
		world.updateLightByType(EnumSkyBlock.Sky, x, y, z);
	}
	public static Object getTileEntity(IBlockAccess iba, int i, int j, int k, Class<?> cl)
	{
		TileEntity tr = iba.getTileEntity(i, j, k);
		return !cl.isInstance(tr) ? null : tr;
	}
	public static File getSaveDir(World world)
	{
		return DimensionManager.getCurrentSaveRootDirectory();
	}
	public static Object getTileEntity(IBlockAccess iba, WorldCoord wc, Class<?> cl)
	{
		TileEntity tr = iba.getTileEntity(wc.x, wc.y, wc.z);
		return !cl.isInstance(tr) ? null : tr;
	}
	public static Object getGuiTileEntity(World world, int i, int j, int k, Class<?> cl)
	{
		if (world.isRemote)
		{
			try
			{
				return cl.newInstance();
			} catch (InstantiationException var6)
			{
				return null;
			} catch (IllegalAccessException var7)
			{
				return null;
			}
		} else
		{
			TileEntity tr = world.getTileEntity(i, j, k);
			return !cl.isInstance(tr) ? null : tr;
		}
	}
	public static void markBlockDirty(World world, int i, int j, int k)
	{
		if (world.blockExists(i, j, k))
		{
			world.getChunkFromBlockCoords(i, k).setChunkModified();
		}
	}

	public static int compareItemStack(ItemStack a, ItemStack b)
	{
		return Item.getIdFromItem(a.getItem()) != Item.getIdFromItem(b.getItem()) ? Item.getIdFromItem(a.getItem()) - Item.getIdFromItem(b.getItem()) : (a.getItemDamage() == b.getItemDamage() ? 0 : (a.getItem().getHasSubtypes() ? a.getItemDamage() - b.getItemDamage() : 0));
	}
	public static void dropItem(World world, int i, int j, int k, ItemStack ist)
	{
		if (!isClient(world))
		{
			double d = 0.7D;
			double x = world.rand.nextFloat() * d + (1.0D - d) * 0.5D;
			double y = world.rand.nextFloat() * d + (1.0D - d) * 0.5D;
			double z = world.rand.nextFloat() * d + (1.0D - d) * 0.5D;
			EntityItem item = new EntityItem(world, i + x, j + y, k + z, ist);
			item.delayBeforeCanPickup = 10;
			world.spawnEntityInWorld(item);
		}
	}
	public static ItemStack copyStack(ItemStack ist, int n)
	{
		return new ItemStack(ist.getItem(), n, ist.getItemDamage());
	}
	public static int RotationToSide(int r)
	{
		switch (r)
		{
			case 0:
				return 5;
			case 1:
				return 3;
			case 2:
				return 4;
			default:
				return 2;
		}
	}
	public static int getFacing(int side)
	{
		switch (side)
		{
			case 0:
				return 2;
			case 1:
				return 5;
			case 2:
				return 3;
			case 3:
				return 4;
			case 4:
				return 1;
			case 5:
				return 0;
			default:
				return 0;
		}
	}
	public static MovingObjectPosition retraceBlock(World world, EntityLivingBase ent, int i, int j, int k)
	{
		Vec3 org = Vec3.createVectorHelper(ent.posX, ent.posY + 1.62D - ent.yOffset, ent.posZ);
		Vec3 vec = ent.getLook(1.0F);
		Vec3 end = org.addVector(vec.xCoord * 5.0D, vec.yCoord * 5.0D, vec.zCoord * 5.0D);
		Block bl = world.getBlock(i, j, k);
		return bl == null ? null : bl.collisionRayTrace(world, i, j, k, org, end);
	}

	public static MovingObjectPosition traceBlock(EntityPlayer player)
	{
		Vec3 org = Vec3.createVectorHelper(player.posX, player.posY + 1.62D - player.yOffset, player.posZ);
		Vec3 vec = player.getLook(1.0F);
		Vec3 end = org.addVector(vec.xCoord * 5.0D, vec.yCoord * 5.0D, vec.zCoord * 5.0D);
		return player.worldObj.rayTraceBlocks(org, end);
	}

	public static void placeNoise(World world, int i, int j, int k, Block block)
	{
		world.playSoundEffect(i + 0.5F, j + 0.5F, k + 0.5F, block.stepSound.func_150496_b(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
	}

	public static int getBurnTime(ItemStack ist)
	{
		return TileEntityFurnace.getItemBurnTime(ist);
	}

	public static double getAverageEdgeLength(AxisAlignedBB aabb)
	{
		double d = aabb.maxX - aabb.minX;
		double d1 = aabb.maxY - aabb.minY;
		double d2 = aabb.maxZ - aabb.minZ;
		return (d + d1 + d2) / 3.0D;
	}

	public static void SendToChat(EntityPlayer pl, String str)
	{
		if (pl instanceof EntityPlayerMP)
		{
			EntityPlayerMP emp = (EntityPlayerMP) pl;
			emp.addChatComponentMessage(new ChatComponentText(str));
		}
	}
	public static NBTTagCompound getOrCreateNbtData(ItemStack itemStack)
	{
		NBTTagCompound ret = itemStack.getTagCompound();
		if(ret == null)
		{
			ret = new NBTTagCompound();
			itemStack.setTagCompound(ret);
		}
		return ret;
	}
	public static int[] toIntArray(List<Integer> integerList)
	{
		int[] intArray = new int[integerList.size()];
		for (int i = 0; i < integerList.size(); i++)
		{
			intArray[i] = integerList.get(i);
		}
		return intArray;
	}

	public static <T, E> void setFinalValue(Class<? super T> classToAccess, T instance, E value, String... fieldNames)
	{
		try
		{
			findField(classToAccess, fieldNames).set(instance, value);
		} catch (Exception e)
		{
			throw new UnableToAccessFieldException(fieldNames, e);
		}
	}

	public static Field findField(Class<?> clazz, String... fieldNames)
	{
		Exception failed = null;
		for (String fieldName : fieldNames)
		{
			try
			{
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

				return field;
			} catch (Exception e)
			{
				failed = e;
			}
		}
		throw new UnableToFindFieldException(fieldNames, failed);
	}
	public void messagePlayer(EntityPlayer player, String message, Object... args)
	{
		if(player instanceof EntityPlayerMP)
		{
			ChatComponentTranslation msg;
			if(args.length > 0)
				msg = new ChatComponentTranslation(message, (Object[])this.getMessageComponents(args));
			else
				msg = new ChatComponentTranslation(message);

			((EntityPlayerMP)player).addChatComponentMessage(msg);
		}
	}
	protected IChatComponent[] getMessageComponents(Object... args)
	{
		IChatComponent[] encodedArgs = new IChatComponent[args.length];
		for(int i = 0; i < args.length; ++i)
		{
			if(args[i] instanceof String && ((String)args[i]).startsWith("whitepower."))
			{
				encodedArgs[i] = new ChatComponentTranslation((String)args[i]);
			}
			else
			{
				encodedArgs[i] = new ChatComponentText(args[i].toString());
			}
		}

		return encodedArgs;
	}
}
