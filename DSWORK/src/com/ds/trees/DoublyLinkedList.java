package com.ds.trees;

public class DoublyLinkedList {
	
		Node HEADER;
		Node TAILER;
		
		public DoublyLinkedList()
		{
			HEADER=new Node();
			TAILER=new Node();
			HEADER.left=null;
			HEADER.right=TAILER;
			TAILER.right=null;
			TAILER.left=HEADER;
		}
		public void insertAtFront(int element)
		{
			//Construct a new Node
			Node newNode=new Node();
			newNode.data=element;
			newNode.left=null;
			newNode.right=null;
			
			Node right=HEADER.right;
			HEADER.right=newNode;
			newNode.right=right;
			right.left=newNode;
			newNode.left=HEADER;
			
		}
		public void insertAtBack(int element)
		{
			//Construct a new Node
			Node newNode=new Node();
			newNode.data=element;
			newNode.left=null;
			newNode.right=null;
			
			Node left=TAILER.left;
			newNode.left=left;
			TAILER.left=newNode;
			left.right=newNode;
			newNode.right=TAILER;
			
			
		}
		public void deleteAtFront()
		{
			Node old=HEADER.right;
			if(old!=TAILER)
			{
				HEADER.right=old.right;
				old.right.left=HEADER;
			}
			else
			{
				System.out.println("List is empty");
			}
			
			
		}
		public void deleteAtBack()
		{
			Node old=TAILER.left;
			if(old!=HEADER)
			{	
			TAILER.left=old.left;
			old.left.right=TAILER;
			}
			else
			{
				System.out.println("List is empty;");
			}
		}
		private void displayAll()
		{
			Node cur=HEADER.right;
			while(cur!=TAILER)
			{
				System.out.print(cur.data+" ");
				cur=cur.right;
			}
		}
		public int displayRear()
		{
			Node cur=TAILER.left;
			if(cur!=HEADER)
			{
				return cur.data;
			}
			else
			{
				return -1;
			}
		}
		public static void main(String args[])
		{
			DoublyLinkedList dlist=new DoublyLinkedList();
			dlist.insertAtFront(20);
			dlist.insertAtFront(30);
			dlist.insertAtFront(30);
			dlist.insertAtBack(40);
			dlist.insertAtBack(50);
			dlist.insertAtBack(60);
			dlist.insertAtFront(5);
			dlist.displayAll();
		}

}
