package leeCode;

public class UglyNumber {
public boolean isUgly(int n){
	if (n<=0) {
		return false;
	}
	else if(n==1) return true;
	else {
		//����ķ��������õݹ��˼�� 2ms
		int[] a = {2,3,5};
		for(int i=0;i<3;i++){
			if (n%a[i] == 0) {
				n = n/a[i];
			}
		}
		
		if (n==1) {
			return true;
		}
		if (n%2==0 || n%3==0 || n%5==0) {
			return isUgly(n);
		}
		else {
			return false ;
		}
//		return false;
		//�����Ƿǵݹ�ģ��õ�ʱ���ر�� 4ms
//		while(n%2==0) n=n/2;
//		while(n%3==0) n=n/3;
//		while(n%5==0) n=n/5;
//		if (n==1) {
//			return true;
//		}
//		return false;
		//����Ϊ��������һЩ 2ms
		/*while( num > 1){
	        if(num % 2 == 0){
	            num /= 2;
	        }else if( num % 3 == 0){
	            num /=3;
	        }else if(num % 5 == 0){
	            num /= 5;
	        }else{
	            return false;
	        }
	    }*/
	}
	
}
public static void main(String[] args){
	System.out.println(new UglyNumber().isUgly(6));
}
}
