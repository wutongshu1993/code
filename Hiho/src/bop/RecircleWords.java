package bop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/**
 * ���һ������ͨ��ѭ�����ƻ�õĵ��ʣ����ǳ���Щ���ʶ�Ϊһ��ѭ�����ʡ� ���磺picture �� turepic ��������ͬһ��ѭ�����ʡ� ���ڸ���n�����ʣ���Ҫͳ�����n���������ж�����ѭ�����ʡ� 
��������:
�������n+1�У�

��һ��Ϊ���ʸ���n(1 �� n �� 50)

��������n�У�ÿ��һ������word[i]������length(1 �� length �� 50)����Сд��ĸ����


�������:
���ѭ�����ʵ�����

��������:
5
picture
turepic
icturep
word
ordw
��Ŀ���岻��
 * @author lh
 *
 */
public class RecircleWords {
//	static HashSet<String> set = new HashSet<>();
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	
    while (in.hasNextInt()) {//ע��while������case
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
    //ѭ���ж������е�ѭ�����ʵĸ���
    
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
