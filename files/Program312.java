package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program312 {

	static int result;
	public static void main(String[] args) {
		int[] nums ={1,5,};
		System.out.println(maxCoins(nums));
	}
	public static int maxCoins(int[] nums){
		int len = nums.length;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			list.add(nums[i]);
		}
		helper(list);
		return result;
	}
	private static void helper(List<Integer> list) {
		if(list.size()<2){
			result = list.size()==0?0:list.get(0);
			return;
		}
		if(list.size()==2) {
			int a =list.get(0);
			int b = list.get(1);
			result +=a*b+(a>b?a:b);
			return ;
		}
		int min = Integer.MAX_VALUE;
		int left = 1,right = 1;
		for (int i = 1; i < list.size()-1; i++) {
			if(list.get(i)<min){
				min = list.get(i);
				left =list.get(i-1);
				right =list.get(i+1);
			}
		}
		result += left*min*right;
		list.remove(list.indexOf(min));
		helper(list);
	}
	public static int maxCoins1(int[] nums) {
        int len = nums.length;
		int result = 0;
        
        int[] arr = new int[len-2];//辅助数组，arr[i]表示除开第一个和最后一个元素，第i+1小的数的下标 
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
    		list.add(nums[i]);
        }
        int[] newarr = new int[len-2]; 
        for (int i = 1; i < len-1; i++) {
			newarr[i-1] = nums[i];
        }
        Arrays.sort(newarr);
        for (int i = 0; i <newarr.length; i++) {
			arr[i] = list.indexOf(newarr[i]);
		}
        System.out.println(Arrays.toString(arr));
        
        for (int i = 0; i < len-2; i++) {
        	int index = arr[i];
			result+=list.get(index-1)*list.get(index)*list.get(index+1);
			list.remove(index);
			
		}
        //处理数组端点两个数
        result +=nums[0]*nums[len-1]+(nums[0]>nums[len-1]?nums[0]:nums[len-1]);
        
        return result;
        		
    }

}
