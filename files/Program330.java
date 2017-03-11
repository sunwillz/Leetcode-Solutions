package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program330 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 13, 43};
		System.out.println(minPatches(nums, 100));
		System.out.println(ls.toString());
	}
	static List<Long> ls;
	public static int minPatches(int[] nums,int n){
		int add = 0,i=0;
		long miss = 1;
		ls = new ArrayList<Long>();
		while(miss<=n){
			if(i<nums.length && nums[i]<=miss){
				miss+=nums[i++];
			}else{
				ls.add(miss);
				miss+=miss;
				add++;
			}
		}
		return add;
	}

}
