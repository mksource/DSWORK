package com.ds.strings;

public class PrintReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str=new String("Aruba Networks");
		reverse(str,0);
	}
	public static void reverse(String str,int cur)
	{
		if(cur<=str.length()){
		reverse(str,cur+1);
			if(cur>=0 && cur<str.length())
				System.out.print(str.charAt(cur)+" ");
		}
	}

}
