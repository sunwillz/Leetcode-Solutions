package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program448 {

	public static void main(String[] args) {
		int[] arr ={4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(arr).toString());
	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
        	if(nums[index]>0)
        		nums[index] = -nums[index];
		}
        System.out.println(Arrays.toString(nums));
        for (int j = 0; j < nums.length; j++) {
			if(nums[j]>0)
				res.add(j+1);
		}
        
        return res;
    }

}
