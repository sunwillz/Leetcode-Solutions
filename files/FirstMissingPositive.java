package leetcode;


public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int firstMissingPositive(int[] nums){
		for(int i=0;i<nums.length;i++){  
            while(nums[i]!=i+1){  
                if(nums[i]<=0 ||nums[i]>=nums.length|| nums[i]==nums[nums[i]-1]) break;  
                
                int temp =nums[i];  
                nums[i] = nums[nums[i]-1];  
                nums[temp-1] = temp;
            }  
              
        }  
        for(int i=0;i<nums.length;i++){  
            if(nums[i]!=i+1)  
                return i+1;  
        }  
        return nums.length+1;
	}

}
