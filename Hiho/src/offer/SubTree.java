package offer;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * �������̷�Ϊ�����֣���һ�������α���root1������root1�еĽڵ��Ƿ��root2�ĸ��ڵ���ȡ�
 * �ڶ����ж�������ӽṹ�Ƿ���ȡ�
 * @author lh
 *2017.1.3
 */
public class SubTree {
public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    boolean result = false;
    if(root1 != null && root2 != null){
    	if(root1.val == root2.val){
    		result = doesTree1HaveTree2(root1, root2);
    	}
    	if(!result){
    		result = HasSubtree(root1.left, root2);
    	}
    	if(!result){
    		result = HasSubtree(root1.right, root2);
    	}
    }
    
	return result; 
    }
//�ж���t1Ϊ���Ľڵ��Ƿ��t2������ͬ�Ľṹ
public boolean doesTree1HaveTree2(TreeNode t1, TreeNode t2){
	
	
	if(t2 == null){
		return true;
	}
	if(t1 == null){
		return false;
	}
	if(t1.val != t2.val){
		return false;
	}
	
	return doesTree1HaveTree2(t1.left, t2.left) && doesTree1HaveTree2(t1.right, t2.right);
		
}

public static void main(String[] args){
	TreeNode n1 = new TreeNode(8);
	TreeNode n2 = new TreeNode(8);
	TreeNode n3 = new TreeNode(7);
	TreeNode n4 = new TreeNode(9);
	TreeNode n5 = new TreeNode(2);
	TreeNode n6 = new TreeNode(4);
	TreeNode n7 = new TreeNode(7);
	n1.left = n2;
	n1.right = n3;
	n2.left = n4;
	n2.right = n5;
	n5.left = n6;
	n5.right = n7;
	TreeNode b1 = new TreeNode(8);
	TreeNode b2 = new TreeNode(9);
	TreeNode b3 = new TreeNode(2);
	b1.left = b2;
	b1.right = b3;
	System.out.println(new SubTree().HasSubtree(n1, b1));
}
}
