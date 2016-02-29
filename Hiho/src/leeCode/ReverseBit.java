package leeCode;
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
 * ������ת��Ϊ��������
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
 * ����������ת��Ϊ����
 * @param arr
 * @return
 */
public int byte32ToInt(byte[] arr){
	int sum = 0;
	for(int i=0;i<32;i++){
		sum |= arr[i] <<(31-i);
		//<<��ѭ�����ƣ���λ��0����   
		//>>ѭ�����ƣ���λ������λ
		//�޷�������( >>> ) ��λ��0
	}
	return sum;
}
public byte[] reverseByte32(byte[] arr){
	byte[] b = new byte[32];
	for (int i = 0; i < arr.length; i++) {
		b[i] = arr[31-i];
	}
	return b;
}
public static void main(String[] args){
	System.out.println(new ReverseBit().reverseBits(43261596 ));
	byte[] arr = {0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,0,0,0,0,0,
			0,0,0,1,0,1,1,0};
	
	System.out.println(new ReverseBit().byte32ToInt(arr));	
//	System.out.println(5>>2);//1
//	System.out.println(-5>>2);//1
//	System.out.println(5>>2);//1
}
}


/**
 * �ϼ򵥵Ĵ�
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