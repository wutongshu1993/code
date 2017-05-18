package bop;

import java.util.Scanner;

public class PQPrime {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int orig = num;
			int q = 0;
			int prime = 2;
			while(num > 1 && orig >= prime * prime  ){
				if(num % prime == 0 ){
					num = num / prime;
					q++;
				}
				else {
					prime = getNextPrime(prime+1);
					num = orig;
					q = 0;
				}
			}
			if(num == 1){
				System.out.println(prime+" "+ q);
				return;
			}
			else {
				System.out.println("No");
				return;
			}
			
			
		}
	}
	/**
	 * 获取第n后的第一个素数
	 * @param n
	 * @return
	 */
	public static int getNextPrime(int n){
		boolean flag = false;

		while(!flag){
			for(int i = 2; i < (n / 2)+1; i++){
				if(n % i == 0){
					n++;//n不是素数
					i = 1;
//					continue;
				}
			}
			flag = true;
		}
		return n;
	}
}
