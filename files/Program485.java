package leetcode;

public class Program485 {

	public static void main(String[] args) {
		int[] nums = {1,1,0,1,0,1,1,1,1,0};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
	public static int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==1){
				cnt++;
			}else{
				cnt=0;
			}
			if(ret<cnt){
				ret=cnt;
			}
		}
        return ret;
    }

}
