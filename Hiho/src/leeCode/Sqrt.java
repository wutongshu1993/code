package leeCode;

public class Sqrt {
	//������̫���ˣ���ʱ��
public int mySqrt(int x){
	int i = 0;
	while(i * i < x){
		i++;
	}
	if(i * i > x){
		i--;
	}
	return i;
}
//���ö��ֵ�˼��  һ��Ҫע�⣺m * m < x �������ܻᵼ����������Բ��� m < x / m �����ķ�ʽ�ﵽ��ͬ��Ч�����ֲ��������
public int mySqrt2(int x){
	int low = 0;
	int high = x;
	int mid = (low + high)/2;
	if(x == 1 || x == 0){
		return x;
	}
	while(!(mid <= x / mid && (mid + 1) > x / (mid+1) )){
		if(mid == x / mid){
			return mid;
		}
		if(mid < x / mid ){//����д�����
			low = mid + 1;
			mid = (low + high)/2;
		}
		if(mid > x / mid){
			high = mid - 1;
			mid = (low + high)/2;
		}
	}
//	if(){
//		
//	}
	
	return mid;
}
public static void main(String[] args){
	System.out.println(new Sqrt().mySqrt2(2147483647));
}
}
/**
 * ���е�һ�ֽⷨ
 * @param x
 * @return

public int sqrt(int x) {
    if (x == 0)
        return 0;
    int left = 1, right = Integer.MAX_VALUE;
    while (true) {
        int mid = left + (right - left)/2;
        if (mid > x/mid) {
            right = mid - 1;
        } else {
            if (mid + 1 > x/(mid + 1))
                return mid;
            left = mid + 1;
        }
    }
} */
