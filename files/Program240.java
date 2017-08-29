package leetcode;

public class Program240 {

	public static void main(String[] args) {

	}
    public static boolean searchMatrix(int[][] matrix, int target) {
    		if(matrix==null||matrix.length == 0) return false;
    	 	int row = matrix.length, col = matrix[0].length;
    		if(matrix!=null&&row>0&&col>0){
    			int i=0,j = col-1;
    			while(i<row&&j>=0){
    				if(matrix[i][j]==target) return true;
    				else if(matrix[i][j]<target){
    					i++;
    				}else{
    					j--;
    				}
    			}
    			
    		}
        return false;
    }
}
