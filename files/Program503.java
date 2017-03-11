package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Program503 {

	public static void main(String[] args) {
	
		System.out.println(Arrays.toString(nextGreaterElementds(new int[]{100,1,11,1,120,111,123,1,-1,-100})));
	}
	public static int[] nextGreaterElementds(int[] nums){
		if(nums.length==0 || nums==null) return new int[]{};
		int len = nums.length;
		int[] new_nums = new int[2*len];
		for (int i = 0; i < len; i++) {
			new_nums[i] = nums[i];
			new_nums[i+len] = nums[i];
		}
		Stack<Integer> stack = new Stack<Integer>();
		int[] ret = new int[2*len];
		Arrays.fill(ret, -1);
		Stack<Integer> idx = new Stack<Integer>();
		for (int i = 0;i<new_nums.length;i++) {
			while(!stack.isEmpty()&&!idx.isEmpty()&& stack.peek()<new_nums[i]){
				ret[idx.pop()] = new_nums[i]; 
				stack.pop();
			}
			stack.push(new_nums[i]);
			idx.push(i);
		}
		return Arrays.copyOf(ret, len);
	}
}
