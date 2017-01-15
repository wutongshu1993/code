package offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * ����treeset��ʵ�������ȥ�أ�������Arraylist.addAll�Ϳ��԰�collection�е�Ԫ�ؼ��뵽arraylist��
 * ��Ҫ��д ����
 * @author lh
 *
 */
public class Permutation {
	 public ArrayList<String> Permutation(String str) {
	     ArrayList<String> result = new ArrayList<>();
	     if(str == null || str.length() == 0){
	    	 return result;
	     }
	     char[] chars = str.toCharArray();
	     TreeSet<String> temp = new TreeSet<>();
	     recur(chars, 0, temp);
	     result.addAll(temp);
		 return result;  
	    }
	 public void recur(char[] chars, int begin, TreeSet<String> result){
		 int len = chars.length;
		 if(chars == null || len == 0 || begin > len - 1){
			 return ;
		 }
		 if(begin == len - 1){
			 result.add(String.valueOf(chars));
		 }
		 else {
			 for(int i = begin; i < len; i++){
				 swap(chars, begin, i);
				 recur(chars, begin+1, result);
				 swap(chars, begin, i);
			 }
		}
		
		 
	 }
	 
	 public void swap(char[] x, int a, int b){
		 char t = x[a];
		 x[a] = x[b];
		 x[b] = t;
	 }
	 
	 public static void main(String[] args){
		String str = "abc";
		ArrayList< String> list = new Permutation().Permutation(str);
		System.out.println(1);
	 }
}
