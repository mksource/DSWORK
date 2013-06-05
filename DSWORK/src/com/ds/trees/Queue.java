package com.ds.trees;

import com.ds.trees.DoublyLinkedList;

public class Queue {
	
	DoublyLinkedList listQ;
	
	//Doubly Linked List Implementation of Queue with front of the queue being the front side of the list
	//and the back of the list being the rear of the queue
	public void enqueue(int element)
	{
		listQ.insertAtFront(element);
	}
	
	public int  peek()
	{
		return listQ.displayRear();
	}
	
	public int dequeue()
	{
		int rear=listQ.displayRear();
		listQ.deleteAtBack();
		return rear;
	}
	

}
