//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.System;

import ru.whisper.whitepower.LCore.System.Geometry.Vector3;

public class Ray
{
	private Vector3 m_Origin;
	private Vector3 m_Direction;

	public Vector3 getOrigin()
	{
		return this.m_Origin;
	}
	public void setOrigin(Vector3 value)
	{
		this.m_Origin = value;
	}
	public Vector3 getDirection()
	{
		return this.m_Direction;
	}
	public void setDirection(Vector3 value)
	{
		this.m_Direction = Vector3.Normalize(value);
	}
	public Ray(Vector3 origin, Vector3 direction)
	{
		this.m_Origin = origin;
		this.m_Direction = Vector3.Normalize(direction);
	}
	public Vector3 GetPoint(float distance)
	{
		return Vector3.Addition(this.m_Origin, Vector3.Multiply(this.m_Direction, distance));
	}
}
