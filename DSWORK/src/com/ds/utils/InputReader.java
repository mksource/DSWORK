package com.ds.utils;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader {
	
	private Scanner sc;
	
	public InputReader(InputStream source)
	{
		sc=new Scanner(source);
	}
	public int readInt()
	{
		return sc.nextInt();
	}
	public String readLine()
	{
		return sc.nextLine();
	}
	public void close()
	{
		sc.close();
	}
}
