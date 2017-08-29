package leetcode;

public class Program547 {
	public static void main(String[] args) {
	
	}
    public int findCircleNum(int[][] M) {
        int ans = 0;
        int n = M.length;
        boolean[] isvisit = new boolean[n];
        for (int i = 0; i < n; i++) {
			if(!isvisit[i]){
				helper(M,isvisit,i);
				ans++;
			}
		}
        return ans;
    }
	private void helper(int[][] M, boolean[] isvisit, int i) {
		for (int j = 0; j < M.length; j++) {
			if(M[i][j]==1&&!isvisit[j]){
				isvisit[j]=true;
				helper(M,isvisit,j);
			}
		}
	}
}
