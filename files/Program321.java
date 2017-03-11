package leetcode;

import java.util.Arrays;

public class Program321 {

	public static void main(String[] args) {
		int[] nums1={6,7};
		int[] nums2={6,0,4};
		System.out.println(Arrays.toString(merge(nums1,nums2,5)));
	}
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i=Math.max(0, k-len2); i<=k && i<=len1; i++) {
        	System.out.println(i);
			int[] temp = merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
			if(maxnum(temp,res))
				res = temp;
		}
        return res;
    }
	
	/**
	 * a>=b return true,else return false
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean maxnum(int[] a, int[] b) {
		if(a.length>b.length) return true;
		if(a.length<b.length) return false;
		int i =0;
		while(i<a.length){
			if(a[i]==b[i])
				i++;
			else if(a[i]>b[i])
				return true;
			else return false;
		}
		return true;
	}
	/**
	 * 合并两个数组
	 * @param k 
	 * @param array a
	 * @param array b
	 * @return
	 */
	private static int[] merge(int[] a, int[] b, int k) {
		int[] res = new int[k]; 
		int len_a = a.length;
		int len_b = b.length;
		if(a.length == 0) return b;
		if(b.length == 0) return a;
		int cur = 0,i=0,j=0;
		while(i < len_a && j < len_b){
			if(isgreater(a, i, b, j))
				res[cur++] = a[i++];
			else 
				res[cur++] = b[j++];
		}
		while( i < len_a )
			res[cur++] = a[i++];
		while( j < len_b )
			res[cur++] = b[j++];
			
		return res;
	}
	private static boolean isgreater(int[] a, int i, int[] b, int j) {
		int len1 = a.length, len2 = b.length;
		while (i < len1 && j < len2 && a[i] == b[j]) {
			i++;
			j++;
		}
		if (i == len1)
			return false;
		if (j == len2)
			return true;
		return a[i] > b[j];
	}
	/**
	 * 从数组nums中找出k个数，使得这k个元素按原来的相对顺序组成的数最大
	 * @param arr
	 * @param i
	 * @return array
	 */
	private static int[] maxArray(int[] arr, int k) {
		int[] res= new int[k];
		int len = arr.length;
		if( k==0 ) return res;
		int j =0;
		for (int i = 0; i < len; i++) {
			while (j > 0 && len - i - 1 >= k - j && res[j - 1] < arr[i]) { 
				j--;
			}
			if (j < k) {
				res[j] = arr[i];
				j++;
			}
		}
		return res;
	}

}
