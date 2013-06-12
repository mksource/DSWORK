package com.ds.strings;

import com.ds.utils.InputReader;

/**
 * 
 * @author karthik
 * Boyer-Moore Algorithm 
 * 
 */

public class PatternSearch3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternSearch3 search=new PatternSearch3();
		search.solve();
	}
	public void solve()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/pattern.txt"));
		
		String text=in.readLine();
		String pattern=in.readLine();
		
		KMPAlgorithm(text,pattern);
	}
	public void KMPAlgorithm(String text,String pattern)
	{
		int lps[]=new int[pattern.length()];
		
		//Carry Out the preprocessing Stage
		preprocess(pattern,lps);
		
		//KMP Algorithm 
	}
	public void preprocess(String pattern,int lps[])
	{
		/*
		 * This step will calculate the length of the longest matching prefix 
		 * which is also a suffix of the subpattern[0...i] and will store in the lps[i]
		 */
		
		int len=0;  //length of the longest matching prefix
		int i=1;
		
		lps[i]=0; //lps[0] is always zero
		
		int m=pattern.length();  //Pattern of the length
		
		while(i<m)
		{
			if(pattern.charAt(i)==pattern.charAt(len))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len!=0)
				{
					len=lps[len-1];
				}
				else
				{	
				lps[i]=0;
				i++;
				}
			}
		}
		
		
		
	}

}
