package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program398 {
	int[] nums;
    public Program398(int[] nums) {
        this.nums= nums;
    }
    
    public int pick(int target) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==target)idx.add(i);
		}
    		Random rand = new Random();
    		
    		return idx.get(rand.nextInt(idx.size()));
    }
}
