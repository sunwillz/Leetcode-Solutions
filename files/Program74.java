package leetcode;

public class Program74 {

	public static void main(String[] args) {
		System.out.println(search(new int[]{}, 8));
	}
	/**
	 * 
	 * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
	 * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
	 * @param matrix
	 * @param target
	 * @return
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
	    	int row_num = matrix.length;
	    	int col_num = matrix[0].length;
	    	
	    	int begin = 0, end = row_num * col_num - 1;
	    	
	    	while(begin <= end){
	    		int mid = (begin + end) / 2;
	    		int mid_value = matrix[mid/col_num][mid%col_num];
	    		
	    		if( mid_value == target){
	    			return true;
	    		
	    		}else if(mid_value < target){
	    			//Should move a bit further, otherwise dead loop.
	    			begin = mid+1;
	    		}else{
	    			end = mid-1;
	    		}
	    	}
	    	
	    	return false;
    }
    public static boolean search(int[] nums,int target){
    		int i =0,j = nums.length-1;
		while(i<=j){
			int mid = (i+j)/2;
			if(nums[mid]==target) return true;
			else if(target>nums[mid]) {
				i=mid+1;
			}else{
				j=mid-1;
			}
		}
		return false;
    }
}
