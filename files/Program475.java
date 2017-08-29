package leetcode;

import java.util.Arrays;

public class Program475 {

	public static void main(String[] args) {

	}
    public int findRadius(int[] houses, int[] heaters) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        
        for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if(index<0)
				index = -(index+1);
			
			int left = index>=1?house-heaters[index-1]:Integer.MAX_VALUE;
			int right = index<heaters.length?heaters[index]-house:Integer.MAX_VALUE;
			
			ans = Math.max(Math.min(left,right), ans);
		}
        
        return ans;
        
    }
}
