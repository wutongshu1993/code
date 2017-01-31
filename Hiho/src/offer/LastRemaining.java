package offer;

import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字，0~n-1 围成一圈报数0~m-1，每次遇到m-1的数字就出列，下一个人继续报数，求最后剩下的那个编号.
 * 约瑟夫环的问题，关键是两个标志位
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

