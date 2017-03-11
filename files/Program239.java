package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Program239 {

	public static void main(String[] args) {
		
		int[] nums={1,3,-1,-3,5,3,6,7};
		System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(k==0) return new int[0];  
        
        LinkedList<Integer> q = new LinkedList<Integer>();  
  
        int[] res = new int[nums.length-k+1];  
          
         for(int i=0; i<nums.length; i++) {  
            while(!q.isEmpty() && nums[i]>=nums[q.getLast()]){  
                q.removeLast();  
            }  
            q.addLast(i);  
              
            if(i-q.getFirst()+1 > k) {  
                q.removeFirst();  
            }
            if(i+1>=k) res[i-k+1] = nums[q.getFirst()];  
        }  
          
        return res;  
    }

}
