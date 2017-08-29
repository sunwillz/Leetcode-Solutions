package leetcode;

public class Program453 {
	public static void main(String[] args){
		System.out.println(minMoves(new int[]{12,9,15}));
	}
	public static int minMoves(int[] nums){
		int minNum = Integer.MAX_VALUE;
		long sum = 0;
		for (int i : nums) {
			minNum = Math.min(minNum, i);
			sum+=i;
		}
		return (int) (sum-nums.length*minNum);
	}
}
