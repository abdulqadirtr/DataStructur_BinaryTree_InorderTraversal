package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	Node root;
	
	void insert(int key, String name) {
		/*
		 * All the Values is inserted to newNode
		 */
		Node newNode= new Node(key, name);
		/*
		 * Here the root is checking firt time it's null soo we put the values
		 */
		if(root==null) {
			//this will assign the values of newnode key to root intially
		   root=newNode;
		}
		else {
			/*
			 * In the Second value the condition will start from here
			 * We will make focus node and then keep putting values through parent.left to newNode
			 */
			Node focusNode=root;
			Node parent;
			while(true) {
				parent=focusNode;
				if(key<focusNode.key) {
				focusNode=focusNode.leftChild;
				if(focusNode==null) {
					parent.leftChild=newNode;
					//System.out.println(parent.leftChild);
					return ;
				}
				}
				else {
					focusNode=focusNode.rightChild;
					if(focusNode==null) {
						parent.rightChild=newNode;
						
						return;
					}
				}
			}
		} 
	}
	/*
	 * InOrder Traverse first Print left , then root and then Right
	 */
	public void inOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
			
		}
	}
	/*
	 * PostOrder Traversal first goto Root , then left and then right
	 */
	public void postOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			System.out.println(focusNode);
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			
		}
	}

/*
 * Level order Tree traverse can not be done with linkedlist,
 * it can be done by Queue the code is given below
 */
	public void levelOrderTraversal(Node root) {
		 if(root==null)
	         return;
	     Queue<Node> q=new LinkedList<Node>();
	     q.add(root);
	     while(!q.isEmpty()) {
	    	 //retrieve and remove the head of the tree
	    	 root=q.poll();
	    	 System.out.print(root+" ");
	    	 if(root.leftChild!=null) {
	    		 q.add(root.leftChild);
	    	 }
	    	 if(root.rightChild!=null) {
	    		 q.add(root.rightChild);
	    	 }
	     }
		
	}
	
	
	
	
	/*
	 * Search for the desired Node
=======
	
	/*
	 * PostOrder Traversal first goto Root , then left and then right
>>>>>>> refs/remotes/origin/master
	 */
	public Node findTree(int key) {
		Node focusNode=root;
	while(focusNode.key!=key) {
		if(key<focusNode.key) {
			focusNode=focusNode.leftChild;
		}
		else
		{
			focusNode=focusNode.leftChild;
		}
		if(focusNode==null) {
			return null;
		}
	}
	return focusNode;
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree=new BinaryTree();
		tree.insert(50, "boss");
		tree.insert(25, "vice president");
		tree.insert(15, "Office Manager");
		tree.insert(30, "Sectray");
		tree.insert(85, "Sales Manager");
		tree.insert(26, "Sales");
		/*
		 * tree.node means that root Node is passed which contains all the values
		 */

	//	tree.inOrderTraverseTree(tree.root);
		//tree.postOrderTraverseTree(tree.root);
	//	System.out.println(tree.findTree(25));
		
		tree.levelOrderTraversal(tree.root);

		tree.inOrderTraverseTree(tree.root);
		tree.postOrderTraverseTree(tree.root);
		System.out.println(tree.findTree(25));

		

	}

}
