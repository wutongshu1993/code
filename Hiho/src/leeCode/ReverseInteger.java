package leeCode;

public class ReverseInteger {
public static int reverse(int x){
	try {
		if (x>=0) {//���������
			String s = String.valueOf(x);//��intתΪString
			String temp ="";
			for(int i=s.length()-1;i>=0;i--)
			{
				temp += s.charAt(i);
			}
			//���ת����ǰ�������Ϊ0������Ҫ��0���˵�
			removeZeros(temp);
		 	return Integer.parseInt(temp);
		}
		else {//����Ǹ���
			String s = String.valueOf(x);//��intתΪString
			String temp ="";
			for(int i=s.length()-1;i>0;i--)
			{
				temp += s.charAt(i);
			}
			//���ת����ǰ�������Ϊ0������Ҫ��0���˵�
			removeZeros(temp);
			temp = "-"+temp;
		 	return Integer.parseInt(temp);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return 0;
	}
	
	
}
//�����������û��������
public static void removeZeros(String s){
	int i=0;//��¼��ͷ��0�м���
	for(i=0;i<s.length();i++){
		if (s.charAt(i) == '0') {
			continue;
		}
		else {
			break;
		}
	}
	s = s.substring(i);
}
public static void main(String[] args){
	System.out.println(reverse(0));
//	System.out.println(Integer.parseInt("-009"));
}
}
