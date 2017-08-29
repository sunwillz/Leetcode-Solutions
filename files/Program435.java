package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Program435 {

	public static void main(String[] args) {

	}
    public static int eraseOverlapIntervals(Interval[] intervals) {
    		if(intervals==null||intervals.length==0) return 0;
//        	Arrays.sort(intervals,(a,b)->a.end-b.end);
    		Arrays.sort(intervals,new Comparator<Interval>(){
				@Override
				public int compare(Interval o1, Interval o2) {
					if(o1.start==o2.start) return o1.end-o2.end;
					return o1.start-o2.start;
				}
    			
    		});
    		int maxEnd = intervals[0].end;
    		int ans = 0;
    		for (int i = 1; i < intervals.length; i++) {
				Interval interval = intervals[i];
				if(interval.start<maxEnd){				
                    ans++;
                    maxEnd = Math.min(maxEnd, interval.end);
				}else				
				maxEnd = Math.max(maxEnd, interval.end);
			}

    		return ans; 
    }
}

//  Definition for an interval.
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
 
