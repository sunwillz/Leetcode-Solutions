package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Program436 {

	public static void main(String[] args) {
		Interval i1 = new Interval(3,4);
		Interval i2 = new Interval(2,3);
		Interval i3 = new Interval(1,2);
		Interval[] arr ={i1,i2,i3};
		System.out.println(Arrays.toString(findRightInterval(arr)));
 
//		TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
//
//		// populating tree map
//		treemap.put(2, "two");
//		treemap.put(1, "one");
//		treemap.put(3, "three");
//		treemap.put(6, "six");
//		treemap.put(5, "five");
//
//		System.out.println("Ceiling entry for 3: " + treemap.ceilingEntry(3));
//		System.out.println("Ceiling entry for 5: " + treemap.ceilingEntry(5));
	}
	public static int[] findRightInterval(Interval[] intervals) {
		int lens = intervals.length;
        int[] res = new int[lens];
        TreeMap<Integer,Integer> map  = new TreeMap<Integer,Integer>();
        for (int i = 0; i < lens; i++) {
			map.put(intervals[i].start,i);
		}
        for (int i = 0; i < lens; i++) {
        	Map.Entry<Integer,Integer> entry = map.ceilingEntry(intervals[i].end);
        	res[i] = entry!=null?entry.getValue():-1;
		}
        return res;
    }
}
