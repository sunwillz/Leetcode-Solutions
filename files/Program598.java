package leetcode;

public class Program598 {
	
	public static void main(String[] args) {
		System.out.println(maxCount2(3, 3, new int[][]{{2,2},{3,3}}));
	}
	// Memory Limit Exceeded 
    public static int maxCount(int m, int n, int[][] ops) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < ops.length; i++) {
			int a = ops[i][0];
			int b = ops[i][1];
			for (int k = 0; k < a; k++) {
				for (int t = 0; t < b; t++) {
					mat[k][t]++;
				}
			}
			
		}
        
        int maxNum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j]>maxNum){
					maxNum = mat[i][j];
					count=1;
				}
				else if(mat[i][j]==maxNum){
					count++;
				}
			}
		}
        
        return count;
    }
    public static int maxCount2(int m, int n, int[][] ops) {
    		if(ops==null||ops.length==0) return m*n;
    		int minX = Integer.MAX_VALUE; 
    		int countX = 0;
    		int minY = Integer.MAX_VALUE;
    		int countY = 0;
    		for (int i = 0; i < ops.length; i++) {
    				if(minX>ops[i][0]){
    					minX =  ops[i][0];
    					countX = 1;
    				}else if(minX==ops[i][0]){
    					countX++;
    				}
    				
    				if(minY>ops[i][1]){
    					minY = ops[i][1];
    					countY = 1;
    				}else if(minY==ops[i][1]){
    					countY++;
    				}
			}
    		System.out.println(countX+"  "+countY);
    		return minX*minY;
    }
}
