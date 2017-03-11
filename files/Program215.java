package leetcode;


public class Program215 {

	public static void main(String[] args) {
		
		int nums[] = {3,2,1,5,6,4};
		System.out.println(findKthLargest(nums,1));
		System.out.println(findKthLargest(nums,2));
		System.out.println(findKthLargest(nums,3));
		System.out.println(findKthLargest(nums,4));
		System.out.println(findKthLargest(nums,5));
		System.out.println(findKthLargest(nums,6));
	}
	public static int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return Integer.MAX_VALUE;
        return helper(nums,0,nums.length-1,k);
    }
	private static int helper(int[] nums, int left, int right, int k) {
		int dp;
			dp = partition(nums,left,right);
			if(dp==k-1)
				return nums[dp];
			else if(dp>k-1)
				return helper(nums,left,dp-1,k);
			else
			    return	helper(nums,dp+1,right,k);

	}
	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while(left<right){
			while(left<right && nums[right]<pivot){
				right--;
			}
			if(left<right)
				nums[left] = nums[right];
			 while(left<right&& nums[left]>pivot){
				 left++;
			 }
			 if(left<right)
				 nums[right] = nums[left];
		}
		nums[left] = pivot;
		return left;
	}
	public static int partition1(int[] list,int low,int high){
		int tmp = list[low];    //数组的第一个作为中轴  
        while (low < high) {  
            while (low < high && list[high] < tmp) {  
                high--;  
            }  
            list[low] = list[high];   //比中轴小的记录移到低端  
            while (low < high && list[low] > tmp) {  
                low++;  
            }  
            list[high] = list[low];   //比中轴大的记录移到高端  
        }  
        list[low] = tmp;              //中轴记录到尾  
        return low;                   //返回中轴的位置  
	}
}
