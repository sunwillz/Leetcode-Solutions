package leetcode;


public class Program396 {

	public static void main(String[] args) {
		int[] num ={-2147483648,-2147483648};
		int max =-2147483648;
		System.out.println(maxRotateFunction(num));
	} 
	public static int maxRotateFunction(int[] A) {
		int allSum = 0;
		int len = A.length;
		int F = 0;
		for (int i = 0; i < len; i++) {
		    F += i * A[i];
		    allSum += A[i];
		}
		int max = F;
		for (int i = len - 1; i >= 1; i--) {
		    F = F + allSum - len * A[i];
		    max = Math.max(F, max);
		}
		return max;
    }
}
