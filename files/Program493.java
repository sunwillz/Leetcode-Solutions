package leetcode;

import java.util.Arrays;

public class Program493 {

	public static void main(String[] args) {
		int[] nums = {4,6,8,1,2,3};
		System.out.println(reversePairs(nums));
	}
    public static int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
	private static int mergeSort(int[] nums, int l, int r) {
		if(l>=r) return 0;
		int mid = (l+r)/2;
		int ans  = mergeSort(nums,l,mid)+mergeSort(nums,mid+1,r);
		for (int i = l, j = mid+1; i<=mid;i++) {
			while(j<=r&&nums[i]/2.0>nums[j]) j++;
			ans +=j-(mid+1);
		}
		merge(nums,l,mid,r);
		return ans;
	}
	private static void merge(int[] nums, int l, int mid, int r) {
		int[] temp = new int[r-l+1];
		int i = l, j =mid+1,k = 0;
		while(i<=mid&&j<=r){
			if(nums[i]>=nums[j])temp[k++] = nums[j++];
			else temp[k++] = nums[i++];
		}
		while(i<=mid) temp[k++] = nums[i++];
		while(j<=r) temp[k++] = nums[j++];
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2+l] = temp[k2];
		}
	}
}
