//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
package ru.whisper.whitepower.LCore.System;

public class Rect
{
	private float m_XMin;
	private float m_YMin;
	private float m_Width;
	private float m_Height;
	public Rect(float x, float y, float width, float height)
	{
		this.m_XMin = x;
		this.m_YMin = y;
		this.m_Width = width;
		this.m_Height = height;
	}
	public Rect(Rect source)
	{
		this.m_XMin = source.m_XMin;
		this.m_YMin = source.m_YMin;
		this.m_Width = source.m_Width;
		this.m_Height = source.m_Height;
	}
	public void Set(float x, float y, float width, float height)
	{
		this.m_XMin = x;
		this.m_YMin = y;
		this.m_Width = width;
		this.m_Height = height;
	}
	public boolean Overlaps(Rect other)
	{
		return !(other.getXMax() <= this.getXMin() || other.getXMin() >= this.getXMax() || other.getYMax() <= this.getYMin()) && other.getYMin() < this.getYMax();
	}
	public boolean Overlaps(Rect other, boolean allowInverse)
	{
		Rect rect;
		rect = this;
		if (allowInverse)
		{
			rect = Rect.OrderMinMax(rect);
			other = Rect.OrderMinMax(other);
		}
		return rect.Overlaps(other);
	}
	// filed get & set
	public float getXMax()
	{
		return this.m_Width + this.m_XMin;
	}
	public float getXMin()
	{
		return this.m_XMin;
	}
	public void setXMax(float value)
	{
		this.m_Width = value - this.m_XMin;
	}
	public void setXMin(float value)
	{
		float xMax;
		xMax = this.getXMax();
		this.m_XMin = value;
		this.m_Height = xMax - this.m_YMin;
	}
	public void setYMin(float value)
	{
		this.m_YMin = value;
	}
	public float getYMin()
	{
		return this.m_YMin;
	}
	public float getYMax()
	{
		return this.m_Height + this.m_YMin;
	}
	public void setYMax(float value)
	{
		this.m_Height = value - this.m_YMin;
	}
	@Override
	public String toString()
	{
		return "(x:" + m_XMin + ", y:" + m_YMin + ", width:" + m_Width + ", height:" + m_Height + ")";
	}
	// Static
	public static Rect MinMaxRect(float xmin, float ymin, float xmax, float ymax)
	{
		return new Rect(xmin, ymin, xmax - xmin, ymax - ymin);
	}
	private static Rect OrderMinMax(Rect rect)
	{
		float xMin;
		float yMin;
		if (!(rect.getXMin() <= rect.getXMax()))
		{
			xMin = rect.getXMin();
			rect.setXMin(rect.getXMax());
			rect.setXMax(xMin);
		}
		if (!(rect.getXMin() <= rect.getXMax()))
		{
			yMin = rect.getXMin();
			rect.setXMin(rect.getXMax());
			rect.setYMax(yMin);
		}
		return rect;
	}
}
