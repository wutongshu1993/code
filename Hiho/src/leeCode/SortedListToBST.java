package leeCode;
/**
 * 找出中间节点作为root节点
 * @author lh
 *
 */
public class SortedListToBST {
	 public TreeNode sortedListToBST(ListNode head) {
	     TreeNode[] nodes = getArrays(head);
	     int h = nodes.length - 1;
	     TreeNode root = arrToBST(nodes, 0, h);
		 return root;
	    }
	 /**
	  * 将listnode转化为一个数组
	  * @param head
	  * @return
	  */
	 public TreeNode[] getArrays(ListNode head){
		 TreeNode[] nodes;
		 int len = 0;
		 ListNode p = head;
		 while(p != null){
			len++;
			p = p.next;
		 }
		 int i = 0;
		 nodes = new TreeNode[len];
		 while(head != null){
			 nodes[i] = new TreeNode(head.val);
			 head = head.next;
			 i++;
		 }
		 return nodes;
	 }
	 public TreeNode arrToBST(TreeNode[] nodes, int l, int h){
		 if(l > h){
			 return null;
		 }
		 int m = (l + h) / 2;
		 TreeNode root = nodes[m];
		 root.left = arrToBST(nodes, l, m-1);
		 root.right = arrToBST(nodes, m+1, h);
		 return root;
	 }
	 public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		new SortedListToBST().sortedListToBST(head);
	 }
}
