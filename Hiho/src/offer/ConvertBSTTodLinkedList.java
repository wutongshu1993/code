package offer;
/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * ˼·��Ҫ��BST��Ϊ˫����������һ����������Ĺ���.
 * ת��Ϊ˫������о�ͦ�鷳��ʵ����Ҳ���á����Ĵ�.
 * �����˸�ȫ�ֱ�����Ϊʲô�����������У�����
 * @author lh
 *
 */
public class ConvertBSTTodLinkedList {
	TreeNode pLastNodeInList = null;
public TreeNode Convert(TreeNode pRootOfTree) {
    convertNode(pRootOfTree);
    //pLastNodeInList���ص���β�ڵ㣬������Ҫ����ͷ���
    TreeNode pHead = pLastNodeInList;
    while(pHead != null && pHead.left != null){
    	pHead = pHead.left;
    }
	return pHead;
    }
//��������͸ĳ�˫������Ĺ���
public void convertNode(TreeNode pNode){
	if(pNode == null){
		return;
	}
	TreeNode pCurrent = pNode;
	if (pCurrent.left != null) {
		convertNode(pCurrent.left);
	}
	pCurrent.left = pLastNodeInList;
	if (pLastNodeInList != null) {
		pLastNodeInList.right = pCurrent;
	}
	pLastNodeInList = pCurrent;
	if(pCurrent.right != null){
		convertNode(pNode.right);
	}
}
public static void main(String[] args){
	TreeNode n1 = new TreeNode(10);
	TreeNode n2 = new TreeNode(6);
	TreeNode n3 = new TreeNode(14);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(8);
	TreeNode n6 = new TreeNode(12);
	TreeNode n7 = new TreeNode(16);
	n1.left = n2;
	n1.right = n3;
	n2.left = n4;
	n2.right = n5;
	n3.left = n6;
	n3.right = n7;
	TreeNode node = new ConvertBSTTodLinkedList().Convert(n1);
	System.out.println(1);
}
}
