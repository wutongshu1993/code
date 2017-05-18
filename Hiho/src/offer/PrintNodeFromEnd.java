package offer;

import java.util.ArrayList;

import javax.lang.model.element.VariableElement;

public class PrintNodeFromEnd {
public static ArrayList<Integer> recur(ListNode head, ArrayList<Integer> res){
	if(head == null){
		return res;
	}
	ListNode next = head.next;
	recur(next, res);
	res.add(head.val);
	System.out.println(head.val);
	return res;
} 

public static ListNode reverseNode(ListNode head){
	if(head == null || head.next == null){
		return head;
	}
	ListNode next = head.next;
	head.next = null;
	ListNode newHead = reverseNode(next);
	next.next = head;
	return newHead;
}


public static void main(String[] args){
	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	n1.next = n2;
	n2.next = n3;
	ArrayList<Integer> array = new ArrayList<>();
	ArrayList<Integer> res = recur(n1, array);
	reverseNode(n1);
System.out.println(0);
}
}
