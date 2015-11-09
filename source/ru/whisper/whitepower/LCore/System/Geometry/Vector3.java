//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.System.Geometry;

import ru.whisper.whitepower.LCore.System.Mathf;

public class Vector3
{
	public final float kEpsilon = 1E-05f;
	public float x;
	public float y;
	public float z;
	public Vector3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector3(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.z = 0f;
	}
	public Vector3(Vector3 v)
	{
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}
	public float Magnitude()
	{
		return Mathf.Sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
	public float sqrMagnitude()
	{
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}


	// Static
	public static Vector3 Normalize(Vector3 value)
	{
		float num;
		num = Vector3.Magnitude(value);
		if (!(num <= 1E-05f))
		{
			return new Vector3(value.x / num, value.y / num, value.z / num);
		}
		return Vector3.zero();
	}
	public static Vector3 zero()
	{
		return new Vector3(0f, 0f, 0f);
	}
	public static Vector3 one()
	{
		return new Vector3(1f, 1f, 1f);
	}
	public static Vector3 forward()
	{
		return new Vector3(0f, 0f, 1f);
	}
	public static Vector3 back()
	{
		return new Vector3(0f, 0f, -1f);
	}
	public static Vector3 up()
	{
		return new Vector3(0f, 1f, 0f);
	}
	public static Vector3 down()
	{
		return new Vector3(0f, -1f, 0f);
	}
	public static Vector3 left()
	{
		return new Vector3(-1f, 0f, 0f);
	}
	public static Vector3 right()
	{
		return new Vector3(1f, 0f, 0f);
	}
	public static float Magnitude(Vector3 a)
	{
		return Mathf.Sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
	}

	public static Vector3 Lerp(Vector3 a, Vector3 b, float t)
	{
		t = Mathf.Clamp01(t);
		return new Vector3(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t, a.z + (b.z - a.z) * t);
	}
	public static Vector3 LerpUnclamped(Vector3 a, Vector3 b, float t)
	{
		return new Vector3(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t, a.z + (b.z - a.z) * t);
	}
	public static Vector3 MoveTowards(Vector3 current, Vector3 target, float maxDistanceDelta)
	{
		Vector3 a;
		float magnitude;
		a = Vector3.Substract(target, current);
		magnitude = a.Magnitude();
		if (!(magnitude > maxDistanceDelta && magnitude != 0f))
		{
			return target;
		}
		return Vector3.Addition(current, Vector3.Multiply(Vector3.Division(a, magnitude), maxDistanceDelta));
	}
	public static Vector3 SmoothDamp(Vector3 current, Vector3 target, Vector3 currentVelocity, float smoothTime, float maxSpeed, float deltaTime)
	{
		float num;
		float num2;
		float d;
		Vector3 vector;
		Vector3 vector2;
		float maxLength;
		Vector3 vector3;
		Vector3 vector4;
		smoothTime = Mathf.Max(0.0001f, smoothTime);
		num = 2f / smoothTime;
		num2 = num * deltaTime;
		d = 1f / (1f + num2 + 0.48f * num2 * num2 + 0.235f * num2 * num2 * num2);
		vector = Vector3.Substract(current, target);
		vector2 = target;
		maxLength = maxSpeed * smoothTime;
		vector = Vector3.ClampMagnitude(vector, maxLength);
		target = Vector3.Substract(current, vector);
		vector3 = Vector3.Multiply(Vector3.Addition(currentVelocity, Vector3.Multiply(num, vector)), deltaTime);
		currentVelocity = Vector3.Multiply(Vector3.Substract(currentVelocity, Vector3.Multiply(num, vector3)), d);
		vector4 = Vector3.Addition(target, Vector3.Multiply(Vector3.Addition(vector, vector3), d));
		if (!(Vector3.Dot(Vector3.Substract(vector2, current), Vector3.Substract(vector4, vector2)) <= 0f))
		{
			vector4 = vector2;
			currentVelocity = Vector3.Division(Vector3.Substract(vector4, vector2), deltaTime);
		}
		return vector4;
	}
	public static Vector3 ClampMagnitude(Vector3 vector, float maxLength)
	{
		if (!(vector.sqrMagnitude() <= maxLength * maxLength))
		{
			return Vector3.Multiply(Normalize(new Vector3(vector)), maxLength);
		}
		return vector;
	}
	public static float Dot(Vector3 lhs, Vector3 rhs)
	{
		return lhs.x * rhs.x + lhs.y * rhs.y + lhs.z * rhs.z;
	}
	public static Vector3 Project(Vector3 vector, Vector3 onNormal)
	{
		float num;
		num = Vector3.Dot(onNormal, onNormal);
		if (!(num >= Mathf.Epsilon))
		{
			return Vector3.zero();
		}
		return Vector3.Division(Vector3.Multiply(onNormal, Vector3.Dot(vector, onNormal)), num);
	}
	public static Vector3 ProjectOnPlane(Vector3 vector, Vector3 planeNormal)
	{
		return Vector3.Substract(vector, Vector3.Project(vector, planeNormal));
	}
	public static float Angle(Vector3 from, Vector3 to)
	{
		return Mathf.Acos(Mathf.Clamp(Vector3.Dot(Normalize(from), Normalize(to)), -1f, 1f)) * 57.29578f;
	}
	public static float Distance(Vector3 a, Vector3 b)
	{
		Vector3 vector;
		vector = new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
		return Mathf.Sqrt(vector.x * vector.x + vector.y * vector.y + vector.z * vector.z);
	}
	public static float SqrMagnitude(Vector3 a)
	{
		return a.x * a.x + a.y * a.y + a.z * a.z;
	}
	public static Vector3 Min(Vector3 lhs, Vector3 rhs)
	{
		return new Vector3(Mathf.Min(lhs.x, rhs.x), Mathf.Min(lhs.y, rhs.y), Mathf.Min(lhs.z, rhs.z));
	}
	public static Vector3 Max(Vector3 lhs, Vector3 rhs)
	{
		return new Vector3(Mathf.Max(lhs.x, rhs.x), Mathf.Max(lhs.y, rhs.y), Mathf.Max(lhs.z, rhs.z));
	}
	public static float AngleBetween(Vector3 from, Vector3 to)
	{
		return Mathf.Acos(Mathf.Clamp(Vector3.Dot(Normalize(new Vector3(from)), Normalize(new Vector3(to))), -1f, 1f));
	}

	public static Vector3 Addition(Vector3 a, Vector3 b)
	{
		return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	public static Vector3 Multiply(float d, Vector3 a)
	{
		return new Vector3(a.x * d, a.y * d, a.z * d);
	}
	public static Vector3 Multiply(Vector3 a, float d)
	{
		return new Vector3(a.x * d, a.y * d, a.z * d);
	}
	public static Vector3 Substract(Vector3 a, Vector3 b)
	{
		return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
	}
	public static Vector3 Division(Vector3 a, float d)
	{
		return new Vector3(a.x / d, a.y / d, a.z / d);
	}
	// Override
	@Override
	public Object clone()
	{
		return new Vector3(this);
	}
}
