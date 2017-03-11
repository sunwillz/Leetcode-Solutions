package leetcode;

public class Program287 {

	public static void main(String[] args) {
		int[] arr={1,3,2,3,3};
		System.out.println(findDuplicate(arr));

	}
	public static int findDuplicate(int[] nums){
		int i = 0;
		while(i<nums.length){
			if(nums[i]==i+1) i++;
			else if(nums[nums[i]-1]!=nums[i])swap(nums,i,nums[i]-1);
			else i++;
		}
		for (int j = 0; j < nums.length; j++) {
			if(nums[j] == nums[nums[j]-1] && nums[j]!=j+1) return nums[j];
		}
		return 0;
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

}
