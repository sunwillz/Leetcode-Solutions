package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum extends Thread{
	
	public static void main(String[] args){
	 
	     int[] arr= {1, 0, -1, 0, -2, 2};   
	 
	    System.out.println(fourSum(arr,0).toString()); 
} 
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ls= new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums);//对数组排序
        int len=nums.length;
        if((nums[len-1]+nums[len-2]+nums[len-3]+nums[len-4]<target) || (nums[0]+nums[1]+nums[2]+nums[3]>target)) return ls;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i+1; j < nums.length; j++) {
        		if(!twoSum(nums,target-nums[i]-nums[j]).isEmpty()){
        			for (List<Integer> list : twoSum(nums,target-nums[i]-nums[j])) {
        				res.add(nums[i]);
    					res.add(nums[j]);
    					for (Integer p : list) {
    						res.add(p);
						}
    					ls.add(res);
    					res.clear();
					}
			}
        	}
		}
        return ls;
    }
	
	public static List<List<Integer>> twoSum(int[] nums, int target) {
		 List<List<Integer>> ls= new ArrayList<List<Integer>>();
	     List<Integer> res = new ArrayList<Integer>();
	     int i =0;
	     int j =nums.length-1;
	     while(i<j){
	    	 int sum = nums[i]+nums[j];
	    	 if(sum==target){
	    		 res.add(nums[i]);
	    		 res.add(nums[j]);
	    		 ls.add(res);
	    		 res.clear();
	    		 ++i;
	    		 --j;
	    	 }else if(target>sum){
	    		 ++i;
	    	 }else{
	    		 --j;
	    	 }
	     }
	    
		return ls;
	}
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		
		int leftIndex= leftSearch(nums,nums.length,target);
		int rightIndex= rightSearch(nums,nums.length,target);
		res[0] = leftIndex;
		res[1] = rightIndex;
		return res;
	 }

	public static int rightSearch(int[] nums, int n, int target) {
		int low =0,high = n-1;
		while(low<=high){
			int mid= (low+high)/2;
			if(nums[mid]>target){
				if(mid==0) return -1;
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		if(nums[high]!=target) return -1;
		return high;
	}

	public static int leftSearch(int[] nums, int n, int target) {
		int low =0,high = n-1;
		while(low<=high){
			int mid= (low+high)/2;
			//System.out.println(mid);
			if(nums[mid]<target){
				if(mid==n-1) return -1;
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		if(nums[low]!=target) return -1;
		return low;
	}  
}
