//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.System.Geometry;

import ru.whisper.whitepower.LCore.System.Mathf;

public class Quaternion
{
	public final float kEpsilon = 1E-06f;
	public float x;
	public float y;
	public float z;
	public float w;
	public float getToIndex(int index)
	{
		switch (index)
		{
			case 0:
			{
				return this.x;
			}
			case 1:
			{
				return this.y;
			}
			case 2:
			{
				return this.z;
			}
			case 3:
			{
				return this.w;
			}
			default:
			{
				throw new IndexOutOfBoundsException("Invalid Quaternion index!");
			}
		}
	}
	public void setToIndex(int index, float value)
	{
		switch (index)
		{
			case 0:
			{
				this.x = value;
				break;
			}
			case 1:
			{
				this.y = value;
				break;
			}
			case 2:
			{
				this.z = value;
				break;
			}
			case 3:
			{
				this.w = value;
				break;
			}
			default:
			{
				throw new IndexOutOfBoundsException("Invalid Quaternion index!");
			}
		}
	}
	public Quaternion(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public void set(float new_x, float new_y, float new_z, float new_w)
	{
		this.x = new_x;
		this.y = new_y;
		this.z = new_z;
		this.w = new_w;
	}
	// Static
	public static Quaternion getIdentity()
	{
		return new Quaternion(0f, 0f, 0f, 1f);
	}
	public static float Dot(Quaternion a, Quaternion b)
	{
		return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
	}
	public static float Angle(Quaternion a, Quaternion b)
	{
		float f;
		f = Quaternion.Dot(a, b);
		return Mathf.Acos(Mathf.Min(Mathf.Abs(f), 1f)) * 2f * 57.29578f;
	}
}
