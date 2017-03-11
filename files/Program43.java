package leetcode;

public class Program43 {

	public static void main(String[] args) {
		String num1 = "123";
		String num2="458";
		System.out.println(multiply(num1, num2));
		System.out.println(123*458);
	}
	public static String multiply(String num1,String num2){
		int m = num1.length();
		int n = num2.length();
		int[]ind = new int[m+n];
		for (int i = m-1; i >=0; i--) {
			for (int j = n-1; j >=0; j--) {
				int tep = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				int p1 = i+j,p2 = i+j+1;
				int sum = tep+ind[p2];
				
				ind[p1] +=sum/10;
				ind[p2] = sum%10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : ind) {
			if(!(sb.length()==0&& i==0)) sb.append(i);
		}
		
		return sb.length()==0?"0":sb.toString();
	}

}
