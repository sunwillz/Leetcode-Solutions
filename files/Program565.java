package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Program565 {
	public static void main(String[] args) {
		System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
	}
    public static int arrayNesting(int[] nums) {
    		int ans = 0;
    		Set<Integer> set = new HashSet<>();
    		boolean[] bool = new boolean[nums.length];
    		for (int i = 0; i < nums.length; i++) {
    			int n = nums[i];
			while(!set.contains(n)&&!bool[n])
			{
				set.add(n);
				bool[n] = true;
				n=nums[n];
			}
				ans = Math.max(ans, set.size());
				set.clear();
			}
    		return ans;
    }
}
