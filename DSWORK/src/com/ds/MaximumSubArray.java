package com.ds;

public class MaximumSubArray {
	
	
	
	
	public static void main(String args[])
	{
		int arr2[]={-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		int arr4[]={-6,-2,-3,-4,-1,-5,-5};
		MaximumSubArray max=new MaximumSubArray();
		max.findMaxSubArr(arr2);
		max.findMaxSubArr(arr4);
	}
	public void findMaxSubArr(int[] inputArray)
	{
		int cumulativeSum=0;			//holds the cumulative sum of the array
		int maxSum=0;   				//holds the maximum sum of the continuous items on the array
		int maxStartIndex=0;            //Start index of the subarray whose sum is maximum
		int maxEndIndex=0;              //End index of the subarray whose sum is maximum
		int maxStartIndexUntilNow=0;
		
		for(int currentIndex=0;currentIndex<inputArray.length;currentIndex++)
		{
			cumulativeSum+=inputArray[currentIndex];
			
			if(cumulativeSum>maxSum)
			{
				maxSum=cumulativeSum;
				maxStartIndex=maxStartIndexUntilNow;
				maxEndIndex=currentIndex;
			}
			else if(cumulativeSum<0){
				cumulativeSum=0;
				maxStartIndexUntilNow=currentIndex+1;
			}
		}
		
		 System.out.println("Max sum         : "+maxSum);
	     System.out.println("Max start index : "+maxStartIndex);
	     System.out.println("Max end index   : "+maxEndIndex);
	}

}
