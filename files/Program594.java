package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program594 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
        		max = Math.max(max, i);
        		min = Math.min(min, i);
			map.put(i, map.getOrDefault(i, 0)+1);
		}
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])&&map.containsKey(nums[i]-1))
				ans = Math.max(ans, map.get(nums[i])+map.get(nums[i]-1));
			if(map.containsKey(nums[i])&&map.containsKey(nums[i]+1))
				ans = Math.max(ans, map.get(nums[i])+map.get(nums[i]+1));
		}	
        return ans;
    }
}
