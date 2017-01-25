package offer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeSortedListNode {
	 
public ListNode Merge(ListNode list1,ListNode list2) {
    ListNode root;
    ListNode newHead = new ListNode(0);
    root = newHead;
    if(list1 == null && list2 == null){
    	return null;
    }
	while(list1 != null && list2 != null){
    	if(list1.val < list2.val){
    		newHead.next = list1;
    		newHead = newHead.next;
    		list1 = list1.next;
    	}
    	else {
    		newHead.next = list2;
    		newHead = newHead.next;
    		list2 = list2.next;
		}
    }
	while(list1 != null){
		newHead.next = list1;
		newHead = newHead.next;
		list1 = list1.next;
	}
	while(list2 != null){
		newHead.next = list2;
		newHead = newHead.next;
		list2 = list2.next;
	}
	return root.next;
    }
public static void main(String[] args){
	ListNode a = new ListNode(1);
	ListNode b = new ListNode(8);
	ListNode c = new ListNode(5);
	ListNode d = new ListNode(6);
	a.next = b;
	c.next = d;
	new MergeSortedListNode().Merge(a, c);
}
}


