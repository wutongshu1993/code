package leeCode;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @author Administrator
 *For example, given input 43261596 
 *(represented in binary as 00000010100101000001111010011100), 
 *return 964176192 
 *(represented in binary as 00111001011110000010100101000000).
 */
public class ReverseBit {
public int reverseBits(int n) {
    byte[] arr = new byte[32];
    arr = intToByte32(n);
    arr = reverseByte32(arr);
    return byte32ToInt(arr);
    }
/**
 * 将整数转化为二进制数
 * @param n
 * @return
 */
public byte[] intToByte32(int n){
	byte[] arr = new byte[32];
	for(int i=31;i>=0;i--){
		arr[i] = (byte)(n&1);
		n=n>>1; 
	}
	return arr;
}
/**
 * 将二进制数转化为整数
 * @param arr
 * @return
 */
public int byte32ToInt(byte[] arr){
	int sum = 0;
	for(int i=0;i<32;i++){
		sum |= arr[i] <<(31-i);
		//<<是循环左移，低位用0补齐   
		//>>循环右移，高位补符号位
		//无符号右移( >>> ) 高位补0
	}
	return sum;
}
public int bytenToInt (char[] arr, int size){
	int sum =0;
	for(int i=0;i<size;i++){
		int temp = arr[i] << (size-1-i);
		sum |= arr[i] << (size-1-i);
	}
	return sum;
}
public char[] intToByten(int n,int size){
	char[] arr = new char[size];
	for(int i=size-1;i>=0;i--){
		arr[i] = (char)(n&1);
		n = n>>1;
	}
	return arr;
}
public byte[] reverseByte32(byte[] arr){
	byte[] b = new byte[32];
	for (int i = 0; i < arr.length; i++) {
		b[i] = arr[31-i];
	}
	return b;
}
/**
 * Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".
 * @param a
 * @param b
 * @return
 */
/*public String addBinary(String a, String b){
	byte[] test;
	try {
		test = a.getBytes("iso8859-1");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	char[] arr = a.toCharArray();
	char[] brr = b.toCharArray();
	byte[] a_byte = new byte[32];
	byte[] b_byte = new byte[32];
	for(int i=arr.length-1;i>=0;i--){
		a_byte[31-i] = (byte)arr[i];
	}
	for(int i=brr.length-1;i>=0;i--){
		b_byte[31-i] = (byte)brr[i];
	}
	int na = byte32ToInt(a_byte);
	int nb = byte32ToInt(b_byte);
	int sum = na +nb;
	byte[] result = intToByte32(sum);
//	String s = result.toString();
	return null;
	

}*/
public String addBinary(String a, String b) {
    int c = 0;
    StringBuilder sb = new StringBuilder();
    for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;){
        if(i >= 0) c += a.charAt(i--) - '0';
        if(j >= 0) c += b.charAt(j--) - '0';
        sb.insert(0, (char)((c % 2) + '0'));
        c /= 2;
    }
    if(c == 1) sb.insert(0, "1");
    return sb.toString();
}
public static void main(String[] args){
//	System.out.println(new ReverseBit().reverseBits(43261596 ));
//	byte[] arr = {
//			0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,
//			0,0,0,0,0,0,0,0,
//			0,0,0,1,
//			1,1,1,0};
	
//	System.out.println(new ReverseBit().byte4ToInt(arr));	
//	System.out.println(5>>2);//1
//	System.out.println(-5>>2);//1
//	System.out.println(5>>2);//1
	System.out.println(new ReverseBit().addBinary("11", "11"));
}
}


/**
 * 较简单的答案
 * @param n
 * @return
 
// you need treat n as an unsigned value
public int reverseBits(int n) {
    int answer = 0; // initializing answer
    for (int i = 0; i < 32; i++) { // 32 bit integers
        answer <<= 1; // shifts answer over 1 to open a space
        answer |= ((n >> i) & 1); // inserts bits from n
    }
    return answer;
}
*/