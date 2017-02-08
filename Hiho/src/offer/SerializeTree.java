package offer;
/**
 * 序列化二叉树和反序列化二叉树
 * @author Administrator
 *
 */
public class SerializeTree {
	//序列化采用前序遍历，空节点用‘$’表示，一个节点如果是叶子节点，后面应该跟上两个空节点,中间用','隔开
	StringBuilder ser = new StringBuilder();
	String Serialize(TreeNode root) {
		if(root == null){
        	ser.append("$,");
        	return "";
        }
        ser.append(root.val+",");
        Serialize(root.left);
        Serialize(root.right);
        return ser.toString().substring(0, ser.length()-1);
	  }
	//将上面序列化的结果反序列化为一棵二叉树,1,2,4,$,$,$,3,5,$,$,6,$,$
	    TreeNode Deserialize(String str) {
	       if(str.length() == 0){
	    	   return null;
	       }
	    	return deserialize(new TreeNode(0), str.split(","));
	  }
	    int i = -1;
	    TreeNode deserialize(TreeNode node, String[] str) {
	    	i++;
	    	if(i < str.length && !str[i].equals("$")){
		    	node = new TreeNode(Integer.parseInt(str[i]));
		    	node.left = deserialize(node.left, str);;
		    	node.right = deserialize(node.right, str);
		    	return node;
		    }
	    	else {
	    		return null;
			}
	  } 
	    public static void main(String[] args){
	    	TreeNode n1 = new TreeNode(1);
	    	TreeNode n2 = new TreeNode(2);
	    	TreeNode n3 = new TreeNode(3);
	    	TreeNode n4 = new TreeNode(4);
	    	TreeNode n5 = new TreeNode(5);
	    	TreeNode n6 = new TreeNode(6);
	    	n1.left = n2;
	    	n1.right = n3;
	    	n2.left = n4;
	    	n3.left = n5;
	    	n3.right = n6;
	    	new SerializeTree().Serialize(new TreeNode(0));
	    	System.out.println();
	    }
}
