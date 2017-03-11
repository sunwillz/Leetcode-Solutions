package leetcode;

/**
 * @author sun
 *二维动态规划：判断一个字符串s3能否由两个字符串交叉排列组成
 */
public class InterleavingString {

	public static void main(String[] args) {
		String str1="aabcc";
		String str2="dbbca";
		String s3="aadbbcbcac";
		
		System.out.println(isInterleave(str1, str2, s3));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for (int i = 0; i < s1.length(); i++) 
        	dp[i+1][0]=dp[i][0]&& s1.charAt(i)==s3.charAt(i);
        for (int i = 0; i < s2.length(); i++) 
			dp[0][i+1]=dp[0][i]&& s2.charAt(i)==s3.charAt(i);
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				dp[i+1][j+1]=(dp[i][j+1] && s1.charAt(i)==s3.charAt(i+j+1))||
						(dp[i+1][j] && s2.charAt(j)==s3.charAt(i+j+1));
			}
		}
        return dp[s1.length()][s2.length()];
        
    }  
    }

