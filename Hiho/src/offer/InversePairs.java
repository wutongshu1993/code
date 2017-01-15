package offer;

import java.util.Arrays;

/**
 * 求数组中的逆序对
 * @author lh
 *
 */
public class InversePairs {
	public int total;
	//复杂度太高
public int InversePairs(int [] array) {
	int count = 0;
    for(int i = 0; i < array.length; i++){
    	for(int j = i+1; j < array.length; j++){
    		if(array[i] > array[j]){
    			count++;
    		}
    	}
    }    
	return count;
    }
//另一种解法，先将数组一分为2,递归，直到每组只剩1个元素的时候，统计并合并排序。
public int solution(int[] array){
	sort(array, 0, array.length - 1);
	return total;
}
//将args[i...m]和args[m+1...n]归并为temp[i...n]
public void merge(int[] array, int i, int m, int n){
	int[] temp = new int[array.length];
	int p = m;
	int q = n;
	int index = n;
	int unit = 0;
	while(p >= i && q >= m+1){
		if(array[p] < array[q]){
			temp[index--] = array[q];
			q--;
		}
		else {
			temp[index--] = array[p];
			p--;
			int per = q - m;
			total = total + per;
		}
	}
	while(p >= i){//前面这部分还有，因此需要计算逆序对
		temp[index--] = array[p];
		p--;
		
	}
	if(q > m+1){
		unit = q - m;
	}
	while(q >= m+1){
		temp[index--] = array[q];
		q--;
		if(q > m + 1){
			total = total + unit;
		}
	}
	for(int tem = i; tem<array.length; tem++ ){
		array[tem]= temp[tem++];
	}
	
}
public void sort(int[] array, int left, int right){
	
	if(left >= right){
		return;
	}
	int mid = (left + right) / 2;
	sort(array, left, mid);
	sort(array, mid + 1, right);
	merge(array, left, mid, right);
}


//第三种基于第二种的方法
int Inverse(int[] array){
	if(array == null || array.length < 0){
		return 0;
	}
	int[] copy = Arrays.copyOf(array, array.length);
	int count = InversePairsCore(array, copy, 0, array.length - 1);
	
	return count;
}
int InversePairsCore(int[] data, int[] copy, int start, int end){
	if(start == end){
		copy[start] = data[start];
		return 0;
	}
	int len = (end - start) / 2;
	int left = InversePairsCore(data, copy, start, start + len);
	int right = InversePairsCore(data, copy, start+len+1, end);
	data = Arrays.copyOf(copy, copy.length);
	int i = start + len;//前半段的最后一个数字的下标
	int j = end;
	int index = end;
	int count = 0;
	while(i >= start && j>=start+len+1){
		if(data[i] > data[j]){
			copy[index--] = data[i--];
			count += j-start-len;
		}
		else {
			copy[index--] = data[j--];
		}
	}
	while(i>=start){
		copy[index--] = data[i--];
	}
	while(j >= start+len+1){
		copy[index--] = data[j--];
	}

	return left + right + count;
}

public static void main(String[] args){
	int[] array = {7,5,6,4};
//	System.out.println(new InversePairs().InversePairs(array));
//	System.out.println(new InversePairs().solution(array));
	System.out.println(new InversePairs().Inverse(array));
}
}
