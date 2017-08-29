package leetcode;

public class Program521 {
    public int findLUSlength(String a, String b) {
    	if(a.equals(b)) return -1;
    	else if(a.length()<b.length()){
    		return b.length();
    	}else return a.length();
    }
}
