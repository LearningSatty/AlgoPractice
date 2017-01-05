package com.satty.amazon;

import java.util.Stack;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("******Recursive Approach******");
		BinaryTreeTraversal i = new BinaryTreeTraversal();
		System.out.println("Inorder Traversal:");
		i.inorderRecursive(root);
		System.out.println("\nPreorder Traversal:");
		i.preOrderRecursive(root);
		System.out.println("\nPostorder Traversal:");
		i.postOrderRecursive(root);
		System.out.println();
		System.out.println("\n*******Iterative Approach*******");
		System.out.println("Inorder Traversal Iterative:");
		i.inorderIteration(root);
		System.out.println("\nPreorder Traversal:");
		i.preorderIteration(root);
		i.postorderIteration(root);
		
	}
	
	public void inorderRecursive(Node root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.data + " ");
			inorderRecursive(root.right);
		}
	}

	public void postOrderRecursive(Node root) {
		if (root != null) {
			postOrderRecursive(root.right);
			postOrderRecursive(root.left);
			System.out.print(root.data + " ");
		}
	}

	public void preOrderRecursive(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	
	public void inorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// Go to the left extreme insert all the elements to stack
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			// check if Stack is empty, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack , print it and add the nodes at
			// the right to the Stack
			root =s.pop();
			System.out.print(root.data + " ");
			root = root.right;
		}
	}
	
	public void preorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// First print the root node and then add left node
			while (root != null) {
				System.out.print(root.data + " ");
				s.push(root);
				root = root.left;
			}
			// check if Stack is emtpy, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack and go right to the tree
			root = s.pop();
			root = root.right;
		}
	}
	
	public void postorderIteration(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		// push the root node into first stack.
		s1.push(root);
		while (s1.isEmpty() == false) {
			// take out the root and insert into second stack.
			Node temp = s1.pop();
			s2.push(temp);
			// now we have the root, push the left and right child of root into
			// the first stack.
			if(temp.right!=null){
				s1.push(temp.right);
			}
			if(temp.left!=null){
				s1.push(temp.left);
			}
		}
		//once the all node are traversed, take out the nodes from second stack and print it.
		System.out.println("\nPostorder Traversal Iterative: ");
		while(s2.isEmpty()==false){
			System.out.print(s2.pop().data+" ");
		}
	}

}
