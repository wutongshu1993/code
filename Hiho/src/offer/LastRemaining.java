package offer;

import java.util.LinkedList;

/**
 * ԲȦ�����ʣ�µ����֣�0~n-1 Χ��һȦ����0~m-1��ÿ������m-1�����־ͳ��У���һ���˼��������������ʣ�µ��Ǹ����.
 * Լɪ�򻷵����⣬�ؼ���������־λ
 * @author Administrator
 *
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        int count = 0;
        int index = 0;
    	if (n < 1 || m < 1) {
			return -1;
		}
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
        	list.add(i);
        }
       while(list.size() > 1){
    	   if(count == m-1){
    		   list.remove(index);
    		   count = 0;
    	   }
    	   else{
    		   count++;
    		   index++;
    		   if(index >= list.size() - 1){
    			   index = index % list.size();
    		   }
    	   }
       }
    	return list.get(0);
    }
public static void main(String[] args){
	int a = new LastRemaining().LastRemaining_Solution(6, 8);
	System.out.println(a);
}
}

