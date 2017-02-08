package offer;

import java.util.ArrayList;

public class LevelOrder {
	 ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		 ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		 travel(res, pRoot, 0);
		 return res; 
	    }
	 public void travel(ArrayList<ArrayList<Integer>> res, TreeNode node, int level){
		 if(node == null){
			 return;
		 }
		 if(res.size() <= level){
			 ArrayList<Integer> list = new ArrayList<>();
			 res.add(list);
		 }
		 ArrayList<Integer> collection = res.get(level);
		 collection.add(node.val);
		 travel(res, node.left, level+1);
		 travel(res, node.right, level+1);
	 }
}
