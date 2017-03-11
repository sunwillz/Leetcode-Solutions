package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="foo";
		String t="abb";
		System.out.println(isIsomorphic(s, t));
	}
	public static boolean isIsomorphic(String s,String t){
		if(s.length()!=t.length()) return false;
		Map<Character,Character> mp = new HashMap<Character,Character>();
		char[] t_arr = t.toCharArray();
		if(s.length()!=t_arr.length)return false;
		for (int i = 0; i < s.length(); i++) {
			if(!mp.containsKey(s.charAt(i))){
				if(mp.containsValue(t_arr[i])) return false;
				mp.put(s.charAt(i),t_arr[i]);
			}
			else if(!mp.get(s.charAt(i)).equals(t_arr[i])){
				return false;
			}
		}
		return true;
	}

}
