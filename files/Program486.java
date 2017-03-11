package leetcode;

public class Program486 {

	public static void main(String[] args) {
		int[] nums = {2,4,55,6,8};
		System.out.println(PredictTheWinner(nums));
	}
	public static boolean PredictTheWinner(int[] nums){
		if(nums.length==1) return true;
		return helper(nums,0,0,0,nums.length-1,1);
	}
	public static boolean helper(int[] nums, int sum1, int sum2,int start,int end,int p) {
		if(end-start==1){
			if(p!=1){	
				if(sum2+nums[start]>sum1+nums[end] || sum2+nums[end]>sum1+nums[start])
					return false;
				else
					return true;
			}else{
				if(sum1+nums[start]>=sum2+nums[end] || sum1+nums[end]>=sum2+nums[start])
					return true;
				else 
					return false;
			}
		}
		if(p==1)
			return helper(nums,sum1+nums[start],sum2,start+1,end,3-p)&&helper(nums,sum1+nums[end],sum2,start,end-1,3-p);
		else
			return helper(nums,sum1,sum2+nums[start],start+1,end,3-p)&&helper(nums,sum1,sum2+nums[end],start,end-1,3-p);
	}

}
