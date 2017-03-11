package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

	public static void main(String[] args) {
		int[] nums={1,2,3,4,8};
		System.out.println(largestDivisibleSubset(nums).toString());
	}
	public static List<Integer> largestDivisibleSubset(int[] nums) {
	    List<Integer> ls = new ArrayList<Integer>();
	    if(nums.length==0 || nums==null) return ls;
	    int len = nums.length;
	    Arrays.sort(nums);
	    int[] dp = new int[len];
	    int[] preIndex = new int[len];
	    int maxsize=0;
	    int maxIndex=0;
	    for (int i = 0; i < len; i++) {
			for (int j = i; j >= 0; j--) {
				if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
					dp[i] = dp[j]+1;
					preIndex[i] = j;
					if(maxsize<dp[i]){
						maxsize=dp[i];
						maxIndex=i;		
					}
				}
			}
		}
	    for (int i = 0; i < maxsize; i++) {
			ls.add(nums[maxIndex]);
			maxIndex=preIndex[maxIndex];
		}
		return ls;
	}
}
                   