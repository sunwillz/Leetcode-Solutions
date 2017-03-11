package leetcode;

public class Program35 {

	public static void main(String[] args) {
		int[] nums={1,3,5,6};
		System.out.println(searchInsert(nums, 7));
	}
	public static int searchInsert(int[] nums,int target){
		int i =0;
		while(nums[i]<target){
			i++;
			if(i==nums.length)
				break;
		}
		
		return i;
	}

}
