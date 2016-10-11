package leeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
 * @author lh
 *����״̬�Զ���˼�룬9��״̬��6������
 */
public class ValidNumber {
public boolean isNumber(String s) {
       int [][] transform = {
     {-1,  0,  3,  1,  2,  -1},//0û�����룬��������ո�
     {-1,  8, -1,  1,  4,  5},//1��������
     {-1, -1, -1,  4, -1, -1},//2����.
     {-1, -1, -1,  1,  2, -1},//3����+/-
     {-1,  8, -1,  4, -1,  5},//4ǰ�������ֺ���dot��״̬
     {-1, -1,  6,  7, -1, -1},//5'e' or 'E'������״̬
     {-1, -1, -1,  7, -1, -1},//6����e֮������Sign��״̬
     {-1,  8, -1,  7, -1, -1},//7����e���������ֵ�״̬
     {-1,  8, -1, -1, -1, -1}};//8ǰ������Ч������֮������space��״̬
    final int  INVALID=0, SPACE=1, SIGN=2, DIGIT=3, DOT=4, EXPONENT=5;
	int i = 0;
	int state = 0;
	int inputType ;
	char[] sArr = s.toCharArray();
	char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
	while(i < sArr.length){
		if (sArr[i] == ' ') {
			inputType = SPACE;
		}
		else if(sArr[i] == '-' || sArr[i] == '+'){
			inputType = SIGN;
		}
//		else if ((sArr[i]+"").matches("\\d")) {
//			inputType = DIGIT;
//		}
//		else if (Arrays.binarySearch(digits, sArr[i]) != -1) {
//			inputType = DIGIT;
//		}
		else if(sArr[i] >= '0' && sArr[i] <= '9'){
			inputType = DIGIT;
		}
		else if(sArr[i] == '.'){
			inputType = DOT;
		}
		else if (sArr[i] == 'e' || sArr[i] == 'E') {
			inputType = EXPONENT;
		}
		else {
			inputType = INVALID;
		}
		state = transform[state][inputType];
		if(state == -1){
			return false;
		}
		i++;
	}
	
	return state == 1 || state == 4 || state == 7 || state == 8;
        
    }

public static void main(String[] args){
	System.out.println(new ValidNumber().isNumber(".9"));
}
}
