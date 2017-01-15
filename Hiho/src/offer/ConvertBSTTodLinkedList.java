package offer;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：要将BST改为双向链表，就是一个中序遍历的过程.
 * 转换为双向链表感觉挺麻烦，实际上也还好。看的答案.
 * 申请了个全局变量，为什么用作参数不行？？？
 * @author lh
 *
 */
public class ConvertBSTTodLinkedList {
	TreeNode pLastNodeInList = null;
public TreeNode Convert(TreeNode pRootOfTree) {
    convertNode(pRootOfTree);
    //pLastNodeInList返回的是尾节点，我们需要返回头结点
    TreeNode pHead = pLastNodeInList;
    while(pHead != null && pHead.left != null){
    	pHead = pHead.left;
    }
	return pHead;
    }
//中序遍历和改成双向链表的过程
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
