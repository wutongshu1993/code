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
*/  ListNode next = head.next;
	head.next = null;
	if (next != null) {
		ListNode root = reverseList(next);
		next.next = head;
		return root;
		
	}
	return head;

	}
public static void main(String[] args){
	ListNode a = new ListNode(1);
	ListNode b = new ListNode(2);
	ListNode c = new ListNode(3);
	a.next = b;
	b.next = c;
	c.next = null;
	reverseList(a);
	while(a.next != null)
		System.out.println(a.val);
}
}
