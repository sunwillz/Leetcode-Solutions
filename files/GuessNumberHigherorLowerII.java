package leetcode;

public class GuessNumberHigherorLowerII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverseBits(43261596));
		//System.out.println(Integer.parseInt("0101",2));
		//System.out.println(Integer.valueOf("0101",2));
		System.out.println(5>>1);
	}
	public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
			for (int j = i-1; j >0; j--) {
				int global_min = Integer.MAX_VALUE;
				for (int k = j+1; k < i; k++) {
					int local_max = k+Math.max(dp[j][k-1], dp[k+1][i]);
					global_min = Math.min(local_max, global_min);
				}
				dp[j][i] = j+1==i?j:global_min;
			}
		}
		return dp[1][n];
    }
	public static int reverseBits(int n) {
        
        return  0;
    }
}
