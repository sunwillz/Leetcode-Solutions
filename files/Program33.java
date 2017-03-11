package leetcode;

public class Program33 {

	public static void main(String[] args) {
//		int[] nums={1,3,1,1};
//		System.out.println(search1(nums, 3));
		System.out.println();
	}
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(target==nums[mid])
				return mid;
			if(nums[mid]>=nums[start]){
				if(target>=nums[start]&&target<nums[mid]){
					end = mid-1;
				}else{
					start = mid+1;
				}
			}
			if(nums[mid]<=nums[end]){
				if(target<=nums[end]&&target>nums[mid]){
					start = mid+1;
				}else{
					end = mid-1;
				}
			}
		}
        return -1;
    }
	 public static boolean search1(int[] nums, int target) {
		 	int start = 0, end = nums.length;
	        while (start < end) {
	            int mid = (start + end) / 2;
	            if (nums[mid] == target) return true;
	            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
	                // check if target in left half
	                if (target < nums[mid] && target >= nums[start]) end = mid;
	                else start = mid + 1;
	            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
	                // check if target in right half
	                if (target > nums[mid] && target < nums[start]) start = mid + 1;
	                else end = mid;
	            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
	                start++;
	            }
	        }
	        return false;
	    }

}
