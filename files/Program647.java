package leetcode;

public class Program647 {
	int count = 0;
    public int countSubstrings(String s) {
        if(s==null||s.length()==0) return 0;
    	
    		for (int i = 0; i < s.length(); i++) {
				helper(s,i,i);
				helper(s,i,i+1);
			}
    	
    		return count;
    }
	private void helper(String s, int i, int j) {
		while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
			i--;
			j++;
			count++;
		}
	}
}
