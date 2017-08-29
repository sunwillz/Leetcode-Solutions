package leetcode;

public class Program63 {
	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][]{{ 0,0,0},{0,1,0},
			  {0,0,0}}));
	}
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    		int m = obstacleGrid.length,n = obstacleGrid[0].length;
        int[][] c = new int[m][n];
        for(int i = 0; i<m;i++){
        	   if(obstacleGrid[i][0]!=1) c[i][0] = 1;
        	   else break;
        }
        for(int j= 0;j<n;j++){
           if(obstacleGrid[0][j]!=1) c[0][j]=1;
           else break;
        }
        for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(obstacleGrid[i][j]==1) c[i][j]=0;
				else c[i][j] = c[i-1][j]+c[i][j-1];
			}
		}
        return c[m-1][n-1];
    }
}
