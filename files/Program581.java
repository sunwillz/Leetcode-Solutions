package leetcode;

import java.util.Arrays;

public class Program581 {
	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[]{1,2,3,4,5}));
	}
    public static int findUnsortedSubarray(int[] nums) {
    		if(nums.length==1) return 0;
        int ans = nums.length;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);
        int i = 0,j=nums.length-1;
        while(i<j&&(copy[i]==nums[i]||copy[j]==nums[j])) {
        		if(copy[i]==nums[i]){
        			i++;
        			ans--;
        		}
        		if(copy[j]==nums[j]){
        			j--;
        			ans--;
        		}
        		if(i==j) {
        			ans--;
        			break;
        		}
        }
        return ans;
    }
}
