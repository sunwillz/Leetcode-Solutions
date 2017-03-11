package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program132 {

	public static void main(String[] args) {
		System.out.println(minCut("aababa"));
	}
	public static int minCut(String s) {
		int len =s.length();
		int[] dp = new int[len+1];
		boolean[][] isPalindrome = new boolean[len][len];
		for (int i = 0; i < len; i++) {//dp数组初始化
			dp[i] = len-i;
		}
		for(int i =len-1;i>=0;i--){
			for(int j=i;j<len;j++){
				if((j-i<2 && s.charAt(i)==s.charAt(j))||(isPalindrome[i+1][j-1] && s.charAt(i)==s.charAt(j))){
					isPalindrome[i][j]=true;
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0]-1;
    }
	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(result,new ArrayList<String>(),s,0);
        return result;
    }
	private static void dfs(List<List<String>> result, ArrayList<String> tempList, String s, int start) {
		if(start>=s.length()){
			result.add(new ArrayList<String>(tempList));
			return ;
		}
		for (int i = start; i < s.length(); i++) {
			String subs = s.substring(start, i+1);
			if(isPalindrome(s,start,i)){
				tempList.add(subs);
				dfs(result,tempList,s,i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	/**
	 * 判断一个字符串是否是回文字符串
	 * @param substring
	 * @return
	 */
	private static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
