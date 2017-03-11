package leetcode;

public class Program494 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		System.out.println(findTargetSumWays(nums, 3));
	}
	/**DP算法
	 * @param nums
	 * @param S
	 * @return
	 */
	public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
			sum+=n;
		}
        return sum<S || (sum+S)%2>0 ? 0:findSubSet(nums,(sum+S)>>>1);
    }
	public static int findSubSet(int[] nums, int s) {
		int[] dp = new int[s+1];
		dp[0] = 1;//和为0只有一种
		for (int n : nums) {
			for (int i = s; i >= n; i--) {
				dp[i] += dp[i-n];
			}
		}
		return dp[s];
	}
	
	
	/**
	 * DPS算法
	 */
	/*public static int ret = 0;
	public static int findTargetSumWays(int[] nums, int S) {
		//if(nums == null || nums.length == 0) return ret;
        helper(nums,0,0,S);
        return ret;
    }
	public static void helper(int[] nums,int index,int sum,int target){
		if(index == nums.length){
			if(sum==target )
			ret++;
			return ;
		}
		helper(nums,index+1,sum+nums[index],target);
		helper(nums,index+1,sum-nums[index],target);
	}*/

}
