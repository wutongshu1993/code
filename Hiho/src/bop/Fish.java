package bop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * ţţ��һ����ס���������Ѿ���n���㣬ÿ����Ĵ�СΪfishSize[i] (1 �� i �� n,��Ϊ������)��ţţ��������²�׽���������ס�����ڴ����Ŵ����С��Ķ��ɡ������۲죬ţţ����һ����A�Ĵ�СΪ����һ����B��С��2����10��(����2����С��10����С)����A��Ե���B�����ǵ������ţţҪ����������Ҫ��֤��
1���Ž�ȥ�����ǰ�ȫ�ģ����ᱻ������Ե�
2��������Ž�ȥҲ���ܳԵ�������
��������Ѿ����ڵ����Ѿ��ദ�˺ܾã����������ǻ��ಶʳ������֪���·�����Ĵ�С��Χ[minSize,maxSize](������Ĵ�С����������ʾ),ţţ��֪���ж����ִ�С������Է��������ס� 
��������:
�������ݰ���3��.
��һ��Ϊ�·�����ĳߴ緶ΧminSize,maxSize(1 �� minSize,maxSize �� 1000)���Կո�ָ���

�ڶ���Ϊ��������Ѿ����������n(1 �� n �� 50)

������Ϊ�Ѿ��е���Ĵ�СfishSize[i](1 �� fishSize[i] �� 1000)���Կո�ָ���


�������:
����ж����ִ�С������Է��������ס�������Ĵ�С����������ʾ

��������:
1 12
1
1

�������:
3
 * @author lh
 * �����Ŀ�����⣬Ϊʲô�������·������Ҳ���ܻ�Է������������
 *
 */
public class Fish {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	       
	        while (in.hasNext()) {//ע��while������case
	           ArrayList<Integer> newArray = new ArrayList<>();
	           ArrayList<Integer> old = new ArrayList<>();
	           
	        	int i = 0;
	        	int min = in.nextInt();
	        	int max = in.nextInt();
	           
	           
	           for(int j = min; j <= max; j++ ){
	        	   newArray.add(j);
	           }
	        
	        	int num = in.nextInt();
	        	while(i < num){
	        		old.add(in.nextInt());
	        		i++;
	        	}
	        	int oldnum = old.size();
	        	int count = 0;
	        	//��ʼ����
	        	for(int k = 0; k<newArray.size();k++){
	        		if(canPut(old, newArray.get(k))){
//	        			old.add(newArray.get(k));
	        			count++;
	        		}
	        	}
//	        	System.out.println(old.size() - oldnum);
	        	System.out.println(count);
	        }
	    }
	 public static boolean canPut(ArrayList<Integer> fishes, int size){
		 for(int i = 0; i < fishes.size(); i++){
			 if((size >= fishes.get(i)*2 && size <= fishes.get(i)*10) ){
				 return false;
			 }
			 if(fishes.get(i) >= 2 * size && fishes.get(i) <= 10* size){
				 return false;
			 }
		 }
		 return true;
	 }
}
