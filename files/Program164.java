package leetcode;

import java.util.Arrays;

public class Program164 {

	public static void main(String[] args) {
		

	}
	public static int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int dis = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
			dis=Math.max(dis, nums[i+1]-nums[i]);
		}
        return dis;
    }

}
