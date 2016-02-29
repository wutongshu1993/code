package leeCode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int len = 0;
		int base = x;
		while (base > 0) {
			base = base / 10;
			len++;
		}
		int a = 0;
		int b = 0;
		for (int i = 1; i < len / 2 + 1; i++) {
			
			a =(int) ((int) (x % (Math.pow(10, i))) / (Math.pow(10, i-1))) ;
//				b = x % (10 ^ (len - i + 1));
			b = (int) ((int) (x % (Math.pow(10, (len - i + 1)))) / (Math.pow(10, (len - i )))) ;
			if (a != b) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println(new PalindromeNumber().isPalindrome(2442));
	}
}
