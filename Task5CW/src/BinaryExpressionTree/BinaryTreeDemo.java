package BinaryExpressionTree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		NodeTree root= new NodeTree(7,null,null);
		BinaryTree bt= new BinaryTree(root);
		
		for(int i=1;i<10;i++){
		NodeTree newNode=new NodeTree(i,null,null);
		bt.AddNode(newNode, bt.root);
		}
		
		bt.Search(17, bt.root);
	}

}
