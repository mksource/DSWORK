package com.ds.probelms;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author karthik
 *Find a pair of numbers from Array that will sum up to k
 */
public class Probelm1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm1 solve=new Probelm1();
		solve.process();
		solve.process1();
	}
	public void process()
	{
		//Approach 1 using a HashSet and arrays
		int[] arr={6,7,8,9,1,16,2,3,14,13,4,5,12,32,44};
		HashSet<Integer> set=new HashSet<Integer>();
		int k=16;
		
		for(int num:arr)
		{
			if(set.contains(k-num))
			{
				System.out.println(num+","+(k-num));
			}
			set.add(num);
		}
		
	}
	public void process1()
	{
		//Approach 2 using a sorted array use two pointers
		int[] arr={6,7,8,9,1,16,2,3,14,13,4,5,12,32,44};
		int k=16;
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		while(i<j)
		{
			int sum=arr[i]+arr[j];
			if(sum==k)
			{
				System.out.println(arr[i]+","+arr[j]);
				i++;
				j--;
			}
			else if(sum<k)
				i++;
			else
				j--;			
			
				
		}
	}

}
