//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.System.Geometry;

import ru.whisper.whitepower.LCore.System.Mathf;

public class Vector2
{
	public final float kEpsilon = 1E-05f;
	public float x;
	public float y;
	public float get(int index)
	{
		if (index == 0)
		{
			return this.x;
		}
		if (!(index == 1))
		{
			throw new IndexOutOfBoundsException("Invalid Vector2 index!");
		}
		return this.y;
	}
	public void set(int index, float value)
	{
		if (index != 0)
		{
			if (!(index == 1))
			{
				throw new IndexOutOfBoundsException("Invalid Vector2 index!");
			}
			this.y = value;
		}
		else
		{
			this.x = value;
		}
	}

	public Vector2 Normalized()
	{
		Vector2 result;
		result = new Vector2(this.x, this.y);
		result.Normalize(this);
		return result;
	}
	public float magnitude()
	{
		return Mathf.Sqrt(this.x * this.x + this.y * this.y);
	}
	public float sqrMagnitude()
	{
		return this.x * this.x + this.y * this.y;
	}
	public static Vector2 zero()
	{
		return new Vector2(0f, 0f);
	}
	public static Vector2 one()
	{
		return new Vector2(1f, 1f);
	}
	public static Vector2 up()
	{
		return new Vector2(0f, 1f);
	}
	public static Vector2 down()
	{
		return new Vector2(0f, -1f);
	}
	public static Vector2 left()
	{
		return new Vector2(-1f, 0f);
	}
	public static Vector2 right()
	{
		return new Vector2(1f, 0f);
	}
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	public void Set(float new_x, float new_y)
	{
		this.x = new_x;
		this.y = new_y;
	}
	// Static
	public static Vector2 Lerp(Vector2 a, Vector2 b, float t)
	{
		t = Mathf.Clamp01(t);
		return new Vector2(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t);
	}
	public static Vector2 LerpUnclamped(Vector2 a, Vector2 b, float t)
	{
		return new Vector2(a.x + (b.x - a.x) * t, a.y + (b.y - a.y) * t);
	}
	public static Vector2 MoveTowards(Vector2 current, Vector2 target, float maxDistanceDelta)
	{
		Vector2 a;
		float magnitude;
		a = Vector2.Subtraction(target, current);
		magnitude = a.magnitude();
		if (!(magnitude > maxDistanceDelta && magnitude != 0f))
		{
			return target;
		}
		return Vector2.Addition(current, Vector2.Multiply(Vector2.Division(a, magnitude), maxDistanceDelta));
	}
	public static Vector2 Scale(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x * b.x, a.y * b.y);
	}
	public void Scale(Vector2 scale)
	{
		this.x = this.x * scale.x;
		this.y = this.y * scale.y;
	}
	public Vector2 Normalize(Vector2 to)
	{
		float magnitude;
		magnitude = to.magnitude();
		if (!(magnitude <= 1E-05f))
			return Vector2.Division(to, magnitude);
		else
			return Vector2.zero();
	}
	public static Vector2 Reflect(Vector2 inDirection, Vector2 inNormal)
	{
		return Vector2.Addition(Vector2.Multiply(-2f * Vector2.Dot(inNormal, inDirection), inNormal), inDirection);
	}
	public static float Dot(Vector2 lhs, Vector2 rhs)
	{
		return lhs.x * rhs.x + lhs.y * rhs.y;
	}
	public static float Angle(Vector2 from, Vector2 to)
	{
		return Mathf.Acos(Mathf.Clamp(Vector2.Dot(from.Normalized(), to.Normalized()), -1f, 1f)) * 57.29578f;
	}
	public static float Distance(Vector2 a, Vector2 b)
	{
		return Vector2.Subtraction(a, b).magnitude();
	}
	public static Vector2 ClampMagnitude(Vector2 vector, float maxLength)
	{
		if (!(vector.sqrMagnitude() <= maxLength * maxLength))
		{
			return Vector2.Multiply(vector.Normalized(), maxLength);
		}
		return vector;
	}
	public static float SqrMagnitude(Vector2 a)
	{
		return a.x * a.x + a.y * a.y;
	}
	public float SqrMagnitude()
	{
		return this.x * this.x + this.y * this.y;
	}
	public static Vector2 Min(Vector2 lhs, Vector2 rhs)
	{
		return new Vector2(Mathf.Min(lhs.x, rhs.x), Mathf.Min(lhs.y, rhs.y));
	}
	public static Vector2 Max(Vector2 lhs, Vector2 rhs)
	{
		return new Vector2(Mathf.Max(lhs.x, rhs.x), Mathf.Max(lhs.y, rhs.y));
	}
	public static Vector2 Addition(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x + b.x, a.y + b.y);
	}
	public static Vector2 Subtraction(Vector2 a, Vector2 b)
	{
		return new Vector2(a.x - b.x, a.y - b.y);
	}
	public static Vector2 Subtraction(Vector2 a)
	{
		return new Vector2(-a.x, -a.y);
	}
	public static Vector2 Multiply(Vector2 a, float d)
	{
		return new Vector2(a.x * d, a.y * d);
	}
	public static Vector2 Multiply(float d, Vector2 a)
	{
		return new Vector2(a.x * d, a.y * d);
	}
	public static Vector2 Division(Vector2 a, float d)
	{
		return new Vector2(a.x / d, a.y / d);
	}
	public static Vector2 SmoothDamp(Vector2 current, Vector2 target, Vector2 currentVelocity, float smoothTime, float maxSpeed, float deltaTime)
	{
		float num;
		float num2;
		float d;
		Vector2 vector;
		Vector2 vector2;
		float maxLength;
		Vector2 vector3;
		Vector2 vector4;
		smoothTime = Mathf.Max(0.0001f, smoothTime);
		num = 2f / smoothTime;
		num2 = num * deltaTime;
		d = 1f / (1f + num2 + 0.48f * num2 * num2 + 0.235f * num2 * num2 * num2);
		vector = Vector2.Subtraction(current, target);
		vector2 = target;
		maxLength = maxSpeed * smoothTime;
		vector = Vector2.ClampMagnitude(vector, maxLength);
		target = Vector2.Subtraction(current, vector);
		vector3 = Vector2.Multiply(Vector2.Addition(currentVelocity, Vector2.Multiply(num, vector)), deltaTime);
		currentVelocity = Vector2.Multiply(Vector2.Subtraction(currentVelocity, Vector2.Multiply(num, vector3)), d);
		vector4 = Vector2.Addition(target, Vector2.Multiply(Vector2.Addition(vector, vector3), d));
		if (!(Vector2.Dot(Vector2.Subtraction(vector2, current), Vector2.Subtraction(vector4, vector2)) <= 0f))
		{
			vector4 = vector2;
			currentVelocity = Vector2.Division(Vector2.Subtraction(vector4, vector2), deltaTime);
		}
		return vector4;
	}
}
