package com.ds.probelms;

import com.ds.lists.SNode;
import com.ds.lists.SingleLinkedList;
import com.ds.utils.InputReader;

/**
 * 
 * @author karthik
 *Delete nodes which have a greater value on the right side
 */
public class Probelm4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/probelm.txt"));
		SingleLinkedList list=new SingleLinkedList();
		
		int num=in.readInt();
		
		for(int i=0;i<num;i++)
			list.insert(in.readInt());
		
		SNode head=deleteRight(list.getHEADER());
	}
	public SNode deleteRight(SNode root)
	{
		if(root.next==null)
			return root;
		else{
			SNode right=deleteRight(root.next);
			if(right!=null && right.data>root.data)
				root.next=right.next;
			return root;
		}
	}

}
