package leetcode;

public class Prorgam643 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMaxAverage(new int[]{5}, 1));
	}
	/** Time Limit Exceeded
	 * 子数组的最大平均值
	 * @param nums
	 * @param k
	 * @return
	 */
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-k+1; i++) {
        		double sum = 0;
			for (int j = 0; j < k; j++) {
				sum += nums[i+j];
			}
			maxAvg = Math.max(maxAvg, sum/k);
		}
    	return maxAvg;
    }
    public static double findMaxAverage2(int[] nums, int k) {
    		double sum = 0;
    		for (int i = 0; i < k; i++) {
				sum+=nums[i];
			}
    		double maxSum = 0;
    		for (int i = k; i < nums.length; i++) {
				sum +=nums[i]-nums[i-k];
				maxSum = Math.max(maxSum, sum);
			}
    		return maxSum/k;
    }
}
