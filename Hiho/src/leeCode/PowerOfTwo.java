package leeCode;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
//       double temp; 
//       if(n==1) return true;
//       else{
//       temp = (double)n/2;
//       while(temp>1)
//       {
//         temp = temp/2;
//         
//       }
//       if(temp==1) return true;
//       else return false;
//    }
//    	int count = 0;
//        while (n > 0)
//        {
//            count+=(n&0x01);
//            n>>=1;
//        }
//        return count==1;
    	if(n <= 0){ return false;}
        int m = -n; 
        m &= n;// m only have the last digit of n to be 1.
        return m == n; 
   
    }
public static void main(String[] args){
	System.out.println(isPowerOfTwo(5));
}
}
