package leetcode;

public class Program5 {
	//最长回文子串
	public static void main(String[] args) {
		String s="cbbd";
		System.out.println(longestPalindrome(s));
	}
	public static String longestPalindrome(String s) {
        int rs=0,re = 0;
        int max= 0;
		for (int i = 0; i < s.length(); i++) {
			if(isPalindrome(s, i-max-1, i)){
				rs = i-max-1;re =i;
				max +=2;
			}else if(isPalindrome(s, i-max, i)){
				rs = i-max;re = i;
				max +=1;
			}
		}
		return s.substring(rs,re+1);
    }
	private static boolean isPalindrome(String s, int i, int j) {
		if(i<0) return false;
		while(i<j){
			if(s.charAt(i++)!=s.charAt(j--)) return false;
		}
		return true;
	}

}
