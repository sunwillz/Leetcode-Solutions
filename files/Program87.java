package leetcode;

public class Program87 {
    public boolean isScramble(String s1, String s2) {
    		if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        int[] c = new int[26];
        for (int i = 0; i < s1.length(); i++) {
			c[s1.charAt(i)-'a']++;
			c[s2.charAt(i)-'a']--;
		}
        for (int i = 0; i < c.length; i++) {
			if(c[i]!=0) return false;
		}
        for (int i = 1; i < s1.length(); i++) {
			if(isScramble(s1.substring(0,i), s2.substring(0,i))&&isScramble(s1.substring(i), s2.substring(i))) return true;
			if(isScramble(s1.substring(i), s2.substring(0,s1.length()-i))&&isScramble(s1.substring(0,i), s2.substring(s1.length()-i))) return true;
		}
        return false;
    }
}
