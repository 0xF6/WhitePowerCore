package ru.whisper.whitepower.LCore.System.Net;

//==============================================================//
//   Copyright © Of Fire Twins Wesp 2015  <ls-micro@ya.ru>      //
//                  Alise Wesp & Yuuki Wesp                     //
//==============================================================//
public interface INetworkObject
{
	/// <summary>
	/// Class to Byte Array
	/// </summary>
	/// <returns></returns>
	byte[] ToByte();
	/// <summary>
	/// Byte Array To Content Class
	/// </summary>
	/// <param name="bitBox">Content</param>
	void outByte(byte[] bitBox);
}
