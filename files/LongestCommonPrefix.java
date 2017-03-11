package leetcode;

import java.util.Arrays;


public class LongestCommonPrefix {

	public static void main(String[] args) {
		String [] str ={"abcs","abc","abcsa"};
		System.out.println(longestCommonPrefx(str));
	}
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        //Arrays.sort(strs);//对数组排序
        String prefx = strs[0];
        for (int i = 1; i < strs.length; i++) {
			if(prefx.length()==0 || strs[i].length()==0) return "";
			int len = prefx.length()<strs.length?prefx.length():strs[i].length();
			int k;
			for (k = 0; k < len; k++) {
				if(prefx.substring(k, k+1)!=strs[i].substring(k, k+1)){
					break;
				}
			}
			prefx = prefx.substring(0,k);
		}
		return prefx;
    }
	public static String longestCommonPrefx(String[] strs){
		if (strs == null || strs.length == 0)
			return "";
		StringBuilder res = new StringBuilder();
		int index = 0;
		int len = minlen(strs);
		while (index < len) {
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].charAt(index) != strs[0].charAt(index))
					return res.toString();
			}
			res.append(strs[0].charAt(index));
			index++;
		}
		return res.toString();
	}
	 public static int minlen(String[] strs) {
		         int min = Integer.MAX_VALUE;
		         for(int i=0; i<strs.length;i++)
		             min = Math.min(min,strs[i].length());
		         return min;
     }
}
