package bop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/**
 * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。 
输入描述:
输入包括n+1行：

第一行为单词个数n(1 ≤ n ≤ 50)

接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成


输出描述:
输出循环单词的种数

输入例子:
5
picture
turepic
icturep
word
ordw
题目不清不楚
 * @author lh
 *
 */
public class RecircleWords {
//	static HashSet<String> set = new HashSet<>();
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	
    while (in.hasNextInt()) {//注意while处理多个case
    	int num = 0;
    	boolean flag = false;
    	ArrayList<String> array = new ArrayList<>();
    	int i = 0;
    	num = in.nextInt();
//    	set.clear();
        while(i < num){
        	array.add(in.next());
        	i++;
        }
        for(int j = 0; j < array.size();){
        	for(int k = j+1; k < array.size();){
        		while(j < array.size() && k < array.size() &&isRecy(array.get(j), array.get(k))){
        			array.remove(k);
        			flag = true;
        		}
        		if(!flag){
        			k++;
        		}
        		flag = false;
        		
        	}
        	j++;
        }
        System.out.println(array.size());
    }
    //循环判断数组中的循环单词的个数
    
}
public static boolean isRecy(String a, String b){
	if(a.length() != b.length()){
		return false;
	}
	int len = a.length();
	String temp;
	for(int i =1; i < len; i++){
		temp = a.substring(i, len)+a.substring(0, i);
		if(temp.equals(b)){
//			set.add(a);
			return true;
			
		}
	}
	return false;
}
}
