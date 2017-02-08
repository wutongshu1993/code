package offer;
/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。 
 * 注意：给的参数是其中的一个节点，而不知道根节点的信息。
 * @author Administrator
 *
 */
public class GetNext {
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right != null){
        	return getFirst(pNode.right);
        }
        else {
        	if(pNode.next != null){
        		if(pNode.next.left == pNode){//处于左子树
    				return pNode.next;
    			}
    			else if(pNode.next.right == pNode) {//处于右子树，向上遍历，直到找到一个节点，是它父节点的左孩子，该点就是要找的点。
    				while(pNode.next != null){
    					if(pNode.next.left == pNode){
    						return pNode.next;
    					}
    					pNode = pNode.next;
    				}
    				
    				return null;
    			}
    	
        	}
		}
		return null;
    }
	//寻找以pNode为根节点的中序遍历的第一个节点
	public TreeLinkNode getFirst(TreeLinkNode pNode){
		if(pNode.left == null ){
			return pNode;
		}
		else{
			return getFirst(pNode.left);
		}
	}
	
	public static void main(String[] args){
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n6;
		n6.next = n2;
		n3.left = n5;
		n3.right = n7;
		n7.next = n3;
		n4.next = n2;
		n2.next = n1;
		n3.next = n1;
		n5.next = n3;
		System.out.println(new GetNext().GetNext(n7).val);;
		
	}
}
