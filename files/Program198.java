package leetcode;

public class Program198 {

	public static void main(String[] args) {
		int[] nums={0,0,0};
		System.out.println(rob1(nums));
	}
	public static int rob(int[] nums) {
        int len = nums.length;
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1]=nums[0]>nums[1]?nums[0]:nums[1];
        for (int i = 2; i <len; i++) {
			dp[i] = dp[i-1]>=(dp[i-2]+nums[i])?dp[i-1]:dp[i-2]+nums[i];
		}
        return dp[len-1];
    }
    public static int rob1(int[] nums) {
        int len = nums.length;
        
        if(nums==null || nums.length==0) return 0;
        
        if(nums.length==1) return nums[0];
        
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robsub(nums,0,len-2), robsub(nums,1,len-1));
    }
	private static int robsub(int[] nums, int start, int end) {
		int len = end-start+1;

		int[] dp = new int[len];
		
		dp[0] = nums[start];
		
		dp[1] = Math.max(nums[start], nums[start+1]); 
		
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i-2]+nums[start+i], dp[i-1]);
		}
		return dp[len-1];
	}
}