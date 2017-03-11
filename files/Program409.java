package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program409 {

	public static void main(String[] args) {
		String s = "abb";
		System.out.println(longestPalindrome(s));
	}
	public static int longestPalindrome(String s){
		int ret = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (char ch : s.toCharArray()) {
			if(map.containsKey(ch))
				map.put(ch, map.get(ch)+1);
			else
				map.put(ch, 1);
		}
		boolean evenflag = false ;
		for (char ch : map.keySet()) {
			if(map.get(ch)%2==0){
				ret+=map.get(ch);
				evenflag = true;
			}
			else{
				evenflag = false;
				ret +=map.get(ch)-1;
			}
		}
		return evenflag?ret:ret+1;
	}

}
