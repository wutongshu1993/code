package leeCode;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
/**
 * 给出一个不重叠的范围，把一个新的范围插入进去，使不重叠
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * @author lh
 *
 */
public class InsertInterval {
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    int from = -1;
	    int to = -1;
	    int flag = 0;
		 for(int i = 0; i < intervals.size(); i++){
	    	switch(compare(intervals.get(i), newInterval)){
	    	case "0":
	    		{
	    			if(from != -1){
	    				//merge
	    				Interval nInterval = new Interval(Math.min(intervals.get(from).start, newInterval.start), newInterval.end);
	    				intervals.add(i, nInterval);
	    				for(int j = from; j < i; j++){
	    					intervals.remove(from);
	    				}
	    				return intervals;
	    			}
	    			else {
	    				if(newInterval.end == intervals.get(i).start){
	    					Interval nInterval = new Interval(newInterval.start, intervals.get(i).end);
	    					intervals.set(i, nInterval);
	    					return intervals;
	    				}
	    				intervals.add(i, newInterval);
		    			return intervals;
					}
	    			
	    		}
	    	case "1":
	    		to = i;
	    		if(from != -1){
	    			Interval nInterval = new Interval(Math.min(intervals.get(from).start, newInterval.start), Math.max(intervals.get(to).end, newInterval.end));
	    			intervals.add(i + 1, nInterval);
	    			//删除了，序号会变的
	    			for(int j = from; j <= to ;j++){
	    				intervals.remove(from);
	    			}
	    			return intervals;
	    		}
	    		else {
					Interval nInterval = new Interval(newInterval.start, intervals.get(i).end);
					intervals.set(i, nInterval);
					return intervals;
				}
//	    		Interval nInterval = new Interval(newInterval.start, intervals.get(i).end);
//	    		intervals.set(i, nInterval);
//	    		return intervals;
	    		//break;
	    	case "2":
	    		return intervals;
	    	case "3":
	    		from = i;
	    		break;
    		case "4":
    			flag = 1;
    			break;
    		case "5":
//    			from = i;
    			if (from == -1 && to == -1 && i == intervals.size() - 1) {
    				if(flag == 0){
					intervals.clear();
    				intervals.add(0, newInterval);
					return intervals;}
    				else {
//    					Interval nInterval = new Interval(Math.min(intervals.get(from).start, newInterval.start), Math.max(intervals.get(to).end, newInterval.end)) ;
						intervals.set(i, newInterval);
						return intervals;
					}
				}
    			if(from == -1){
    				from = i;
    			}
    			to = i;
    			break;
    			case "6":
    				from = i;
    				break;
    			case "7":
    				to = i;
    				if(from != -1){
    	    			Interval nInterval = new Interval(Math.min(intervals.get(from).start, newInterval.start), Math.max(intervals.get(to).end, newInterval.end));
    	    			intervals.add(i + 1, nInterval);
    	    			//删除了，序号会变的
    	    			for(int j = from; j <= to ;j++){
    	    				intervals.remove(from);
    	    			}
    	    			return intervals;
    	    		}
    	    		else {
    					Interval nInterval = new Interval(newInterval.start, intervals.get(i).end);
    					intervals.set(i, nInterval);
    					return intervals;
    				}
    				
			default:
				break;
	    	}
	    } 
		 
		 if(to == -1 && from != -1){
			 Interval nInterval = new Interval(Math.min(intervals.get(from).start, newInterval.start),Math.max(intervals.get(from).end, newInterval.end) );
			 intervals.set(from, nInterval);
			 return intervals;
		 }
		 if(to != -1 && from == -1){
			 Interval nInterval = new Interval(Math.min(intervals.get(0).start, newInterval.start),Math.max(intervals.get(0).end, newInterval.end) );
			 intervals.set(0, nInterval);
			 return intervals;
		 }
		 if(from != -1 && to != -1){
			Interval nInterval = new Interval(Math.min(intervals.get(from).start, newInterval.start), Math.max(intervals.get(to).end, newInterval.end));
 			//intervals.add(i + 1, nInterval);
 			//删除了，序号会变的
 			for(int j = from; j <= to ;j++){
 				intervals.remove(from);
 			}
 			intervals.add(from, nInterval);
 			return intervals;
		 }
		 
		 
		 intervals.add(newInterval);
		 return intervals; 
	    }
	 
	 public String compare(Interval a, Interval newInterval){
		 if(newInterval.end == a.start ){
			 return "7";//小于、等于start
		 }
		 if(newInterval.end < a.start ){
			 return "0";//小于、等于start
		 }
		 if(newInterval.start < a.start &&  newInterval.end <= a.end){
			 return "1";
		 }
		 if(newInterval.start >= a.start && newInterval.end <= a.end){
			 return "2";
		 }
		 if(newInterval.start >= a.start && newInterval.start <= a.end && newInterval.end > a.end){
			 return "3";
		 }
		 if (newInterval.start == a.end) {
			return "6";
		}
		 if(newInterval.start > a.end){
			 return "4";
		 }
		 if(newInterval.start < a.start && newInterval.end > a.end){
			 return "5";
		 }
		 return null;
	 }
	 
	 public static void main(String[] args){
//		 Interval interval1 = new Interval(1, 3);
//		 Interval interval2 = new Interval(6, 9);
		 Interval interval1 = new Interval(2, 7);
		 Interval interval2 = new Interval(8, 8);
		 Interval interval3 = new Interval(10, 10);
		 Interval interval4 = new Interval(12, 13);
		 Interval interval5 = new Interval(16, 19);
//		 Interval newInterval = new Interval(2, 5);
		 Interval newInterval = new Interval(9, 17);
		 
		 List<Interval> intervals = new ArrayList<>();
		 intervals.add(interval1);
		 intervals.add(interval2);
		 intervals.add(interval3);
		 intervals.add(interval4);
		 intervals.add(interval5);
		 List<Interval> ret = new InsertInterval().insert(intervals, newInterval);
		 System.out.println(ret.toArray().toString());
	 }
}
