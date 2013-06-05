package com.ds.probelms;

import com.ds.lists.SNode;
import com.ds.lists.SingleLinkedList;
import com.ds.utils.InputReader;

/**
 * 
 * 
 * To Reverse a Linked List 
 */
public class Probelm6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm6 p=new Probelm6();
		p.process();
	}
	public void process()
	{
		SingleLinkedList list=new SingleLinkedList();
		InputReader in=new InputReader(getClass().getResourceAsStream("/probelm5.txt"));
		
		int num=in.readInt();
		
		for(int i=0;i<num;i++)
			list.insert(in.readInt());
		for(SNode cur=list.getHEADER();cur!=null;cur=cur.next)System.out.print(cur.data+" ");
		System.out.println("");
		SNode newHead=reverseList(list);
		list.setHEADER(newHead);
		for(SNode cur=list.getHEADER();cur!=null;cur=cur.next)System.out.print(cur.data+" ");
	}
	public SNode reverseList(SingleLinkedList list)
	{
		SNode prevNode=null;
		SNode curNode=list.getHEADER();
		SNode nextNode=null;
		
		while(curNode!=null)
		{
			nextNode=curNode.next;
			curNode.next=prevNode;
			prevNode=curNode;
			curNode=nextNode;
		}
		return prevNode;
	}

}
