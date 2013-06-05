package com.ds.probelms;

import com.ds.lists.SNode;
import com.ds.lists.SingleLinkedList;
import com.ds.utils.InputReader;

/*Rotating a given Linked List Clockwise and AntiClockwise direction*/
public class Probelm3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm3 p=new Probelm3();
		p.process();

	}
	public void process()
	{
		SingleLinkedList list=new SingleLinkedList();
		SNode cur=null;
		InputReader in=new InputReader(getClass().getResourceAsStream("/probelm3.txt"));
		
		int num=in.readInt();
		
		for(int i=0;i<num;i++)
			list.insert(in.readInt());
		
		//Number of nodes to rotated 
		int k=in.readInt();
		
		System.out.println("The List before rotation");
		cur=list.getHEADER();
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		
		rotateClockwise(list, k);
		System.out.println("The list after rotation");
		cur=list.getHEADER();
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		
	}
	public void rotateAnitClockwise(SingleLinkedList list,int k)
	{
		int size=0;
		SNode cur=list.getHEADER();
		while(cur!=null)
		{
			cur=cur.next;
			size++;
		}
		rotateClockwise(list,size-k);
	}
	public void rotateClockwise(SingleLinkedList list,int k)
	{
		SNode cur=list.getHEADER();
		SNode knode=list.getHEADER();
		SNode knodeprev=list.getHEADER();
		int i=1;
		int size=0;
		
		while(cur!=null)
		{
			cur=cur.next;
			size++;
		}
		if(k>size)
		{
			System.out.println("List cannot be rotated");
		}
		
		cur=list.getHEADER();
		while(cur!=null)
		{
			if(i>k)
			{
				knodeprev=knode;
				knode=knode.next;
			}
			i++;	
			cur=cur.next;
		}
		
		//Rotate the list 
		knodeprev.next=null;
		
		//Go the the last node in the sublist that has to be rotated
		cur=knode;
		while(cur.next!=null)
			cur=cur.next;
		cur.next=list.getHEADER();
		list.setHEADER(knode);
		
	}

}
