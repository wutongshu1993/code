package hdoj;


import java.util.Scanner;

public class AC {
public static int[] table = new int[26];
public static char[] atable = new char[26];//放a,b,c的数组
public static void main(String[] arg){
	Scanner s = new Scanner(System.in);
	atable[0] ='a';
	atable[1] ='b';
	atable[2] ='c';
	atable[3] ='d';
	atable[4] ='e';
	atable[5] ='f';
	atable[6] ='g';
	atable[7] ='h';
	atable[8] ='i';
	atable[9] ='j';
	atable[10] ='k';
	atable[11] ='l';
	atable[12] ='m';
	atable[13] ='n';
	atable[14] ='o';
	atable[15] ='p';
	atable[16] ='q';
	atable[17] ='r';
	atable[18] ='s';
	atable[19] ='t';
	atable[20] ='u';
	atable[21] ='v';
	atable[22] ='w';
	atable[23] ='x';
	atable[24] ='y';
	atable[25] ='z';
	
	while(s.hasNextLine()){
		for(int i = 0; i < 26; i++){
			table[i] = 0;
		}
		String str = s.nextLine();
		char[] temp = str.toCharArray();
		int i = 0;
		for(i=0; i<temp.length; i++ ){
			int n = temp[i] - 'a';
//			int m = 0;//下标
			if (n>=0 && n<26 ) {
				table[n]++;
			}
			
		}
		if (i == temp.length) {
			for(int j=0;j<26;j++)
			System.out.println(atable[j]+":"+table[j]);
			System.out.println();
			
		}
		
	}
}
}
