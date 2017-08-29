package leetcode;

import java.util.Arrays;

public class Program209 {
	public static void main(String[] args) {
		int arr [] =new int[]{1,3,4,5,8,9};

        Arrays.sort(arr);

       int index1 = Arrays.binarySearch(arr,6);
       System.out.println(index1);
	}
	/*
	 * 本题也可用二分查找解决
	 */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int i = 0,j = 0,sum = 0,min = Integer.MAX_VALUE;
        while(j<nums.length) 
        {
        		sum +=nums[j++];
        
        		while(sum>=s)
        		{
        			min = Math.min(min,j-i);
        			sum -=nums[i++];
        		}
        }

        return min==Integer.MAX_VALUE?0:min;
    }
}
