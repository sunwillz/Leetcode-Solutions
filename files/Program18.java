package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program18 {

	public static void main(String[] args) {
		int[] nums={0,0,0,0,0};
		System.out.println(fourSum(nums, 0).toString());
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<4) return ret;
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < len-3; i++) {
			int tp = target-nums[i];
			for (int k = i+1; k < len-2; k++) {
//				if(k>0 && nums[k]==nums[k-1]) continue;
//				else{
					int l = k+1,r = len-1;
					while(l<r){
						if(nums[l]+nums[r]+nums[k]==tp){
							set.add(Arrays.asList(nums[i],nums[k],nums[l],nums[r]));
							while(l<r && nums[l]==nums[l+1]) l++;
							while(l<r && nums[r]==nums[r-1]) r--;
							l++;
							r--;
						}else if(nums[l]+nums[r]+nums[k]<tp){
							l++;
						}else{
							r--;
						}
					}
				}
//			}
		}
        ret.addAll(set);
        return ret;
    }

}
