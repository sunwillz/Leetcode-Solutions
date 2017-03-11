package leetcode;

import java.util.Arrays;

public class RiverHopscotch {

	public static void main(String[] args) {
		int[] arr = {2,11,14,17,21};
		
		System.out.println(river(arr,25,5,2));
//		System.out.println(query(arr,12));
	}
	public static boolean query(int[] nums,int n){
		int low = 0,high = nums.length;
		while(low<high){
			int mid = (low+high)/2;
			if(nums[mid]==n) return true;
			if(nums[mid]<14)
				low = mid+1;
			else
				high = mid-1;
		}
		if(nums[low] == n) return true;
		
		return false; 
	}
	public static int river(int[] nums,int L,int M,int N){
		int[] di = new int[nums.length+2];
		int len = di.length;
		di[0]=0;
		di[len-1] = L;
		for (int i = 1; i < di.length-1; i++) {
			di[i] = nums[i-1];
		}
		System.out.println(Arrays.toString(di));
		int ret = 0;
		if(M==N)return L;
		int left = 0,right=L;
		while(left<=right){
			int sum = 0;//删除元素次数
			int mid = (right+left)/2;
			int start = 0;
			for (int i = 1; i <= N+1; i++) {
				if(di[i]-di[start]<mid){
					sum++;
				}else{
					start=i;
				}
			}
			if(sum>M)
				right=mid-1;
			else{
				left=mid+1;
				ret = mid;
			}
			
		}
		return ret;
	}
	

}
