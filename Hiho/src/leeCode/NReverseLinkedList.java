package leeCode;//未完成,看的答案
import leeCode.DeleteNode.ListNode;
public class NReverseLinkedList {
public static ListNode reverseList(ListNode head){/*tail 和 head竟然是指向的同一个地址，对tail的修改会影响到head的值
	
	if (head==null || head.next==null) {
		return head;
	}
	else {
		ListNode front = head;
		ListNode half = head;
		ListNode tail = head;
//		tail.next = null;
		half.next = null;
		while(head.next != null){
			head = head.next;
			front = head;
			front.next = half;
			half = front;
		}//跳出循环时
		return half; 
	}	
	
*/  if (head == null || head.next == null) {
	System.out.println(head.val);
	return head;
}
		ListNode next = head.next;
		head.next = null;
		ListNode root = reverseList(next);
		next.next = head;
		System.out.println(head.val);
		return root;

	}
public static void main(String[] args){
	ListNode a = new ListNode(1);
	ListNode b = new ListNode(2);
	ListNode c = new ListNode(3);
	ListNode d = new ListNode(4);
//	a = b;
////	b = c;
//	a.val = 999;
//	System.out.println(a.val);
//	System.out.println(b.val);
	a.next = b;
	b.next = c;
	c.next = d;
	d.next = null;
	reverseList(a);
	while(a.next != null)
		System.out.println(a.val);
}
}
