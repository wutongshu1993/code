package bop;
/**
 * ����һ�������������ж��ٸ�1
 * @author lh
 *
 */
public class CountByte {
public int count(Byte v){
	int num = 0;
	while(v != 0){
		num += v & 0x01;
		v = (byte)(v >> 1);//��λ�󷵻�int���ͣ���Ҫǿ��ת��
	}
	return num;
}

public static void main(String[] args){
	System.out.println(new CountByte().count((byte)(0x011)));
}
}
