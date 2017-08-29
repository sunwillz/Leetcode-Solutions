package leetcode;

import java.util.Arrays;

public class Program32 {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(())"));
	}
    public static int longestValidParentheses(String s) {
    		if(s==null||s.length()<2) return 0;
    		int[] dp = new int[s.length()];
    		int max = 0;
        for (int i = 1; i < dp.length; i++) {
			if(s.charAt(i)==')')
			{
				if(s.charAt(i-1)=='(')
				{
					dp[i] = i-2>=0?dp[i-2]+2:2;
					max = Math.max(max, dp[i]);
				}
				else {
					if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='(')
					{
					dp[i] = dp[i-1]+2+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:dp[0]);
					max = Math.max(max, dp[i]);

					}
				}
			}
		}
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
