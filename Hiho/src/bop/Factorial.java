package bop;

public class Factorial {
	public int countZeros(int n) {
		int ret = 0;
		int j;
		for (int i = 1; i <= n; i++) {
			j = i;
			while (j % 5 == 0) {
				j = j / 5;
				ret++;
			}
		}
		return ret;
	}
public int lowestOne(int n){
	int ret = 0;
	while(n!=0){
		n >>= 1;
		ret += n;
	}
	return ret;
}
	public static void main(String[] args) {
		System.out.println(new Factorial().countZeros(10));
		System.out.println(new Factorial().lowestOne(5));
	}
}
