package leetcode;

public class Program566 {

	public static void main(String[] args) {
		int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] ans = matrixReshape(nums, 2, 6);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j]+"\t");
			}
			System.out.println();
		}
	}
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rowNum = nums.length;
        int colNum = nums[0].length;
        if(rowNum*colNum!=r*c) return nums;
        int[][] ans = new int[r][c];
        int k = 0,m = 0;
        for (int i = 0; i < rowNum; i++) {
        		for (int j = 0; j < colNum; j++) {
        			if(m==c) {m=0;k++;}
        			ans[k][m] = nums[i][j];
        			m++;
        		}
		}
        return ans;
    }
}
