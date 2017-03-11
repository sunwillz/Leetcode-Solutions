package leetcode;

public class Program334 {

	public static void main(String[] args) {
		int[] nums={1,1,-2,6};
		System.out.println(increasingTriplet(nums));
	}
	public static boolean increasingTriplet(int[] nums) {
      
		int min = Integer.MAX_VALUE;
		int secmin = Integer.MAX_VALUE;
		for (int i : nums) {
			if(i<=min)
				min = i;
			else if(i<secmin)
				secmin = i;
			else if (i>secmin)
				return true;
				
		}
		return false;  
    }

}
