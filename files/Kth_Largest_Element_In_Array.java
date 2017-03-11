package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Kth_Largest_Element_In_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] arr={-1,-1,-2,-2};
		int k =2;
		System.out.println(findKthLargest(arr, k));*/
		System.out.println(getFactorial(13));
		System.out.println(trailingZeroes(13));
	}
	public static int trailingZeroes(int n) {
		int res = 0;  
        while(n!=0)  
        {  
            res += n/5;  
            n /= 5;  
        }  
        return res; 
    }
	public static int getFactorial(int n) {
		if(n==0||n==1) return 1;
		return n*getFactorial(n-1);
	}
	public static int findKthLargest1(int[] nums,int k){
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int size = set.size();
		int p=0;
		for (Integer ite : set) {
			System.out.println(ite);
			if(p==size-k) return ite;
			p++;
		}
		return 0;
	}
	public static int findKthLargest(int[] nums,int k){
		Arrays.sort(nums);
		return nums[nums.length-k]; 
	}

}
