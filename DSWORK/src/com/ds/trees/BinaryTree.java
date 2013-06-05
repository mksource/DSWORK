package com.ds.trees;

import com.ds.trees.Node;

public class BinaryTree {
	
	public Node root;
	
	public void insert(int element)
	{
		//Insert using the principle of the binary search tree but we 
		//not maintain the strict principle of ordering as in BST
		
		//Construct a new node
		Node v=new Node();
		v.data=element;
		v.left=null;
		v.right=null;
		
		//Insert the node
		if(root==null)
		{
			root=v;
		}
		else
		{
			Node cur=root;
			Node prev=cur;
			boolean isLeftChild=false;
			while(cur!=null)
			{
				prev=cur;
				if(cur.data>element)
				{
					cur=cur.left;
					isLeftChild=true;
				}
				else
				{
					 cur=cur.right;
					 isLeftChild=false;
				}
				   	
			}
			if(isLeftChild)
				prev.left=v;
			else
				prev.right=v;
			
			
		}
		
		
	}
	//Inorder traversal 
	public void inorder(Node v)
	{
		if(v==null)return;
		inorder(v.left);
		System.out.print(v.data+" ");
		inorder(v.right);
	}
	//Method to find a mirror of a tree 
	public Node mirror(Node v)
	{
		if(v==null)return null;
		v.left=mirror(v.left);
		v.right=mirror(v.right);
		Node temp=v.left;
		v.left=v.right;
		v.right=temp;
		return v;
	}
	//Method to print the tree in BFS manner 
	public void BFS(Node v)
	{
		int h=height(v);
		
		for(int i=0;i<h;i++)
		{
			
		}
	}
	//Method which return MaxHeight of the tree
	public int height(Node root)
	{
		if(root==null)return 0;
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		return max(leftHeight,rightHeight)+1;
	}
	public int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*Algorithm to calculate if two trees are isomorphic are not*/
	boolean isIsomorphic(Node root1,Node root2)
	{
		boolean isIsomorphic=false;
		
		
		
		return isIsomorphic;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	public static void main(String args[])
	{
		BinaryTree tree=new BinaryTree();
		
		tree.insert(30);
		tree.insert(10);
		tree.insert(40);
		tree.insert(25);
		tree.insert(33);
		tree.insert(35);
		tree.insert(47);
		tree.insert(8);
		
		tree.inorder(tree.root);
		
		System.out.println("The height of the tree is "+tree.height(tree.root));
		
		
	}
	*/
}
