package com.ds.strings;

import com.ds.utils.InputReader;

/**
 * 
 * @author karthik
 * Given a text txt[0....N-1] and a pattern[0...M-1] N>M
 * Find Whether this pattern occurs in the String 
 */

/**
 * 
 * @author karthik
 * Best Case O(n) occurs when the first character of the pattern does not occur in text 
 * txt[]="ABCDGHMKL"
 * patt[]="FAA"
 * 
 *  Worst Case occurs when in the following Scenarios
 *  txt[]="AAAAAAAAAAAAA"
 *  pat[]="AAA"
 *  
 *  txt[]="AAAAAAAAAAAAAB"
 *  pat[]="AAB"
 *  
 *  O(m*(n-m+1))
 */
public class PatternSearch1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternSearch1 search=new PatternSearch1();
		search.solve();

	}
	public void solve()
	{
		InputReader reader=new InputReader(getClass().getResourceAsStream("/pattern.txt"));
		
		//Read the text 
		String text=reader.readLine();
		int n=text.length();
		System.out.println("The text to searched is"+text);
		
		//Read the pattern
		String pattern=reader.readLine();
		int m=pattern.length();
		System.out.println("The pattern is"+pattern);
		
		//Search the whether the text contains this pattern 
		for(int i=0;i<=n-m;i++)
		{
			int j=0;
			for(;j<m;j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==m)
				System.out.println("The pattern is found in the text at the place"+(i));
		}
	}

}
