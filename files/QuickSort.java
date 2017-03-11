package leetcode;

import java.util.Arrays;


/**
 * @author sunyangwei
 * 快速排序
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] nums={34,3,53,2,23,7,14,10,0};
		quick_sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	/**
	 * @param nums
	 */
	public static void quick_sort(int[] nums){
		quicksort(nums,0,nums.length-1);
	}
	/**
	 * @param nums
	 * @param left
	 * @param right
	 */
	private static void quicksort(int[] nums, int left, int right) {
		int mid;
		if(left<right){
			mid = partition(nums,left,right);
			quicksort(nums,0,mid-1);
			quicksort(nums,mid+1,right);
		}
	}
	/**
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while(left<right){
			while(left<right && nums[right]>=pivot)
				right--;
			nums[left]=nums[right];
			while(left<right && nums[left]<pivot)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = pivot;
		return left;
	}
}
