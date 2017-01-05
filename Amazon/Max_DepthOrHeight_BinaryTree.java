package com.satty.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Max_DepthOrHeight_BinaryTree {

	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.left.left.left =new Node(30);
		root.left.right.left = new Node(35);
		root.left.right.left.left = new Node(40);
		root.left.right.left.left.right = new Node(45);
			root.left.right.left.left.right.left = new Node(50);
		Max_DepthOrHeight_BinaryTree i  = new Max_DepthOrHeight_BinaryTree();
		System.out.println("******Recursive Approach******");
		System.out.println(i.recursive_treeHeight(root));
		System.out.println("*******Iterative Approach*******");
		System.out.println(i.getHeight(root));
	}
	
	public int recursive_treeHeight(Node root){
		if(root==null)return 0;
		return (1+ Math.max(recursive_treeHeight(root.left),recursive_treeHeight(root.right)));
	}
	
		// use NULL as a marker at every level, so whenever we encounter null, we
		// will increment the height by 1
	public int getHeight(Node root) {
			Queue<Node> q = new LinkedList<Node>();
			int height = 0;
			// add root to the queue
			q.add(root);
			// add null as marker
			q.add(null);
			while (q.isEmpty() == false) {
				Node n = q.remove();
				// check if n is null, if yes, we have reached to the end of the
				// current level, increment the height by 1, and add the another
				// null as marker for next level
				if (n == null) {
					// before adding null, check if queue is empty, which means we
					// have traveled all the levels
					if(!q.isEmpty()){
						q.add(null);
					}
					height++;
				}else{
					// else add the children of extracted node.
					if (n.left != null) {
						q.add(n.left);
					}
					if (n.right != null) {
						q.add(n.right);
					}
				}
			}
		return height;
	}
	
	
}
