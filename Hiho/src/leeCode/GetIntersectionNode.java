package leeCode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class GetIntersectionNode {
	/**
	 * 暴力法
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	/*
	 * public ListNode getIntersectionNode(ListNode headA, ListNode headB) { if
	 * (headA==null && headB==null) return null; ListNode p1 = headA; ListNode
	 * p2 = headB; while(p1!=null){ while(p2!=null){ if (isSameNode(p1, p2)) {
	 * return p2; } p2 = p2.next; } p1 = p1.next; p2 = headB; } return null; }
	 */
	/**
	 * 双指针法
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		int lenA = 0;
		int lenB = 0;
		ListNode p1 = headA;
		ListNode p2 = headB;
		ListNode p3 = null;
		int flag = 0;
		
		while (p1.next != null) {
			lenA++;
			p1 = p1.next;
		}
		while (p2.next != null) {
			lenB++;
			p2 = p2.next;
		}
		int dv = 0;
		if (lenA == lenB) {
			p1 = headA;
			p2 = headB;
		}
		if (lenA > lenB) {
			dv = lenA - lenB;
			p1 = headA;
			p2 = headB;
			while (dv > 0) {
				p1 = p1.next;
				dv--;
			}
		}
		if (lenA < lenB) {
			dv = lenB - lenA;
			p1 = headA;
			p2 = headB;
			while (dv > 0) {
				p2 = p2.next;
				dv--;
			}
		}
		while (p1 != null) {
			if (p1.val == p2.val && flag == 0) {
				p3 = p1;
				p1 = p1.next;
				p2 = p2.next;
				flag = 1;
			} else if (p1.val == p2.val && flag == 1) {
				p1 = p1.next;
				p2 = p2.next;
			} else if (p1.val != p2.val) {
				flag = 0;
				p1 = p1.next;
				p2 = p2.next;
			}
		}

		return p3;

	}

	public boolean isSameNode(ListNode node1, ListNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1.val == node2.val) {
			if (isSameNode(node1.next, node2.next)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n6.next = n3;

		ListNode listNode = new GetIntersectionNode().getIntersectionNode(n1,
				n6);
		if (listNode != null) {
			System.out.println(listNode.val);
		}
		System.out.println("null");
	}
}
