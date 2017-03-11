package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Program387 {

	public static void main(String[] args) {
		String s ="loveeetcode";
		System.out.println(firstUniqChar(s));
	}
	public static int firstUniqChar(String s) {
        if(s==null || s.length()==0) return 0;
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c= s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if(m.getValue()==1) {
				return s.indexOf(m.getKey());
			}
		}
		return -1;
    }

}
