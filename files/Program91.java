package leetcode;

public class Program91 {

	public static void main(String[] args) {
		System.out.println(numDecodings("122"));
	}
	public static int numDecodings(String s) {
        int len = s.length();
        if(len==0)
        	return 0;
        if(s.charAt(0)=='0') return 0;
        if(len<2) return len;
        int[] dp = new int[len];
        dp[0] =1;
        if(s.charAt(0)!='0'&& s.charAt(1)!='0' && Integer.valueOf(s.substring(0, 2))<=26) dp[1] = 2;
        else if(s.charAt(1)=='0' && s.charAt(0)!='1' && s.charAt(0)!='2')dp[1] =0;
        else dp[1] = 1;
        for(int i =2;i<len;i++){
        	int temp = Integer.valueOf(s.substring(i-1,i+1));
        	if(s.charAt(i)!='0'){
	        	if(temp<10 || temp==20)
	        		dp[i] = dp[i-1];
	        	else if(temp<=26)
	        		dp[i] = dp[i-1]+dp[i-2];
	        	else
	        		dp[i] = dp[i-1];
        	}
        	else{
        		if(temp<=26 && temp!=0)
        			dp[i] = dp[i-2];
        		else
        			dp[i]=0;
        	}
        }
		return dp[len-1];
    }

}
