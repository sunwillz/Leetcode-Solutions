package leetcode;

import java.util.Arrays;

/**
 * @author sunyangwei
 *	鸡尾酒排序
 */
public class CooktailSort {

	public static void main(String[] args) {
		int[] nums={2,3,4,1,6,5};
		cooktail_sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static void cooktail_sort(int[] nums){
		boolean swapped=false;
		do{
			for (int i = 0; i < nums.length-1; i++) {
				if(nums[i]>nums[i+1]){
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
					swapped=true;
				}
			}
			swapped=false;
			for (int i = nums.length-1; i >0; i--) {
				if(nums[i]<nums[i-1]){
					int temp = nums[i];
					nums[i] = nums[i-1];
					nums[i-1] = temp;
					swapped=true;
				}
				swapped=false;
			}
		}while(swapped);
	}

}
