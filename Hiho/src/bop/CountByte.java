package bop;
/**
 * 计算一个二进制数中有多少个1
 * @author lh
 *
 */
public class CountByte {
public int count(Byte v){
	int num = 0;
	while(v != 0){
		num += v & 0x01;
		v = (byte)(v >> 1);//移位后返回int类型，需要强制转换
	}
	return num;
}

public static void main(String[] args){
	System.out.println(new CountByte().count((byte)(0x011)));
}
}
