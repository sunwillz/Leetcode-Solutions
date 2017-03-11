package leetcode;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={5,3,6,7,2,1,8,9,10,0,4};
		System.out.println(missingNumber(arr));
	}
	public static int missingNumber(int[] nums) {
        int res = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i) {
				res=i;
				break;
			}
		}
		return res<nums.length?res:nums.length+1;
    }
}
