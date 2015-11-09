//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.System;

public class Mathf
{
	public static volatile float FloatMinNormal;
	public static volatile float FloatMinDenormal;
	public static boolean IsFlushToZeroEnabled;
	public final float PI = 3.14159274f;
	//public final float Infinity = float.; //DevComment: Java....
	//public final float NegativeInfinity = float.NegativeInfinity;
	public final float Deg2Rad = 0.0174532924f;
	public final float Rad2Deg = 57.29578f;
	public static float Epsilon;
	static
	{
		Mathf.FloatMinNormal = 1.17549435E-38f;
		Mathf.FloatMinDenormal = 1.401298E-45f;
		Mathf.IsFlushToZeroEnabled = (Mathf.FloatMinDenormal == 0f);
		Mathf.Epsilon = ((!Mathf.IsFlushToZeroEnabled) ? Mathf.FloatMinDenormal : Mathf.FloatMinNormal);
	}
	public static float Sin(float f)
	{
		return (float)Math.sin((double) f);
	}
	public static float Cos(float f)
	{
		return (float)Math.cos((double) f);
	}
	public static float Tan(float f)
	{
		return (float)Math.tan((double) f);
	}
	public static float Asin(float f)
	{
		return (float)Math.asin((double) f);
	}
	public static float Acos(float f)
	{
		return (float)Math.acos((double) f);
	}
	public static float Atan(float f)
	{
		return (float)Math.atan((double) f);
	}
	public static float Atan2(float y, float x)
	{
		return (float)Math.atan2((double) y, (double) x);
	}
	public static float Sqrt(float f)
	{
		return (float)Math.sqrt((double) f);
	}
	public static float Abs(float f)
	{
		return Math.abs(f);
	}
	public static int Abs(int value)
	{
		return Math.abs(value);
	}
	public static float Min(float a, float b)
	{
		return (a >= b) ? b : a;
	}
	public static float Min(float... values)
	{
		int num;
		float num2;
		int i;
		num = values.length;
		if (num == 0)
		{
			return 0f;
		}
		num2 = values[0];
		i = 1;
		while (i < num)
		{
			if (!(values[i] >= num2))
			{
				num2 = values[i];
			}
			i = i + 1;
		}
		return num2;
	}
	public static int Min(int a, int b)
	{
		return (a >= b) ? b : a;
	}
	public static int Min(int... values)
	{
		int num;
		int num2;
		int i;
		num = values.length;
		if (num == 0)
		{
			return 0;
		}
		num2 = values[0];
		i = 1;
		while (i < num)
		{
			if (!(values[i] >= num2))
			{
				num2 = values[i];
			}
			i = i + 1;
		}
		return num2;
	}
	public static float Max(float a, float b)
	{
		return (a <= b) ? b : a;
	}
	public static float Max(float... values)
	{
		int num;
		float num2;
		int i;
		num = values.length;
		if (num == 0)
		{
			return 0f;
		}
		num2 = values[0];
		i = 1;
		while (i < num)
		{
			if (!(values[i] <= num2))
			{
				num2 = values[i];
			}
			i = i + 1;
		}
		return num2;
	}
	public static int Max(int a, int b)
	{
		return (a <= b) ? b : a;
	}
	public static int Max(int... values)
	{
		int num;
		int num2;
		int i;
		num = values.length;
		if (num == 0)
		{
			return 0;
		}
		num2 = values[0];
		i = 1;
		while (i < num)
		{
			if (!(values[i] <= num2))
			{
				num2 = values[i];
			}
			i = i + 1;
		}
		return num2;
	}
	public static float Pow(float f, float p)
	{
		return (float)Math.pow((double) f, (double) p);
	}
	public static float Exp(float power)
	{
		return (float)Math.exp((double) power);
	}
	public static float Log(float f)
	{
		return (float)Math.log((double) f);
	}
	public static float Log10(float f)
	{
		return (float)Math.log10((double) f);
	}
	public static float Ceil(float f)
	{
		return (float)Math.ceil((double) f);
	}
	public static float Floor(float f)
	{
		return (float)Math.floor((double) f);
	}
	public static float Round(float f)
	{
		return (float)Math.round((double) f);
	}
	public static int CeilToInt(float f)
	{
		return (int)Math.ceil((double) f);
	}
	public static int FloorToInt(float f)
	{
		return (int)Math.floor((double) f);
	}
	public static int RoundToInt(float f)
	{
		return (int)Math.round((double) f);
	}
	public static float Sign(float f)
	{
		return (f < 0f) ? -1f : 1f;
	}
	public static float Clamp(float value, float min, float max)
	{
		if (!(value >= min))
		{
			value = min;
		}
		else
		{
			if (!(value <= max))
			{
				value = max;
			}
		}
		return value;
	}
	public static int Clamp(int value, int min, int max)
	{
		if (!(value >= min))
		{
			value = min;
		}
		else
		{
			if (!(value <= max))
			{
				value = max;
			}
		}
		return value;
	}
	public static float Clamp01(float value)
	{
		if (!(value >= 0f))
		{
			return 0f;
		}
		if (!(value <= 1f))
		{
			return 1f;
		}
		return value;
	}
	public static float Lerp(float a, float b, float t)
	{
		return a + (b - a) * Mathf.Clamp01(t);
	}
	public static float LerpUnclamped(float a, float b, float t)
	{
		return a + (b - a) * t;
	}
	public static float LerpAngle(float a, float b, float t)
	{
		float num;
		num = Mathf.Repeat(b - a, 360f);
		if (!(num <= 180f))
		{
			num = num - 360f;
		}
		return a + num * Mathf.Clamp01(t);
	}
	public static float MoveTowards(float current, float target, float maxDelta)
	{
		if (!(Mathf.Abs(target - current) > maxDelta))
		{
			return target;
		}
		return current + Mathf.Sign(target - current) * maxDelta;
	}
	public static float MoveTowardsAngle(float current, float target, float maxDelta)
	{
		target = current + Mathf.DeltaAngle(current, target);
		return Mathf.MoveTowards(current, target, maxDelta);
	}
	public static float SmoothStep(float from, float to, float t)
	{
		t = Mathf.Clamp01(t);
		t = -2f * t * t * t + 3f * t * t;
		return to * t + from * (1f - t);
	}
	public static float Gamma(float value, float absmax, float gamma)
	{
		boolean flag;
		float num;
		float num2;
		flag = !(value >= 0f);
		num = Mathf.Abs(value);
		if (!(num <= absmax))
		{
			return (!flag) ? num : (-num);
		}
		num2 = Mathf.Pow(num / absmax, gamma) * absmax;
		return (!flag) ? num2 : (-num2);
	}
	public static boolean Approximately(float a, float b)
	{
		return Mathf.Abs(b - a) < Mathf.Max(1E-06f * Mathf.Max(Mathf.Abs(a), Mathf.Abs(b)), Mathf.Epsilon * 8f);
	}
	public static float Repeat(float t, float length)
	{
		return t - Mathf.Floor(t / length) * length;
	}
	public static float PingPong(float t, float length)
	{
		t = Mathf.Repeat(t, length * 2f);
		return length - Mathf.Abs(t - length);
	}
	public static float InverseLerp(float a, float b, float value)
	{
		if (!(a == b))
		{
			return Mathf.Clamp01((value - a) / (b - a));
		}
		return 0f;
	}
	public static float DeltaAngle(float current, float target)
	{
		float num;
		num = Mathf.Repeat(target - current, 360f);
		if (!(num <= 180f))
		{
			num = num - 360f;
		}
		return num;
	}
	//static long RandomToLong(Random r)
	//{
	//	byte[] array;
	//	array = new byte[8];
	//	r.nextBytes(array);
	//	return (long)(toLong(array, 0) & 9223372036854775807l);
	//}
}
