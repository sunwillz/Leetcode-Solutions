package leetcode;

public class Program6 {
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
    public static String convert(String s, int numRows) {
    		char[] c = s.toCharArray();
        StringBuilder[] sb  = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}
        
        int i =0;
        while(i<s.length()){
        		for (int j = 0; j < numRows && i<s.length(); j++) {
					sb[j].append(c[i++]);
				}
        		for (int j = numRows-2; j>=1 && i<s.length(); j--) {
					sb[j].append(c[i++]);
				}
        }
        for (int j = 1; j < sb.length; j++) {
			sb[0].append(sb[j]);
		}
        return sb[0].toString();
    }
}
