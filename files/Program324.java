package leetcode;

import java.util.Arrays;

public class Program324 {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 5, 1, 1, 6, 4};
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
    public static void wiggleSort(int[] nums) {
        int[] arr = new int[nums.length];
        
        System.arraycopy(nums,0, arr, 0, nums.length);
        Arrays.sort(arr);
        int j = arr.length-1;
        for (int i = 1; i < nums.length; i+=2) {
			nums[i] = arr[j--];
		}
        for (int i = 0; i < nums.length; i+=2) {
			nums[i] = arr[j--];
		}
        
    }
}
