package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * @author lh
 *
 * ����һ�����������
 * �������Ҳ��һ�����ѵĹ��̰�
 *
 */
public class PrintTreeFromTopToBootom {
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
    if(root == null){
    	return res;
    }
    travel(root, 0, temp);
    for(int i = 0; i < temp.size(); i++){
    	for(int j = 0; j < temp.get(i).size(); j++ ){
    		res.add(temp.get(i).get(j));
    	}
    }
	return res;
    }
public void travel(TreeNode cur, int level, ArrayList<ArrayList<Integer>> temp){
	if(cur == null){
		return;
	}
	if(level >= temp.size() ){
		ArrayList<Integer> newLevel = new ArrayList<>();
		temp.add(newLevel);
	}
	ArrayList<Integer> collection = temp.get(level);
	collection.add(cur.val);
	travel(cur.left, level+1, temp);
	travel(cur.right, level + 1, temp);
}
//����һ�ַ��������α����ýڵ㣬�Լ��ýڵ�����Ӻ��Һ��ӣ�Ȼ���ٳ����С��������ö��С�
public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
	LinkedList<TreeNode> con = new LinkedList<>();
	ArrayList<Integer> res = new ArrayList<>();
	levelTravel(con, res, root);
	return res;
}
public void levelTravel(LinkedList<TreeNode> con, ArrayList<Integer> res, TreeNode root){
	if(root == null){
		return ;
	}
	
	res.add(root.val);
	con.add(root.left);
	con.add(root.right);
	while(con.size() > 0){
		levelTravel(con, res, con.poll());	
	}
	
}
public static void main(String[] args){
	TreeNode n1 = new TreeNode(5);
	TreeNode n2 = new TreeNode(4);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(2);
	TreeNode n5 = new TreeNode(1);
	
	n1.left = n2;
	
	n2.left = n3;
	n3.left = n4;
	n4.left = n5;
	System.out.println(new PrintTreeFromTopToBootom().PrintFromTopToBottom2(n1));
}
}
