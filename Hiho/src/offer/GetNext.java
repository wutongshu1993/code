package offer;
/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣 
 * ע�⣺���Ĳ��������е�һ���ڵ㣬����֪�����ڵ����Ϣ��
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
        		if(pNode.next.left == pNode){//����������
    				return pNode.next;
    			}
    			else if(pNode.next.right == pNode) {//���������������ϱ�����ֱ���ҵ�һ���ڵ㣬�������ڵ�����ӣ��õ����Ҫ�ҵĵ㡣
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
	//Ѱ����pNodeΪ���ڵ����������ĵ�һ���ڵ�
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
