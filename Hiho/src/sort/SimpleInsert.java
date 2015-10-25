package sort;

public class SimpleInsert {
//из╠Ь
private static void sort(int[] arg){
	int temp,i,j;
	for(i=1;i<arg.length;i++){
		temp = arg[i];
		j = i;
		while(j>0 && arg[j-1] > temp){
			arg[j] = arg[j-1];
			--j;
		}
		arg[j] = temp;
	}
	for(int k =0;k<arg.length;k++)
		System.out.print(arg[k]+" ");
}
public static void main(String[] args){
	int[] a = {49,38,65,97,76,13,27,49};
	sort(a);
}
}
