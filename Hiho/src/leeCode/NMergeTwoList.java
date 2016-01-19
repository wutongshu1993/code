package leeCode;

import leeCode.DeleteNode.ListNode;
//¿´µÄ´ð°¸
public class NMergeTwoList {
public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
if (l1 == null) return l2;
if (l2 == null) return l1;
//ListNode head = l1.val < l2.val ? l1 : l2;
//ListNode nonHead = l1.val < l2.val ? l2 : l1;
//head.next = mergeTwoLists(head.next, nonHead);
//return head;
ListNode tmp;
if (l1.val > l2.val) {
	tmp = l2;
	l2 = l1;
	l1 = tmp;
}
ListNode p = l1;
while(l2!=null){
	while(p.next!=null && p.next.val <= l2.val){p = p.next;}
	tmp = p.next;
	p.next = l2;
	l2 = tmp;
}
return l1;
} 
public static void main(String[] args){
	ListNode l1 = new ListNode(1);
	l1.next = new ListNode(4);
	ListNode l2 = new ListNode(2);
	l2.next = new ListNode(3);
	mergeTwoLists(l1, l2);
}
}
