package leeCode;

public class FindTheDifference {
static char  findTheDifference(String s, String t){
	int len = s.length();
	char c = t.charAt(len);
	System.out.println(c);
	for(int i= 0; i < len; i++){
		c ^=  s.charAt(i);
		c ^=  t.charAt(i);
	}
	System.out.println('a' ^ 'c');
	return c;
}

public static void main(String[] args){
	findTheDifference("abcd","abcde");
	//System.out.println('a' ^ 'c');
}
}
