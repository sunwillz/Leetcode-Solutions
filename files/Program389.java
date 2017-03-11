package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program389 {

	public static void main(String[] args) {
		String s="abcd";
		String t ="bccda";
		System.out.println(findTheDifference(s, t));
	}
	public static char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (char st : s.toCharArray()) {
			if(map.containsKey(st)){
				map.put(st, map.get(st)+1);
			}else{
				map.put(st, 1);
			}
		}
        for (char i : t.toCharArray()) {
			if(map.containsKey(i)){
				map.put(i, map.get(i)-1);
			}else{
				return i;
			}
		}
        for (char i : map.keySet()) {
			if(map.get(i)<0)
				return i;
		}
        return ' ';
    }

}
