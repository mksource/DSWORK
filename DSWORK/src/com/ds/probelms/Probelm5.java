package com.ds.probelms;

import com.ds.lists.SNode;
import com.ds.lists.SingleLinkedList;
import com.ds.utils.InputReader;

/**
 * Given a Single linked list to pairwise swap of the elements data 
 * 
 *
 */

public class Probelm5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm5 solve=new Probelm5();
		solve.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/probelm5.txt"));
		SingleLinkedList list=new SingleLinkedList();
		
		int num=in.readInt();
		for(int i=0;i<num;i++)
		{
			list.insert(in.readInt());
		}
		
		System.out.println("The list before the pairwise swap");
		for(SNode cur=list.getHEADER();cur!=null;cur=cur.next) System.out.print(cur.data+" ");
		
		pairwiseswap(list);
		System.out.println(" ");
		System.out.println("The list after the pairwise swap");
		for(SNode cur=list.getHEADER();cur!=null;cur=cur.next)System.out.print(cur.data+" ");
	}
	public void pairwiseswap(SingleLinkedList list)
	{
		SNode curNode=list.getHEADER();
		
		
		while(curNode!=null && curNode.next!=null)
		{
			int temp=curNode.data;
			curNode.data=curNode.next.data;
			curNode.next.data=temp;
			curNode=curNode.next.next;
			
		}
	}

}
