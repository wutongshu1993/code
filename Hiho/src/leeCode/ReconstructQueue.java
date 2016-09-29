package leeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ReconstructQueue {
	public int[][] reconstructQueue(int[][] people) {
		//PriorityQueue<int[]> queue = new PriorityQueue<>(new listComparator());
		//Arrays arrays = new int[people.length][];
		int [][] array = people;
		int[][] result = new int[people.length][];
		LinkedList< int[]> list = new LinkedList();
//		for(int i = 0; i < people.length; i++){
//		//	queue.offer(people[i]);//add��offer���𣿣�������
//			array[i] = people[i];
//		}
		Arrays.sort(array, new listComparator());
		for(int i = 0; i < array.length; i++){
			insert(list, array[i]);
		}
//		while(queue != null ){
//			insert(list, queue.poll());
//		}
		
		for(int i = 0; i < list.size(); i++ ){
			result[i] = list.get(i);
		}
		
		return result;
	}
	/**
	 * ��elem���뵽ָ��λ��
	 * @param list
	 * @param index
	 * @param elem
	 */
	public void insert(LinkedList< int[]> list, int[] elem){
		if (list.size() == 0) {
			list.add(elem);
			return;
		}
		int count = 0;

			list.add(elem[1], elem);
		
	}
	
	class listComparator implements Comparator<int[]>{

		@Override
		public int compare(int[] first, int[] second) {
			// TODO Auto-generated method stub
			if(first[0] != second[0]){
				return second[0] - first[0];//����һ�����Ľ�������
			}
			else {
				return first[1] - second[1];//�����һ������ȣ����յڶ���������������
			}
			
		}
		
	}
	
	public static void main(String[] args){
		ReconstructQueue queue = new ReconstructQueue();
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		queue.reconstructQueue(people);
	}
}
