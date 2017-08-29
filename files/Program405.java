package leetcode;

public class Program405 {
	public static void main(String[] args) {
		System.out.println(toHex(-12));
	}
    public static String toHex(int num) {
    		if(num==0) return "0";
    		String ans = "" ;
    		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    		while(num!=0){
    			ans = map[(num&15)]+ans;
    			num = num>>>4;
    		}
        return ans;
    }
}
