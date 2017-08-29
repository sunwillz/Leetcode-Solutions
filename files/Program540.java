package leetcode;

public class Program540 {
	public static void main(String[] args) {
		System.out.println(singleNonDuplicate(new int[]{3,4,4}));
	}
    public static int singleNonDuplicate(int[] nums) {
    		if(nums.length==1) return nums[0];
        for (int i = 0; i < nums.length; i+=2) {
        		if(i==nums.length-1) return nums[nums.length-1];
			if(nums[i]!=nums[i+1]) return nums[i];
		}
        return 0;
    }
    public int singleNonDuplicate1(int[] nums){
    		//binary search
    		int n = nums.length,lo=0,hi = n/2;
    		while(lo<hi){
    			int m = (lo+hi)/2;
    			if(nums[2*m]!=nums[2*m+1])hi = m;
    			else lo = m+1;
    		}
    		return nums[2*lo];
    }
}
