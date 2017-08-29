package leetcode;

public class Program462 {

	public static void main(String[] args) {

	}
	public int minMovies(int[] nums){
		int ans =0 ;
		int i=0,j=nums.length-1;
		while(i<j){
			ans +=nums[j]-nums[i];
			i++;
			j--;
		}
		return ans;
	}
}
