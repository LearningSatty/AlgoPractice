package com.satty.amazon;


/*		Print the Top view of a Binary Tree 
 * or
 * 		Print the Binary Tree in Vertical Order Path.
  			1
  		  /   \
  		 2	   3
  		/ \	  / \
 	   4   5  6  7
 	   Top View: 8, 4, 2, 1, 3, 7.
  to solve do like this:
  go left ==> level++;
  go right==> level--;
  		level=(0)
  			 1
   level++/    \level--
  		 /      \
  		2	     3
  	   (1)      (-1)
level++/ \--  ++/ \level--
 	  /   \    /   \
 	  4    5   6    7
    (2)   (0) (0)   (-2)	   
Note: In above the value in () shows updated value of level for that node. 	
Example-2 
        1
      /   \
     2     3
      \   
       4  
         \
           5
            \
             6
Top view of the above binary tree is: 2 1 3 6
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopViewBT {

	public static TreeMap<Integer, Integer> ht = new TreeMap<>(); // to sort taken TreeMap

	public void topView(Node root, int level) {
		if (root == null)
			return;
		// create a queue for level order traversal
		Queue<QueuePack> queue = new LinkedList<>();
		// add root with level 0 (create a queue item pack)
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			// take out the items from the package
			Node tnode = q.tnode;
			int lvl = q.level;

			// check if this is the first node you are visiting at the level
//			if (ht.containsKey(lvl)) {
//
//			} else {// print it, its the first element at his level
//				System.out.print(tnode.data + "   ");
//				ht.put(lvl, tnode.data);
//			}
			ht.put(lvl, tnode.data);
			// add the left and right children of visiting nodes to the queue
			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}

	}
	
	public static void display() { // print the bottom view.
		Set<Integer> keys = ht.keySet();
		for (Integer key : keys) {
			System.out.print(ht.get(key) + " ");
		}

	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		//root.left.left.left = new Node(8);
		//root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("\nFollowing are nodes in top view of first Binary Tree");
		TopViewBT p = new TopViewBT();
		p.topView(root, 0);
		p.display();
		//second binary tree
		ht = new TreeMap<>(); 
		Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.left.right.right = new Node(5);
        root1.left.right.right.right = new Node(6);
        System.out.println("\nFollowing are nodes in top view of second Binary Tree");
        p.topView(root1, 0);
	}
}
class QueuePack {
	int level;
	Node tnode;

	public QueuePack(int level, Node tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}
