package leeCode;

import java.util.List;

import leeCode.DeleteNode.ListNode;

/**
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * //我的思路是先计算出listnode的长度len，倒数第n个就是正数第len-n个
 * //另外一种思路是两个指针，一个快的，一个慢的；快的先向后移动n的单位，然后快的和慢的一起移动，
 * 当快的到达末尾的时候，慢的所指向的那个node就是要删除的node的前驱
 * 
 * @author lh
 *
 */
public class RemoveNthFromEnd {
	// 我的思路是先计算出listnode的长度len，倒数第n个就是正数第len-n个
	// 另外一种思路是两个指针，一个快的，一个慢的；快的先向后移动n的单位，然后快的和慢的一起移动，当快的到达末尾的时候，慢的所指向的那个node就是要删除的node的前驱
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 0, j = 0, m = 0;
		ListNode p = head;
		ListNode next = head;
		if (p.next == null) {
			return null;
		}
		while (p.next != null) {
			p = p.next;
			i++;// 索引
		}
		j = i - n + 1;
		p = head;
		if (j == 0) {
			head = head.next;
		} else {

			while (m < j) {
				next = p;
				p = p.next;
				m++;
			}
			if (next.next != null) {
				next.next = p.next;
			}
		}
		return head;

	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		// ListNode n4 = new ListNode(3);
		// ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		new RemoveNthFromEnd().removeNthFromEnd(n1, 3);
	}
}
/**
 * if(head == null){ return null; }
 * 
 * ListNode fast = head; ListNode slow = head; for(int i = 0; i < n; i++){ fast
 * = fast.next; } if(fast == null){ head = head.next; return head; }
 * while(fast.next != null){ fast = fast.next; slow = slow.next; } ListNode curr
 * = slow.next; slow.next = curr.next;
 * 
 * return head;
 **/