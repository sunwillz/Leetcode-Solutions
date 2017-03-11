package leetcode;

public class Program415 {

	public static void main(String[] args) {
		String num1="123";
		String num2="44";
		System.out.println(addStrings(num1, num2));
	}
	public static String addStrings(String num1, String num2) {
		int len1=num1.length()-1;
        int len2=num2.length()-1;
        
        StringBuilder sb=new StringBuilder();
        int sum=0,carry=0;
        while(len1>=0 || len2>=0) {
            int first=len1>=0?num1.charAt(len1)-'0':0;
            int second=len2>=0?num2.charAt(len2)-'0':0;
            sum=carry+first+second;
            if(sum<=9){
                sb.insert(0,sum);
                sum=0;
                carry=0;
            } else {
                sb.insert(0,sum%10);
                sum=0;
                carry=1;
            }
            len1--;
            len2--;
        }
    if(carry==1)sb.insert(0,"1");
    return sb.toString();
    }

}
