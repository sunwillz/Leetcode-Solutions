package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Program496 {

	public static void main(String[] args) {
		

	}
	public static int[] nextGreaterElement(int[] findNums,int[] nums){
		Map<Integer,Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			while(!stack.isEmpty() && stack.peek()<num)
				map.put(stack.pop(), num);
			stack.push(num);
		}
		for (int i = 0; i < findNums.length; i++) {
			if(map.containsKey(findNums[i]))
				findNums[i] = map.get(findNums[i]);
			else
				findNums[i] = -1;
		}
		return findNums;
	}

}
