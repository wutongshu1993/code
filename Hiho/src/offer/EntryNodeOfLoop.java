package offer;

import java.util.HashMap;
import java.util.Map;
/**
 * 链表中存在环，找出环的入口节点
 * @author Administrator
 *
 */
public class EntryNodeOfLoop {
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode p = pHead;
        while(pHead.next != null ){
        	try {
        		if(map.containsKey(pHead)){
            		return pHead;
            	}
        	}
        	catch(Exception e){
        		map.put(pHead, false);
        	}
        	
        	map.put(pHead, true);
        	pHead = pHead.next;
        }
		return null;
    }
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		System.out.println(new EntryNodeOfLoop().EntryNodeOfLoop(n1).val);
	}
}
