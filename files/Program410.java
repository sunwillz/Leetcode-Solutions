package leetcode;

public class Program410 {

	public static void main(String[] args) {
		System.out.println(splitArray(new int[]{7,2,5,10,8},3));
	}
	public static int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
			max = Math.max(max, num);
			sum+=num;
		}
        if(m==1) return (int)sum;
        long start = max,end = sum;
        while(start<=end){
        	long mid = (start+end)/2;
        	if(valid(nums,mid,m)){
        		end =mid-1;
        	}else{
        		start = mid+1;
        	}
        }
        return (int)start;
    }
	private static boolean valid(int[] nums, long ret, int m) {
		long tempSum = 0;
		int count = 1;
		for (int num : nums) {
			tempSum+=num;
			if(tempSum>ret){
				tempSum=num;
				count++;
				if(count>m)
					return false;
			}
		}
		return true;
	}

}
