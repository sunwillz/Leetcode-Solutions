package leetcode;

import java.util.Arrays;
import java.util.List;

public class Program539 {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
			String time = timePoints.get(i);
			int hour = Integer.parseInt(time.substring(0, 2));
			int minute = Integer.parseInt(time.substring(3, 5));
			int m = 60*hour+minute;
			arr[i] = m;
			System.out.println(m);
		}
        Arrays.sort(arr);
        int minDif = -(arr[0]-arr[arr.length-1])==1439?1:arr[0]+1440-arr[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i]-arr[i-1];
			if(diff<minDif) minDif=diff;
		}
        
        return minDif;
    }
}
