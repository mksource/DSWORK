package com.ds.trees;

public class BST {
	
	private  Node root;
	
	public BST()
	{
		root=null;
	}
	
	//Method to Print the tree in the pre-order manner 
	public void preorder(Node v)
	{
		if(v==null)return;
		System.out.print(v.data+" ");
		preorder(v.left);
		preorder(v.right);
	}
	
	//Method to print the tree in the post-order manner 
	public void postorder(Node v)
	{
		if(v==null)return;
		postorder(v.left);
		postorder(v.right);
		System.out.print(v.data+" ");
	}
	
	//Method to print the tree in the in-order manner 
	public void inorder(Node v)
	{
		if(v==null)return;
		inorder(v.left);
		System.out.print(v.data+" ");
		inorder(v.right);
	}
	
	//Method to insert an element into BST 
	public void insert(int element)
	{
		//Make a new Node
		Node newNode=new Node();
		newNode.data=element;
		newNode.left=null;
		newNode.right=null;
		
		if(root==null)
		{
			root=newNode;
		}
		else
		{
			Node cur=root;
			Node prev=null;
			while(cur!=null)
			{
				//Go the left Subtree 
				if(element<cur.data)
				{
					prev=cur;
					cur=cur.left;
				}
				else
				{
					prev=cur;
					cur=cur.right;
				}
			}
			if(element<prev.data)
				prev.left=newNode;
			else 
				prev.right=newNode;
		}
	}
	
	//Method to search a node returns the node or null if the element is not found in the tree 
	public Node search(int element)
	{
		Node cur=root;
		
		while(cur!=null)
		{
			if(cur.data>element)
			{
				cur=cur.left;
			}
			else if(cur.data<element)
			{
				cur=cur.right;
			}
			else
				return cur;
				
		}
		
		return cur;
	}
	
	//Method to delete a Node given the element 
	void delete(int element)
	{
		Node cur=root;
		Node parent=root;
		boolean isLeftChild=false;;
		
		//Find the element
		while(cur!=null)
		{
			
			if(cur.data>element)
			{
				isLeftChild=true;
				parent=cur;
				cur=cur.left;
			}
			else if(cur.data<element)
			{
				isLeftChild=false;
				parent=cur;
				cur=cur.right;
			}
			else
				
				break;
		}
		
		if(cur==null)
		{
			System.out.println("Element not found");
		}
		else
		{
			//Case 1:If the Node is a leaf 
			if(cur.left==null && cur.right==null)
			{	
				if(cur==root)root=null;
				else if(isLeftChild)
					parent.left=null;
				else 
					parent.right=null;
				
			}
			//Case 2a:If the Node to be deleted has only left child
			else if((cur.left!=null && cur.right==null))
			{
				if(cur==root)
				{
					root=cur.left;
				}
				else if(isLeftChild)
				{
					parent.left=cur.left;
				}
				else
				{
					parent.right=cur.left;
				}
			
			}		
			//case 2b:If the Node to be deleted has only right child
			else if((cur.left==null && cur.right!=null))
			{
				if(cur==root)
				{
					root=cur.right;
				}
				else if(isLeftChild)
				{
					parent.left=cur.right;
				}
				else
				{
					parent.right=cur.right;
				}
			}
			//Case 3:If the Node has two child 
			else
			{
				//find the inorder succcessor of the node to be deleted
				//For a Node with two children  the inorder successor is always minimum element in the right subtree
				Node succ=findSuccessor(cur);
				
				//case 3a.If the successor does not not have right child or if the successor is the right child of the node to be deleted
				if(succ.right==null || cur.right==succ)
				{
					if(cur==root)
						root=succ;
					else if(isLeftChild)
						parent.left=succ;
					else 
						parent.right=succ;
					succ.left=cur.left;
				}
				
					
				//case 3b.If the successor has a right child (But will not have a left child)	
				else
				{
					//Find parent of the successor 
					Node succparent=root;
					Node itr=root;
					while(itr!=null)
					{
						
						if(succ.data<itr.data)
						{
							succparent=itr;
							itr=itr.left;
						}
						else if(succ.data>itr.data){
							succparent=itr;
							itr=itr.right;
						}
							
						else
							break;
							
					}
					
					succparent.left=succ.right;
					succ.left=cur.left;
					succ.right=cur.right;
					
					if(cur==root)
						root=succ;
					else if(isLeftChild)
						parent.left=succ;
					else 
						parent.right=succ;
					
					
					
				}
				
			}
				
		}
		
	}
	
	//Method to find the successor of the node 
	public Node  findSuccessor(Node v)
	{
		//Step-1 If the right subtree of Node v is not null 
		//successor of the node will smallest element in the right subtree 
		if(v.right!=null)
		{
			Node succ=v.right;
			while(succ.left!=null)
				succ=succ.left;
			return succ;	
		}
		
		//Step-2 If the right subtree of Node v is null 
		//successor of the node will be 
		Node rootNode=root;
		Node succ=null;
		while(rootNode!=null)
		{
			if(v.data<rootNode.data)
			{
				succ=rootNode;
				rootNode=rootNode.left;
			}
			else if(v.data>rootNode.data)
			{
				rootNode=rootNode.right;
			}
			else
				break;
		}
		
		return succ;
		
	}
	
	
	
	//Method to find the minimum element in BST
	public int min(Node v)
	{
		if(v.left==null)return v.data;
		return min(v.left);
	}
	
	//Method to find the maximum element in BST 
	public int max(Node v)
	{
		if(v.right==null)return v.data;
		return max(v.right);
	}
	//Given a BST and two values a and b write a method which prints all nodes such that a < node_value <b
	public void intr(Node v,int a,int b)
	{
		if(v==null)return;
		intr(v.left,a,b);
		if((a<v.data) &&(v.data<b)) System.out.println(v.data);
		intr(v.right,a,b);
	}
	
	public static void main(String args[])
	{
		//Create a Binary Search tree 
		BST tree=new BST();
		
		/*Tree1*/
		/*tree.insert(30);
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);*/
		
		//Tree2
		tree.insert(24);
		tree.insert(12);
		tree.insert(35);
		tree.insert(8);
		tree.insert(31);
		tree.insert(36);
		tree.insert(17);
		tree.insert(7);
		tree.insert(27);
		tree.insert(32);
		tree.insert(34);
		tree.insert(29);
		tree.insert(27);
		tree.insert(30);
		
		tree.intr(tree.getRoot(),21,32);
		
	
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
