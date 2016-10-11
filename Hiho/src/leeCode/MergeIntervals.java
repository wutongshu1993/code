package leeCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MergeIntervals {
	
public List<Interval> merge(List<Interval> intervals) {
       List<Interval> res = new LinkedList<>();
       for(int i = 0; i< intervals.size(); i++){
    	  res = insert(res, intervals.get(i)); 
       }
       return res;
    }



public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new LinkedList<>();
    int i = 0;
    // add all the intervals ending before newInterval starts
    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
        result.add(intervals.get(i++));
    // merge all overlapping intervals to one considering newInterval
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        newInterval = new Interval( // we could mutate newInterval here also
                Math.min(newInterval.start, intervals.get(i).start),
                Math.max(newInterval.end, intervals.get(i).end));
        i++;
    }
    result.add(newInterval); // add the union of intervals we got
    // add all the rest
    while (i < intervals.size()) result.add(intervals.get(i++)); 
    return result;
}


public static void main(String[] args){
//	 Interval interval1 = new Interval(1, 3);
//	 Interval interval2 = new Interval(6, 9);
	 Interval interval1 = new Interval(2, 3);
	 Interval interval2 = new Interval(5, 5);
	 Interval interval3 = new Interval(2, 2);
	 Interval interval4 = new Interval(3, 4);
	 Interval interval5 = new Interval(3, 4);
//	 Interval newInterval = new Interval(2, 5);
//	 Interval newInterval = new Interval(9, 17);
	 
	 List<Interval> intervals = new ArrayList<>();
	 intervals.add(interval1);
	 intervals.add(interval2);
	 intervals.add(interval3);
	 intervals.add(interval4);
	 intervals.add(interval5);
	 List<Interval> ret = new MergeIntervals().merge(intervals);
	 System.out.println(ret.toArray().toString());
}
}
