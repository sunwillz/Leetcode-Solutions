package leetcode;

public class Program10 {

	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		System.out.println(isMatch(s,p));
	}
	public static boolean isMatch(String s, String p) {
		if(s==null ||s==null) return false;
        boolean[][] dp = new boolean[s.length()][p.length()];
        dp[0][0] = true;
		for(int j=0;j<p.length();j++){
			if(p.charAt(j)=='*'){
				if(dp[0][j-1] ||(j>1 && dp[0][j-2]))
				dp[0][j] = true;
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'){
					dp[i][j] = dp[i-1][j-1];
				}
				if(p.charAt(j)=='*'){
					if(p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1)!='.'){
						dp[i][j] = dp[i][j-2];
					}else {
						dp[i][j] = dp[i][j-1]||dp[i][j-2]||dp[i-1][j];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
    }

}
