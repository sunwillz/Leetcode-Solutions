package leetcode;

public class Program214 {

	public static void main(String[] args) {
		String str = "babcd";
		System.out.println(shortestPalindrome(str));
	}
	public static String shortestPalindrome(String s){
		int j = 0;
	    for (int i = s.length() - 1; i >= 0; i--) {
	        if (s.charAt(i) == s.charAt(j)) { j += 1; }
	    }
	    if (j == s.length()) { return s; }
	    String suffix = s.substring(j);
	    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
		
		/*String str = longestPalindrome(s);
		StringBuilder sb = new StringBuilder(s.substring(str.length()));
		sb.reverse().append(s);
		return sb.toString();*/
	}
	
	static String res;
	static int len=0;
	public static String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
			helper(s,i,i);
			helper(s,i,i+1);
		}
		return res;
    }
	private static void helper(String s, int i, int j) {
		if(i<0 || j>=s.length()) return ;
		if(s.charAt(i)!=s.charAt(j)) return ;
		
		helper(s,i-1,j+1);
		
		if(j-i+1>len){
			res = s.substring(i,j+1);
			len = res.length();
		}
		
	}

}
