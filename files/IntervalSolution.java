package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class IntervalSolution {

	public static void main(String[] args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		for (Interval interval : insert(intervals,new Interval(4,9))){
			System.out.print("["+interval.start+","+interval.end+"] ");
		}
	}
	 public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		 intervals.add(newInterval);
		 
		 return merge(intervals);
	 }
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res= new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0) return res;
		
		Collections.sort(intervals,new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
			
		});
		Interval pre=null;
		for (Interval i : intervals) {
			if(pre==null || pre.end<i.start){
				res.add(i);
				pre=i;
			}else if(pre.end<i.end){
				pre.end=i.end;
			}
		}
		return res;
        
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      
  }
 