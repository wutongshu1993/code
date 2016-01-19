package leeCode;

public class IsSameTree {
public static class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}
public static boolean isSameTree(TreeNode p, TreeNode q){
	if (p==null && q==null) {
		return true;
	}
	else if (p!=null && q!=null) {
		
		if (p.val == q.val) {
			TreeNode p_left = p.left;
			TreeNode p_right = p.right;
			TreeNode q_left = q.left;
			TreeNode q_right = q.right;
			if (isSameTree(p_right, q_right)&&isSameTree(p_left,q_left)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	else  {
		return false;
	} 
}
public static void main(String[] args){
	TreeNode p = new TreeNode(1);
	TreeNode q = new TreeNode(1);
	TreeNode p1 = new TreeNode(2);
	TreeNode p2 = new TreeNode(3);
	TreeNode p3 = new TreeNode(4);
	TreeNode p4 = new TreeNode(5);
	TreeNode p5 = new TreeNode(6);
	TreeNode q1 = new TreeNode(2);
	TreeNode q2 = new TreeNode(3);
	TreeNode q3 = new TreeNode(4);
	TreeNode q4 = new TreeNode(5);
	TreeNode q5 = new TreeNode(6);
	p.left = p1;
	p.right = p2;
	p1.left = p3;
	p1.right = p4;
	p3.left = p5;
	q.left = q1;
	q.right = q2;
	q1.left = q3;
	q1.right = q4;
	q3.right = q5;
	System.out.println(isSameTree(p, q));
	
}
}
