package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class Activity implements Comparable<Activity>{
	int id;
	int StartTime;
	int EndTime;
	@Override
	public int compareTo(Activity a) {
		// TODO Auto-generated method stub
		if(this.EndTime>a.EndTime)
			return 1;
		else if(this.EndTime<a.EndTime)
			return -1;
		else 
			return 0;
	}
}

public class ActivitySelectionProbelm {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		ArrayList<Activity> list=new ArrayList<Activity>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		
		//Ask for the number of Activities
		System.out.println("Enter the Number of Activities");
		int num=Integer.parseInt(reader.readLine());
		
		//Ask for the end and start time of each activity
		for(int i=0;i<num;i++)
		{
			Activity act=new Activity();
			act.id=i;
			System.out.print("Enter the Starttime for Activity "+(i+1)+":");
			act.StartTime=Integer.parseInt(reader.readLine());
			System.out.print("Enter the Endtime for Activity"+(i+1)+":");
			act.EndTime=Integer.parseInt(reader.readLine());
			list.add(act);
		}
		
		//Sort the Activities according to the finish times 
		Collections.sort(list);
		
		//Print the Sorted Activities list
		for(int i=0;i<num;i++)
		{
			System.out.print("The Details for Activity "+(i+1)+":");
			System.out.print(list.get(i).id+" ");
			System.out.print(list.get(i).StartTime+" ");
			System.out.print(list.get(i).EndTime+" ");
		}
		
		//Pick out the Activities optimally 
		System.out.println("The List of optimal jobs are");
		//Step1:Print the first activity since it has least finish time 
		System.out.print(list.get(0).id+" ");
		int i=0;
		for(int j=1;j<num;j++)
		{
			if(list.get(j).StartTime>=list.get(i).EndTime)
			{
				System.out.println(list.get(j).id+" ");
				i=j;
			}
		}
		
	}

}
