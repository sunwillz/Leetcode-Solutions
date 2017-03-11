package leetcode;

import java.util.Arrays;

public class Program16 {

	public static void main(String[] args) {
		int[] nums= {1,1,1,0};
		System.out.println(threeSumClosest(nums, -100));
	}
	public static int threeSumClosest(int[] nums, int target) {
        int ret= 0;
        if(nums==null||nums.length<3) return ret;
        Arrays.sort(nums);
        int len = nums.length;
        int cloest = Integer.MAX_VALUE;
        for (int i = 0; i < len-2; i++) {
			if(i>0&&nums[i]==nums[i-1]) continue;
			int l = i+1,r=len-1;
			while(l<r){
				int sum = nums[l]+nums[r]+nums[i];
				if(sum<target){
					if(target-sum<cloest){
						cloest = target-sum;
						ret = sum;
					}
					l++;
				}else if(sum>target){
					if(sum-target<cloest){
						cloest = sum-target;
						ret = sum;
					}
					r--;
				}else{
					return  target;
				}
			}
		}
        return ret;
    }
}
