package leetcode;

public class Program476 {

	public static void main(String[] args) {
		System.out.println(~5);
		System.out.println(5<<1);
	}
	public static int findComplement(int num) {
		return ~num + (Integer.highestOneBit(num) << 1);
    }

}
