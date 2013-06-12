package com.ds.lists;

import com.ds.utils.InputReader;

/**
 * 
 * @author karthik
 * Given a linked list and two integers M and N.Traverse the list for M Nodes and then delete the next N Nodes and continue 
 * the same
 */

public class Probelm2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm2 p=new Probelm2();
		p.solve();
	}
	public void solve() 
	{
		SingleLinkedList list=new SingleLinkedList();
		InputReader in=new InputReader(getClass().getResourceAsStream("/list.txt"));
		
		int num=in.readInt();
		
		for(int i=0;i<num;i++)
		{
			list.insert(in.readInt());
		}
		
		int m=in.readInt();
		int n=in.readInt();
		
		//Print the list 
		System.out.println("The original list is");
		SNode cur=list.getHEADER();
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		
	    cur=list.getHEADER();
	    SNode mnext=null;
		while(cur!=null)
		{
			//Traverse the m nodes and retain  it 
			for(int count=1;count<m && cur!=null;count++)
				cur=cur.next;
			
			//We have reached the end of the list 
			if(cur==null)
				break;
			
			//Delete the N nodes
			mnext=cur.next;
			for(int count=0;count<n && mnext!=null;count++){
				mnext=mnext.next;
			}
			
			//Skip the Nodes
			cur.next=mnext;
			cur=mnext;
		}
		
		System.out.println("The modified list is");
		cur=list.getHEADER();
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}

}
