package leeCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
/**
 * 输入一个32位有符号整数，把整数转换成16进制输出。
 * 
 * @author lh
 *
 */
public class ToHex {
	static Map<Integer, String> map = new HashMap<Integer, String>();
	
	/**
	 * 这种解法是先把当前的数的与上f，再移位
	 * @param num
	 * @return
	 */
public String toHex2(int num){
	int temp;
	String res = "";
	int count = 0;
	if(num == 0){
		return "0";
	}
	if(num == -1){
		return "ffffffff";
	}
//	if(num < -1){
//		int count = 0;
//		while(count < 8){
//			count ++;
//			temp = num & 0xf;
//			num = num >> 4;
//			res = map.get(temp) + res;
//		}
//		return res;
//	}
	while(num != 0 && count < 8){
		count++;
		temp = num & 0xf;
		num = num >> 4;
		res = map.get(temp) + res;
	}
	
	
	return res;
}
/**
 * 这一种想法是分正负两种来讨论，负数的话，先转换为对应的32位二进制，然后再把二进制转化为16进制。	
 * @param num
 * @return
 */
public String toHex(int num) {
    
	int temp;
    String c;
    String res = "";
   
	if(num == 0){
		return "0";
	}
	if(num == -1){
		return "ffffffff";
	}
	if (num < -1 ) {
		byte arr[] = intToByte32(num);
		res = byteToHex(arr);
	}
    while(num > 0){
    	temp = num % 16;
    	num = num / 16;
    	c = map.get(temp);
    	res = c + res;
     } 
	return res;  
    }

public static void main(String[] args){
	init();
	ToHex toHex = new ToHex();
	System.out.println(toHex.toHex2(-2));
	//System.out.println(toHex.intToByte32(-2));
}
public static void init(){
	map.put(0, "0");
	map.put(1, "1");
	map.put(2, "2");
	map.put(3, "3");
	map.put(4, "4");
	map.put(5, "5");
	map.put(6, "6");
	map.put(7, "7");
	map.put(8, "8");
	map.put(9, "9");
	map.put(10, "a");
	map.put(11, "b");
	map.put(12, "c");
	map.put(13, "d");
	map.put(14, "e");
	map.put(15, "f");
}

public byte[] intToByte32(int n){
	byte[] arr = new byte[32];
	for(int i=31;i>=0;i--){
		arr[i] = (byte)(n&1);
		n=n>>1; 
	}
	return arr;
}
public String byteToHex(byte arr[]){
	String str = "";
	String res = "";
	int count = 0;
	for(int i = 0; i< 32; i++){
		count ++;
		str += arr[i];
		if(count == 4){
			count = 0;
			switch (str) {
			case "0000":
				res += "0";
				break;
			case "0001":
				res += "1";
				break;
			case "0010":
				res += "2";
				break;
			case "0011":
				res += "3";
				break;
			case "0100":
				res += "4";
				break;
			case "0101":
				res += "5";
				break;
			case "0110":
				res += "6";
				break;
			case "0111":
				res += "7";
				break;
			case "1000":
				res += "8";
				break;
			case "1001":
				res += "9";
				break;
			case "1010":
				res += "a";
				break;
			case "1011":
				res += "b";
				break;
			case "1100":
				res += "c";
				break;
			case "1101":
				res += "d";
				break;
				
			case "1110":
				res += "e";
				break;
			case "1111":
				res += "f";
				break;
			default:
				break;
			}
			str = "";
		}
	}
	return res;
}

}
