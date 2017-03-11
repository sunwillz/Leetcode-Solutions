package leetcode;


public class Program38 {

	public static void main(String[] args) {
		int n = 7;
		System.out.println(countAndSay(n));
	}
	public static String countAndSay(int n) {
        String[] result =new String[n];
        result[0] = "1";
        if(n==1) return result[n-1];
        for(int i =1;i<n;i++){
        	result[i] = count(result[i-1]);
        }
		return result[n-1];
    }
	private static String count(String str) {
		String result ="";
        if(str.length()==1) return "1"+str; 
        int cnt = 1;
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i)==str.charAt(i-1)){
				cnt++;
			}else{
				result +=String.valueOf(cnt)+str.charAt(i-1);
				cnt = 1;
			}
		}
		return result+String.valueOf(cnt)+str.charAt(str.length()-1);
	}

}
