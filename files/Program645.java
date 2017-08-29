package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Program645 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[]{2,3,4,6,3,5})));
	}
    public static int[] findErrorNums(int[] nums) {
//        int[] ret = new int[2];
//        Set<Integer> set = new HashSet<Integer>();
//        for (Integer i : nums) {
//			if(set.contains(i))ret[0]=i;
//			else set.add(i);
//		}
//        for (int i = 0; i < nums.length; i++) {
//			if(!set.contains(i+1)) ret[1] = i+1; 
//		}
//		return ret;
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);//小于0说明出现了两次
            else nums[Math.abs(i) - 1] *= -1;
            System.out.println(Arrays.toString(nums));
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i+1;//大于0说明没有出现，这个算法都点牛逼
        }
        return res;
    }
}
