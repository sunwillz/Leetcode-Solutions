package leetcode;

public class Program67 {

	public static void main(String[] args) {
		String a= "1101";
		String b= "101";
		System.out.println(addBinary(a, b));
	}
	public static String addBinary(String a,String b){
		String rea = new StringBuilder(a).reverse().toString();
		String reb = new StringBuilder(b).reverse().toString();
		StringBuilder result = new StringBuilder();
		boolean isCarry = false;
		int length = Math.max(rea.length(), reb.length());
		for (int i = 0; i < length; i++) {
			int x = i < rea.length() ? rea.charAt(i) - '0' : 0;
			int y = i < reb.length() ? reb.charAt(i) - '0' : 0;
			int sum = isCarry ? x + y + 1 : x + y;
			isCarry = sum > 1 ? true : false;
			if (sum % 2 == 0) {
				result.append("0");
			} else {
				result.append("1");
			}
		}
		if (isCarry) {
			result.append("1");
		}
		return result.reverse().toString();
	}
}
