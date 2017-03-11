package leetcode;

public class SumofTwoIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(50, 69));
	}
	public static int getSum(int a, int b) {
        if(b==0) return a;
        int c=a^b;
        int d=(a&b)<<1;
        
		return getSum(c, d);
    }

}
