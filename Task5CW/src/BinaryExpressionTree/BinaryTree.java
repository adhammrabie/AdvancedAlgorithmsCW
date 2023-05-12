package BinaryExpressionTree;

public class BinaryTree {
	NodeTree root;

	public BinaryTree(NodeTree root) {
		this.root = root;
	}
	
	public void AddNode(NodeTree NewNode, NodeTree rootExplore) {
		if (rootExplore == null) 
			return;
		
		if (NewNode.value > rootExplore.value) {
			if (rootExplore.right == null)
				rootExplore.right = NewNode;
			else
				AddNode(NewNode, rootExplore.right);
		}
		
		if (NewNode.value < rootExplore.value) {
			if (rootExplore.left == null)
				rootExplore.left = NewNode;
			else
				AddNode(NewNode, rootExplore.left);
		}
	}
	
	public void Search(int value, NodeTree rootExplore) {
		if (rootExplore == null) {
			System.out.println("Value cannot be found");
			return;
		}
			
		if (rootExplore.value == value) {
			System.out.println("Value has been found");
			return;
		}
		
		if (value > rootExplore.value) {
			Search(value, rootExplore.right);
		}
		
		if (value < rootExplore.value) {
			Search(value, rootExplore.left);
		}
	}
}