package leeCode;

import java.util.LinkedList;
import java.util.List;

public class Pow {
public double myPow(double x, int n) {
    double ret = 1;
    if(x == 1) return 1;
    if(x == -1){
    	n = n & 0x01;
    	if(n == 1) return -1;
    	else {
			return 1;
		}
    }
	if(n < 0){
		if (n == Integer.MIN_VALUE) {
			n = Integer.MAX_VALUE;
		}
		else {
			n = -n;
		}
		while(n > 0 && ret != 0){
			ret /= x;
			n --;
		}	
	}
	if(n > 0){
		while( n > 0 && ret != 0){
			ret *= x;
	    	n --;
		}
	}
	return ret;
    }
//这样也很慢
public double myPow3(double x, int n) {
    double ret = 1;
    if(x == 1) return 1;
    if(x == -1){
    	n = n & 0x01;
    	if(n == 1) return -1;
    	else {
			return 1;
		}
    }
	if(n < 0){
		if (n == Integer.MIN_VALUE) {
			n = Integer.MAX_VALUE;
		}
		else {
			n = -n;
		}
		x = 1 / x;
	}
		while( n > 0 && ret != 0){
			ret *= x;
	    	n --;
		}
	return ret;
    }
/**
 * 采用递归的思想,是要快很多！！
 * @param x
 * @param n
 * @return
 */
public double myPow2(double x, int n) {
	if(n == 0) return 1;
	 if(x == 1) return 1;
	if(x == -1){
    	n = n & 0x01;
    	if(n == 1) return -1;
    	else {
			return 1;
		}}
	if( n < 0) {
		if (n == Integer.MIN_VALUE) {
			n = Integer.MAX_VALUE;
		}
		else {
			n = -n;
		}
		x = 1 / x;
	}
	
	return (n % 2 == 0) ? myPow2(x*x, n/2) : x * myPow2(x * x, n / 2);
}

public static void main(String[] args){
	System.out.println(Math.abs(-3));
	System.out.println(new Pow().myPow3(-2, 3));
}
}
