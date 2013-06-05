package com.ds.trees;


import com.ds.trees.BinaryTree;
import com.ds.trees.JQueue;

public class BFS{
	
	
	
	public static  void bfs1(Node root)
	{
		//Implementation using queue
		Node tempNode=root;
		JQueue q=new JQueue();
		while(tempNode!=null)
		{
			System.out.println(tempNode.data+" ");
			if(tempNode.left!=null)
				q.add(tempNode.left);
			else if(tempNode.right!=null)
				q.add(tempNode.right);
			tempNode=(Node) q.remove();
		}
		
	}
	
	public static void main(String args[])
	{
		BinaryTree tree=new BinaryTree() ;
		tree.insert(30);
		tree.insert(10);
		tree.insert(40);
		tree.insert(25);
		tree.insert(33);
		tree.insert(35);
		tree.insert(47);
		tree.insert(8);
		
		bfs1(tree.root);
		
		
	}

	

}
