package leetcode;
/**
 * 
 * @author sunwill
 *	求一个数组中有多少个连续子序列是等差数列
 */
public class Program413 {

	public static void main(String[] args) {
		int[] A=new int[]{1,2,3,4,5};
		System.out.println(numberOfArithmeticSlices(A));
	}
    public static int numberOfArithmeticSlices(int[] A) {
    		int ans = 0;
    		if(A.length<3) return 0;
    		for (int i = 0; i < A.length-2; i++) {
    			int sub = A[i+1]-A[i];
    			for (int j = i+2; j < A.length; j++) {
    				if(A[j]-A[j-1]==sub && j-i>=2){
    					ans++;
    					continue;
    				}
    				else break;
			}
		}
    		return ans;
    }
    public int numberOfArithmeticSlices1(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
