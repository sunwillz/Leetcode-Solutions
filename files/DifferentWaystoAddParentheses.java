package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {

	public static void main(String[] args) {
		String str="2*4-3*7";
        System.out.println(diffWaysToCompute(str).toString());
  	}
	public static List<Integer> diffWaysToCompute(String input) {  
        List<Integer> result = new ArrayList<Integer>();  
        int val = 0, index = 0;  
        while(index < input.length() && Character.isDigit(input.charAt(index))) {  
            val *= 10;  
            val += input.charAt(index++) - '0';  
        }  
        if(index == input.length()) {  
            result.add(val);  
            return result;  
        }  
        for(int i = 0; i < input.length(); i++) {  
            if(!Character.isDigit(input.charAt(i))) {  
                List<Integer> left = diffWaysToCompute(input.substring(0, i));  
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));  
                for(int j = 0; j < left.size(); j++) {  
                    for(int k = 0; k < right.size(); k++) {  
                        result.add(compute(left.get(j), right.get(k), input.charAt(i)));  
                    }  
                }  
            }  
        }  
        return result;  
    }  
   public static int compute(int a, int b, char op) {  
        switch(op) {  
            case '+': return a + b;  
            case '-': return a - b;  
            case '*': return a * b;  
            default: return 1;  
        }  
    }  
}
