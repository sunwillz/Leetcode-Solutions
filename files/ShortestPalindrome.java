package leetcode;

public class ShortestPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        String str = s.toLowerCase();
        while(i<=j){
        	if(!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i)) ) {
        		i++;
        		continue;
        	}
        	if(!Character.isDigit(str.charAt(j)) && !Character.isLetter(str.charAt(j)) ) {
        		j--;
        		continue;
        	}
        	if(str.charAt(i)!=str.charAt(j)) return false;
        	else {
        		i++;
        		j--;
        	}
        }
        return true;
    }
	public static String shortestPalindrome(String s) {
        
		
		return "";
    }

}
