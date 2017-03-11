package leetcode;

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		int[] arr={2,3,1,1,4};
		System.out.println(jump(arr));
	}
	public static boolean canJump1(int[] nums){
		int len = nums.length;
		boolean[] flag = new boolean[len];
		for (int i = 0; i < flag.length; i++) {
			flag[i]=false;
		}
		flag[0]=true;
		for (int i = 0; i < nums.length; i++) {
			if(flag[i]){
				for (int j = 1; j <= nums[i] && (i+j)<nums.length; j++) {
					flag[i+j]=true;
				}
			}
		}
		return flag[len-1];
	}
	public static boolean canJump(int[] nums){
		int len = nums.length;
		if(nums[0]>=len-1) return true;
		int[] canWalkLength=new int[len];
		canWalkLength[0]=nums[0];
		for (int i = 1; i < nums.length; i++) {
			canWalkLength[i]=Math.max(canWalkLength[i-1], nums[i-1])-1;
			if(canWalkLength[i]<0) return false;
		}
		System.out.println(Arrays.toString(canWalkLength));
		return canWalkLength[len-1]>=0;
	}
	public static int jump(int[] nums) {
		int ret=0;
		int last = 0;
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if(i>cur) {
				return -1;
			}
			if(i>last){
				ret++;
				last=cur;
			}
			cur =Math.max(cur, i+nums[i]);
		}
        return ret;
    }
}
