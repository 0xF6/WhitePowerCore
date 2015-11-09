package ru.whisper.whitepower.LCore.Interface;

/**
 * Author: eloraam
 */
public interface IRotatable
{
	int getPartMaxRotation(int part, boolean sec);
	int getPartRotation(int part, boolean sec);
	void setPartRotation(int part, boolean sec, int Rotation);
}
