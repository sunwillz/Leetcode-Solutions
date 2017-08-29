package leetcode;

public class Program564 {
	public static void main(String[] args) {
		System.out.println(nearestPalindromic("346345668"));
	}
    public static String nearestPalindromic(String n) {
    		if(n.equals("11")||n.equals("10")) return "9";
        int len = n.length();
        StringBuilder sb = new StringBuilder();
        if(len%2==0){
        sb.append(n.substring(0,len/2));
        sb.append(new StringBuilder(n.substring(0,len/2)).reverse());
        }
        else
        {
        	sb.append(n.substring(0,len/2+1));
        	sb.append(new StringBuilder(n.substring(0,len/2)).reverse());
        }
        
        if(sb.toString().equals(n)){
        		if(sb.length()%2==0)
        		{
        			if(sb.charAt(sb.length()/2)=='0')
        			{
        				sb.setCharAt(sb.length()/2, '1');
        				sb.setCharAt(sb.length()/2-1, '1');
        			}
        			else
        			{
        				sb.setCharAt(sb.length()/2, (char) (sb.charAt(sb.length()/2)-1));
        				sb.setCharAt(sb.length()/2-1, (char) (sb.charAt(sb.length()/2)-1));
        			}
        		}
        		else
        		{
        			if(sb.charAt(sb.length()/2)=='0')
        				sb.setCharAt(sb.length()/2, '1');
        			else
        				sb.setCharAt(sb.length()/2, (char)(sb.charAt(sb.length()/2)-1));
        		}
        }
        return sb.toString();
    }
}
