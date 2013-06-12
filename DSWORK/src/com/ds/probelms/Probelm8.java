package com.ds.probelms;

/*
 * Given a number find the largest number possible with rearrangement of the digits in O(n) time
 */
public class Probelm8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={4,2,4,1,7};
		Probelm8 p=new Probelm8();
		p.printLargest(arr);

	}
	public void printLargest(int arr[])
	{
		int range[]=new int[9];
		
		//Follow the Counting Sort Strategy
		for(int i=0;i<range.length;i++)
			range[i]=0;
		
		for(int i=0;i<arr.length;i++)
			range[arr[i]]++;
		
		//Print the largest number by traversing the range array in reverse
		for(int i=range.length-1;i>=0;i--)
		{
			int count=range[i];
			if(count==0) continue;
			for(int j=0;j<count;j++)
				System.out.print(i);
		}
	}
	

}
