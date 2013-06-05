package com.ds.lists;

import com.ds.utils.InputReader;
/**
 * 
 * @author karthik
 * swap kth node from beginning with kth node at end 
 */
public class Probelm1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm1 p=new Probelm1();
		p.compute();

	}
	public void compute()
	{
		SingleLinkedList list=new SingleLinkedList();
		InputReader in=new InputReader(getClass().getResourceAsStream("/list.txt"));
		
		//Get the number of elements to be inserted into the list 
		int num=in.readInt();
		
		for(int i=0;i<num;i++)
		{
			list.insert(in.readInt());
		}
		
		//Get the kth position 
		int k=in.readInt();
		swap(k,list);
		in.close();
	}
	public void swap(int k,SingleLinkedList list)
	{
		//Find whether kth position is valid or not 
		int size=1;
		SNode cur=list.getHEADER();
		while(cur!=null){
			size++;
			cur=cur.next;
		}	
		//Check if k is valid
		if(k>size)
		{
			System.out.println("The Kth position of list is greater than the size of list");
			return;
		}
		
		//Check if the kth node from start and kth node from end are the same
		if(2*k-1==size)return;
		
		//Get the kth node from the beginning and the kth node from the end and also the prev pointers also
		SNode kstart=list.getHEADER();
		SNode kstartprev=null;
		SNode kend=list.getHEADER();
		SNode kendprev=null;
		cur=list.getHEADER();
		int i=1;
		
		while(cur!=null)
		{
			if(i<k)
			{
				kstart=kstart.next;
				kstartprev=kstart;
			}
			else if(i>k)
			{
				kend=kend.next;
				kendprev=kend;
			}
			i++;
			cur=cur.next;
		}
		
		System.out.println("The "+k+"th node from start"+kstart.data);
		System.out.println("The "+k+"th node from end"+kend.data);
		
		
		if(kstartprev!=null)
			kstartprev.next=kend;
		if(kendprev!=null)
			kendprev.next=kstart;
		
		//swap the next nodes 
		SNode temp=kstart.next;
		kstart.next=kend.next;
		kend.next=temp;
		
		if(k==1)
			list.setHEADER(kend);
		if(k==size)
			list.setHEADER(kstart);
		
		
	}

}
