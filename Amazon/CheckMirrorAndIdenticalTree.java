package com.satty.amazon;

/*
 * Approach for Mirror Checking:
> Do the pre­order traversal on both the trees simultaneously.
> if any node doesn’t have corresponding node in the another tree, return false.
> check if left node in one tree is the right node in another tree, and vice verse.
 */
public class CheckMirrorAndIdenticalTree {

	public boolean checkMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
        if(root1.data !=root2.data){
                 return false;
        }
        
		if ((root1 == null && root2 != null)
				|| (root1 != null && root2 == null)) { // if any node doesn't
			// have corresponding node in the another tree, return false
			return false;
		}
		// check if left node in one tree is the right node in another tree, and
		// vice versa
		return checkMirror(root1.left, root2.right)
				&& checkMirror(root1.right, root2.left);

	}
	
	public boolean identicalTrees(Node rootA, Node rootB){
		if((rootA==null)&&(rootB==null)){
			return true;
		}else if((rootA!=null && rootB==null)||(rootA==null && rootB!=null)){
			return false;
		}else if(rootA.data==rootB.data){
			return identicalTrees(rootA.left, rootB.left) && identicalTrees(rootA.right, rootB.right);
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.left.right = new Node(3);
		root1.right = new Node(4);

		Node root2 = new Node(1);
		root2.right = new Node(2);
		root2.right.left = new Node(3);
		root2.left = new Node(4);

		CheckMirrorAndIdenticalTree i = new CheckMirrorAndIdenticalTree();
		System.out.println("Is Mirror Trees : " + i.checkMirror(root1, root2));
		
		BST a = new BST();
		a.insert(2);a.insert(4);a.insert(1);a.insert(3);a.insert(5);
		BST b = new BST();
		b.insert(2);b.insert(4);b.insert(1);b.insert(3);b.insert(5);
		System.out.println(i.identicalTrees(a.root, b.root));
		a.insert(11);b.insert(12);
		System.out.println(i.identicalTrees(a.root, b.root));
	}

}

