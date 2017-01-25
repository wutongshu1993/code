package offer;
/**
 * ������1���ֵĴ�������1-n�����������г���1�Ĵ�����
 * @author lh
 *
 */
public class NumberOf1Between1AndN {
	 public int NumberOf1Between1AndN_Solution(int n) {
		 int count = 0;
		 int low = 0;
		 int cur;
		
		 for(int i = 1; i <= n; i++){
			 cur = i;
			 
			 while(cur >= 1){
				low = cur % 10;
				 cur = cur / 10;
				 if(low == 1){
					 count++;
				 }
			 }
		 }   
		 return count;
	    }
	 public static void main(String[] args){
		 int count = new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(1);
		 System.out.println(count);
	 }
}
