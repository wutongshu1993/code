package offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 丑数
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author lh
 *
 */
public class GetUglyNumber {
	public int GetUglyNumber_Solution(int index) {
        int count = 0;
        int num = 0;
        if(index <= 0){
        	return 0;
        }
        while(count < index){
        	num++;
        	if(isUgly(num)){
        		count++;
        	}
        	
        }
       
		return num;
    }
	public boolean isUgly(int num){
		while(num > 1){
			if(num % 2 == 0){
				num = num / 2;
			}
			else if(num % 3 == 0){
				num = num / 3;
			}
			else if(num % 5 == 0) {
				num = num /5;
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	public int solution(int index){
		TreeSet<Integer> set = new TreeSet<>();
		ArrayList<Integer> res = new ArrayList<>();
		int m2=0;
		int m3 = 0;
		int m5 = 0;
		int m;
		int min;
		set.add(1);
		if(index <= 0){
			return 0;
		}
		while(set.size() < index){
			res.clear();
			res.addAll(set);
			m = res.get(res.size() - 1);
			for(int i= 0; i < res.size(); i++){
				m2 = res.get(i) * 2;
				if(m2 > m){
					break;
				}
			}
			for(int i= 0; i < res.size(); i++){
				m3 = res.get(i) * 3;
				if(m3 > m){
					break;
				}
			}
			for(int i= 0; i < res.size(); i++){
				m5 = res.get(i) * 5;
				if(m5 > m){
					break;
				}
			}
			min = Math.min(Math.min(m2, m3), m5);
			
			set.add(min);
		
		}
		res.clear();
		res.addAll(set);
		return res.get(index-1);
	}
	
	public int solution2(int index){
		if(index <= 0){
			return 0;
		}
		int[] result = new int[index];
		int next = 1;
		result[0] = 1;
		int m2=0;
		int m3=0;
		int m5=0;
		int min;
		while(next < index){
			int i = 0;
			while(m2 <= result[next-1]){
				m2 = result[i] * 2;
				i++;
			}
			i=0;
			while(m3 <= result[next-1]){
				m3 = result[i] * 3;
				i++;
			}
			i=0;
			while(m5 <= result[next-1]){
				m5 = result[i] * 5;
				i++;
			}
			min = Math.min(Math.min(m2, m3), m5);
			result[next] = min;
			m2=0;
			m3=0;
			m5=0;
			next++;
		}
		
		return result[index-1];
	}
	public static void main(String[] args){
		System.out.println(new GetUglyNumber().GetUglyNumber_Solution(10));
		System.out.println(new GetUglyNumber().solution2(10));
	}
}
