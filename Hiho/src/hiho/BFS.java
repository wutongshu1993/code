package hiho;


import java.util.LinkedList;


import util.TreeNode;

public class BFS {
LinkedList< TreeNode> list = new LinkedList<>();
public void bfs(TreeNode root){
	if(root == null){
		return ;
	}
	System.out.println(root.val);
	list.add(root.left);
	list.add(root.right);
	bfs(list.remove());
	
	
}

public static void main(String[] args){
	TreeNode root = new TreeNode(9);
	root.left = new TreeNode(7);
	root.right = new TreeNode(8);
	root.left.left = new TreeNode(6);
	root.left.right = new TreeNode(5);
//	root.right.left = new TreeNode(4);;
//	root.right.right = new TreeNode(3);
//	root.left.left.left = new TreeNode(2);
//	root.left.left.left.left = new TreeNode(2);
//	root.val = 1;
	BFS bfs = new BFS();
	bfs.bfs(root);
}
}
