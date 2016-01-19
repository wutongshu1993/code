package leeCode;

public class DeleteNode {
	private static ListNode head;//定义头结点
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			// TODO Auto-generated constructor stub
		}
	} 
public static void deleteNode(ListNode node){
	ListNode next;

	//直接将node的值设为，node的next的值(看的答案)
	 next= node.next;
	if(next!=null){
		node.val = next.val;
		node.next = next.next;
	}
}
public static void main(String[] args){
	ListNode node4 = new ListNode(4);
	node4.next = null;
	ListNode node3 = new ListNode(3);
	node3.next = node4;
	ListNode node2 = new ListNode(2);
	node2.next = node3;
	head = new ListNode(1);
	head.next = node2;
	deleteNode(node3);
}
}
