package leetcode;

import java.util.Stack;

public class Program150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tokens[]={"0","3","/"};
		System.out.println(evalRPN(tokens));
	}
	public static int evalRPN(String[] tokens){
		Stack<Integer> st = new Stack<Integer>();
		for (String s:tokens) {
			if(s.equals("+"))
			{
				st.push(st.pop()+st.pop());
			}
			else if(s.equals("-"))
			{
				int a =st.pop();
				int b = st.pop();
				st.push(b-a);
			}
			else if(s.equals("*"))
			{
				st.push(st.pop()*st.pop());
			}
			else if(s.equals("/"))
			{
				int a = st.pop();
				int b = st.pop();
				st.push(b/a);
			}
			else{
				st.push(Integer.parseInt(s));
			}
		}
		return st.pop();
	}

}
