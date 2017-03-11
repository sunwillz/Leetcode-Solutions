package leetcode;

public class Program41 {

	public static void main(String[] args) {
		int[] arr = {1,1,1};
		System.out.println(firstMissingPositive(arr));
	}
	public static int firstMissingPositive(int[] nums){
		int i = 0;
		while(i<nums.length){
			if(nums[i]==i+1||nums[i]<=0||nums[i]>nums.length) i++;
			else if(nums[nums[i]-1]!=nums[i])swap(nums,i,nums[i]-1);
			else i++;
		}
		i = 0;
		while(i<nums.length&&nums[i]==i+1)i++;
		return i+1;
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

}
