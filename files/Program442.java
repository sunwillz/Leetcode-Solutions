package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program442 {

	public static void main(String[] args) {
		int[] arr={4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(arr).toString());
	}
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if(nums[index]>0)
				nums[index] = -nums[index];
			else{
				res.add(index+1);
			}
		}
		return res;
	}

}
