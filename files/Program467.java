package leetcode;

public class Program467 {
    public int findSubstringInWraproundString(String p) {
       int ans = 0;
       int[] count = new int[26];
       int maxLen = 0;
       for (int i = 0; i < p.length(); i++) {
    	   		if(i>0&&(p.charAt(i)-p.charAt(i-1)==1||p.charAt(i-1)-p.charAt(i)==25)){
    	   			maxLen++;
    	   		}else
    	   			maxLen = 1;
    	   		int index = p.charAt(i)-'a';
    	   		count[index] = Math.max(count[index],maxLen);
       }
       for (int i : count) {
		ans+=i;
	}
       return ans;
    }
}
