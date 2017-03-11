package leetcode;

import java.util.Stack;

public class CountingBits {

	public static void main(String[] args) {

		
		System.out.println(isValid("]}"));
	}
	public static String multiply(String num1,String num2){
		
		return "";
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(' || s.charAt(i)=='{'|| s.charAt(i)=='[') stack.push(s.charAt(i));
			else if(s.charAt(i)==')'){
				if(stack.size()>0&&stack.peek()=='(') stack.pop();
				else return false;
			}else if(s.charAt(i)=='}'){
				if(stack.size()>0&&stack.peek()=='{') stack.pop();
				else return false;
			}else{
				if(stack.size()>0 &&stack.peek()=='[') stack.pop();
				else return false;
			}
		}
		if(stack.size()!=0) return false;
		return true;
    }
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
			int temp= i;
			int c=0;
			String s = Integer.toBinaryString(temp);
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)=='1') c++;
			}
			result[i]=c;
		}
        
        return result;
    }
    
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= (m-n); i++) {
			int j;
        	for ( j = 0; j < n; j++) {
				if(haystack.charAt(i+j)!=needle.charAt(j)) break;
			}
        	if(j==n) return i;
		}
        return -1;
    }
}
