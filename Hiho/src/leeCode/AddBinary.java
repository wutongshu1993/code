package leeCode;
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * @author lh
 *
 */
public class AddBinary {
	 public String addBinary(String a, String b) {
	     int len = Math.max(a.length(), b.length());
		 int[] ret = new  int[len + 1];//有可能要进位
		 int cp = 0;
		 int rt = len;
		 int i = a.length() - 1;
		 int j = b.length() - 1;
		 StringBuilder res = new StringBuilder();
		 while(i >= 0 && j >= 0){
			 cp = 0;
//			 int w =  ret[rt] + a.charAt(i) + b.charAt(i) - 48*3;
			 int temp = ret[rt] + a.charAt(i) + b.charAt(j) - 48 * 2;//插入类型的加减法都是先转化为int类型，再计算
			switch(temp){
				case 0:
					ret[rt--] = 0;
					break;
				case 1:
					ret[rt--] = 1;
					break;
				case 2:
					ret[rt--] = 0;
					cp = 1;
					if(rt >=0){
						ret[rt] = 1;
					}
					break;
				case 3:
					ret[rt--] = 1;
					cp = 1;
					if(rt >=0){
						ret[rt] = 1;
					}
					break;
				default:
					break;
				
			}
			i--;
			j--;
		 }
		 
		 while(i >= 0){
			 cp = 0;
//			 int w =  ret[rt] + a.charAt(i) + b.charAt(i) - 48*3;
			 int temp = ret[rt] + a.charAt(i) - 48;
			switch(temp){
				case 0:
					ret[rt--] = 0;
					break;
				case 1:
					ret[rt--] = 1;
					break;
				case 2:
					ret[rt--] = 0;
					cp = 1;
					if(rt >=0){
						ret[rt] = 1;
					}
					break;
				default:
					break;
				
			}
			i--;
		 }
		 
		 while(j >= 0){
			 cp = 0;
//			 int w =  ret[rt] + a.charAt(i) + b.charAt(i) - 48*3;
			 int temp = ret[rt] + b.charAt(j) - 48;
			switch(temp){
				case 0:
					ret[rt--] = 0;
					break;
				case 1:
					ret[rt--] = 1;
					break;
				case 2:
					ret[rt--] = 0;
					cp = 1;
					if(rt >=0){
						ret[rt] = 1;
					}
					break;
				default:
					break;
				
			}
			j--;
		 }
		 if(cp == 1){
			 ret[rt] = 1;
		 }
		 for(int k = 0; k < ret.length; k++){
			 res.append(ret[k]);
		 }
		 if(res.charAt(0) == '0'){
			 return res.substring(1);
		 }
		 return res.toString();
	    }
	 
	 public static void main(String[] args){
	
		 System.out.println(new AddBinary().addBinary("110", "1"));
	 }
}
