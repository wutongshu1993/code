package leeCode;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class Main {
	static class Node{
		int in=0;
		Node left=null;
		Node right = null;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		HashMap<Integer,Node> map = new HashMap<Integer,Node>();
		if(n==1){
			System.out.println(1);
			return;
		}
		while(scanner.hasNext()){//
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			Node father = null;
			Node child= null;
			if(map.containsKey(num1)){//当num1节点已经存在于map中，可以取出num1的
				father = map.get(num1);
			}
			else{
				father = new Node(num1);//这个节点还未出现过
				map.put(num1, father);
			}
			if(map.containsKey(num2)){
				child = map.get(num2);
			}
			else{
				child = new Node(num2);
				map.put(num2, child);
			}
			
			child.in++;//在孩子位出现过，in就会加一
			if(father.left==null){
				father.left = child;
			}
			else{
				father.right = child;
			}
			
		}
		
		Node root = findRoot(map);
		int deep = treeDeep(root);
		System.out.println(deep);
	}
	
	private static Node findRoot(HashMap<Integer,Node> map){
		Set<Integer> set = map.keySet();
		Node root = null;
		for(Integer tem:set){
			if(map.get(tem).in==0){
				root = map.get(tem);
				return root;
			}
		}
		return null;
	}
	
	private static int treeDeep(Node root){
		int leftDeep = 0;
		int rightDeep = 0;
		if(root==null) return 0;
		if(root.left!=null){
			leftDeep = treeDeep(root.left);
		}
		if(root.right!=null){
			rightDeep = treeDeep(root.right);
		}
		return leftDeep>rightDeep?(1+leftDeep):(1+rightDeep);
	}
}
