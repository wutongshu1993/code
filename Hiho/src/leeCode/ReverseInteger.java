package leeCode;

public class ReverseInteger {
public static int reverse(int x){
	try {
		if (x>=0) {//如果是正数
			String s = String.valueOf(x);//将int转为String
			String temp ="";
			for(int i=s.length()-1;i>=0;i--)
			{
				temp += s.charAt(i);
			}
			//如果转换后前面的数字为0，则需要把0过滤掉
			removeZeros(temp);
		 	return Integer.parseInt(temp);
		}
		else {//如果是负数
			String s = String.valueOf(x);//将int转为String
			String temp ="";
			for(int i=s.length()-1;i>0;i--)
			{
				temp += s.charAt(i);
			}
			//如果转换后前面的数字为0，则需要把0过滤掉
			removeZeros(temp);
			temp = "-"+temp;
		 	return Integer.parseInt(temp);
		}
	} catch (Exception e) {
		// TODO: handle exception
		return 0;
	}
	
	
}
//这个函数好像并没有起作用
public static void removeZeros(String s){
	int i=0;//记录排头的0有几个
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
