package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program15 {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums).toString());
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(nums==null || nums.length<3) return ret;
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len-2; i++) {
			if(i>0 && nums[i]==nums[i-1]) continue;
			else{
				int l = i+1,r = len-1;
				while(l<r){
					if(nums[l]+nums[r]+nums[i]==0){
						ret.add(Arrays.asList(nums[i],nums[l],nums[r]));
						while(l<r && nums[l]==nums[l+1]) l++;
						while(l<r && nums[r]==nums[r-1]) r--;
						l++;
						r--;
					}else if(nums[l]+nums[r]+nums[i]<0){
						l++;
					}else{
						r--;
					}
				}
			}
		}
        return ret;
		
    }
}
