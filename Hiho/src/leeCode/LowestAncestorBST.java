package leeCode;
import leeCode.IsSameTree.TreeNode;
public class LowestAncestorBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (p.val > q.val) {//��p,q����Ϊp<q
			TreeNode temp;
			temp=p;
			p=q;
			q=temp;
		}
		if (p.val <= root.val && q.val>=root.val) {
			return root;
		}
		if (p.val>root.val) {//p,q����root����������
			root = root.right;
			return lowestCommonAncestor(root, p, q);
		}
		if (q.val<root.val) {//p,q����root����������
			root = root.left;
			return lowestCommonAncestor(root, p, q);
		}
		return null;
	}
}
