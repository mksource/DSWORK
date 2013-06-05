package com.ds;

import java.util.Stack;

public class MaxNextElement {
	
	public static void main(String args[])
	{
		//{10,7,8,8,56,36,21};
		//4 45 2 25 
		//10 9 8 6 2 3 1 7 11
		
		int arr1[]={10,7,8,8,56,36,21};
		int arr2[]={4,45,2,25};
		int arr3[]={10,9,8,6,2,3,7,11};
		int arr4[]={2,14,10,11,12,53,1,2};
		
		findNextGreatestElement(arr1);
		findNextGreatestElement(arr2);
		findNextGreatestElement(arr3);
		findNextGreatestElement(arr4);
		
		
		
	}
	
	public static void findNextGreatestElement(int arr[])
	{
		int maxElem[]=new int[arr.length];
		maxElem[arr.length-1]=-1;
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(0);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[stack.peek()])
			{
				while(!stack.isEmpty() && arr[i]>arr[stack.peek()] )
				{
					int index=stack.pop();
					maxElem[index]=arr[i];
				}
			}
			stack.push(i);
			
				
				
		}
		while(!stack.isEmpty())
		{
			int index=stack.pop();
			maxElem[index]=-1;
		}
		
		//Print the maximum element array 
		for(int k=0;k<arr.length;k++)
			System.out.println(maxElem[k]);
		
	}

}
