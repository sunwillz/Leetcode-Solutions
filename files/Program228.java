package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Program228 {

	public static void main(String[] args) {
		int[] arr= {3,4,5,7,8,10,13};
		System.out.println(summaryRanges(arr).toString());
	}
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums==null || nums.length==0) return result;
		if(nums.length==1) {
			result.add(String.valueOf(nums[0]));
			return result;
		}
		int pre = nums[0],start = nums[0];
		String path = String.valueOf(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==pre+1){
				pre = nums[i];
				if(i==nums.length-1){
					result.add(path+"->"+String.valueOf(nums[i]));
				}
			}else{
				path += pre==start?"":"->"+String.valueOf(pre);
				result.add(path);
				path=String.valueOf(nums[i]);
				start = pre = nums[i];
				if(i==nums.length-1){
					result.add(path);
				}
			}
			
		}
		return result;
    }

}
