package com.ds.lists;


public class SingleLinkedList {
	
	private SNode HEADER;
	
	public SingleLinkedList()
	{
		HEADER=null;
	}
	
	public SNode getHEADER() {
		return HEADER;
	}

	public void setHEADER(SNode hEADER) {
		HEADER = hEADER;
	}

	public void insert(int element)
	{
		//Create a new element and insert at the front 
		SNode newNode=new SNode();
		newNode.data=element;
		newNode.next=HEADER;
		HEADER=newNode;
		
	}
	public void remove()
	{
		//Remove the element at the front 
		if(!isEmpty())
		{
			SNode nextNode=HEADER.next;
			HEADER=nextNode;
		}
	}
	public boolean isEmpty()
	{
		return HEADER==null;
	}
	
	

}
