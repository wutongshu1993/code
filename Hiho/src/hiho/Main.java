package hiho;

import java.io.*;
import java.util.*;
class Test {
}
public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a = 1, b = 400;
        List<String> result = new ArrayList<>();
//        while(cin.hasNextInt())
//        {
//            a = cin.nextInt();
//            b = cin.nextInt();
////            System.out.println(a + b);
//        }
    	for(int i = a; i<=b;i++){
    		if(isShuixh(i)){
    			result.add(i+"");
    			//System.out.println(i);
    		}
    	}
    	if(result.size() > 0){
    	for(int i = 0; i< result.size()-1; i++){
    		System.out.print(result.get(i)+" ");
    	}
    	System.out.print(result.get(result.size() - 1));
    	}
    	else {
			System.out.print("no");
		}
    	//System.out.println(result.toString());
    	
    	
//    	System.out.println(new Main().isShuixh(2));
    }
    
    public static boolean isShuixh(int n){
    int sum = 0;
    int temp = 0;
    int old = n;
    	for(int i = 0; i < 3; i++){
    	temp = n % 10;
    	sum += Math.pow(temp, 3);
    	n = n / 10;
    }
    	if(old == sum ){
    		return true;
    	}
    	return false;	
    }
}
