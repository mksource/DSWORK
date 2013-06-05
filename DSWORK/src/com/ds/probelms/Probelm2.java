package com.ds.probelms;

import com.ds.lists.SNode;
import com.ds.lists.SingleLinkedList;
import com.ds.utils.InputReader;

public class Probelm2 {
	
	private int carry;
	
	public static void main(String args[])
	{
		Probelm2 solve=new Probelm2();
		solve.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/probelm2.txt"));
		SNode head=null;
		SNode result=null;
		
		//Input the list 1 
		int num1_size=in.readInt();
		SingleLinkedList list1=new SingleLinkedList();
		for(int i=0;i<num1_size;i++)
			list1.insert(in.readInt());
		
		//Input the list 2
		int num2_size=in.readInt();
		SingleLinkedList list2=new SingleLinkedList();
		for(int i=0;i<num2_size;i++)
		{
			list2.insert(in.readInt());
		}
		
		System.out.println("The size of first list is"+num1_size);
		System.out.println("The size of the second list is"+num2_size);
		//Compare the size of both lists and do the addition accordingly
		if(num1_size==num2_size)
		{
		    result=addList(list1.getHEADER(),list2.getHEADER());
		   		
		}
		else if(num1_size>num2_size)
		{
			//list1 is larger 
			int diff=num1_size-num2_size;
			SNode cur=list1.getHEADER();
			while(diff!=0)
			{
				cur=cur.next;
				diff--;
			}
			 result=addList(cur,list2.getHEADER());
			result=addCarryToRemainingList(list1.getHEADER(), cur, result);
			
		}
		else
		{
			//list2 is larger
			int diff=num2_size-num1_size;
			SNode cur=list2.getHEADER();
			while(diff!=0)
			{
				cur=cur.next;
				diff--;
			}
		     result=addList(list1.getHEADER(),cur);
			 result=addCarryToRemainingList(list2.getHEADER(),cur,result);
		}
		
		if(carry!=0)
			   head=push(result,carry);
		   else
			   head=result;
		
		//Print The sum list 
		SNode cur=head;
		System.out.println("The sum list is");
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		
	}
	public SNode addList(SNode list1,SNode list2)
	{
		if(list1==null && list2==null)
			return null;
		SNode prev=addList(list1.next,list2.next);
		SNode newNode=new SNode();
		newNode.next=prev;
		int sum=(list1.data+list2.data+carry)%10;
		carry=(list1.data+list2.data+carry)/10;
		newNode.data=sum;
		return newNode;
	}
	public SNode addCarryToRemainingList(SNode head,SNode cur,SNode result)
	{
		if(head!=cur)
		{
			SNode prev=addCarryToRemainingList(head.next,cur,result);
			int sum=(head.data+carry)%10;
			carry=(head.data+carry)/10;
			return push(prev,sum);
			
		}
		return result;
	}
	public SNode push(SNode result,int carry)
	{
		
			SNode head=new SNode();
			head.data=carry;
			head.next=result;
			return head;
		
	}
}
