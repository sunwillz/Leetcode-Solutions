package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Program363 {

	public static void main(String[] args) {
		int[][] matrix = {
				{2,2,-1}
		                 };
		System.out.println(maxSumSubmatrix(matrix,0));
		System.out.println(maxSumSeq(new int[]{2,2,-1},0));
	}
	public static int maxSumSubmatrix(int[][] matrix,int k){
		int row = matrix.length;
		int col = matrix[0].length;
		int ret = Integer.MIN_VALUE;
		
		for (int i = 0; i < col; i++) {
			int[] sum=  new int[row];
			for (int j = i; j < col; j++) {
				for (int r = 0; r < row; r++) {
					sum[r] += matrix[r][j];
				}
				ret = Math.max(ret, maxSumSeq(sum,k));
			}
		}
		
		return ret;
	}
	public static int maxSumSeq(int[] nums, int k){
		int ret = Integer.MIN_VALUE;
		if(nums.length==0) return 0;
		int curSum = 0;
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		for (int i = 0; i < nums.length; i++) {
			curSum+=nums[i];
			int tempMax = Integer.MIN_VALUE;
			for (Integer s : set) {
				if(curSum-s<=k)
					tempMax = Math.max(tempMax, curSum-s);
			}
			ret = Math.max(tempMax, ret);
			set.add(curSum);
		}
		return ret;
		
	}

}
