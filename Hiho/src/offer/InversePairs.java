package offer;

import java.util.Arrays;

/**
 * �������е������
 * @author lh
 *
 */
public class InversePairs {
	public int total;
	//���Ӷ�̫��
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
//��һ�ֽⷨ���Ƚ�����һ��Ϊ2,�ݹ飬ֱ��ÿ��ֻʣ1��Ԫ�ص�ʱ��ͳ�Ʋ��ϲ�����
public int solution(int[] array){
	sort(array, 0, array.length - 1);
	return total;
}
//��args[i...m]��args[m+1...n]�鲢Ϊtemp[i...n]
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
	while(p >= i){//ǰ���ⲿ�ֻ��У������Ҫ���������
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


//�����ֻ��ڵڶ��ֵķ���
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
	int i = start + len;//ǰ��ε����һ�����ֵ��±�
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
