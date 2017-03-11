package leetcode;

import java.util.Arrays;

public class Program274 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 0, 6, 1, 5};
		System.out.println(hIndex1(arr));
	}
	public static int hIndex(int[] citations){
		if(citations==null || citations.length==0) return 0;
		//Arrays.sort(citations);
		int res = 0;
		int len =  citations.length;
		for (int i = 1; i <= len; i++) {
			int temp = i;//某篇论文被引用次数
			int sum = 0;//论文被引用次数大于等于temp的篇数
			for (int j = 0; j < len; j++) {
				if(citations[j]>=temp) sum++;
				if(temp==sum)
					res = Math.max(res, sum);
			}
			
			
		}
		return res;
	}
	//输入数组按升序排列,时间复杂度为O(logn)
	public static int hIndex1(int[] citations) {
       int n = citations.length;
        int l = 0,h = n;
        while(l<h){
        	int m = (l+h)/2;
        	if(citations[m]==n-m) return n-m;
        	else if(citations[m]<n-m) {
        		l=m+1;
        	}
        	else {
        		h=m;
        	}
        }
		return n-l;
		
    }
	//找两个排好序的数组的中间元素
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newarray = new int[nums1.length+nums2.length];
        int i = 0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
        	if(nums1[i]>nums2[j]){
        		newarray[k++] = nums2[j++];
        	}else{
        		newarray[k++] = nums1[i++];
        	}
        }
        while(i<nums1.length){
        	newarray[k++] = nums1[i++];
        }
        while(j<nums2.length){
        	newarray[k++] = nums2[j++];
        }
        int mid = newarray.length/2;
        return newarray.length%2==0?(newarray[mid]+newarray[mid+1])/2.0:newarray[mid];
    }

}
