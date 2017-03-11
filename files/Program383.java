package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program383 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st1="aa";
		String st2="ab";
		System.out.println(canConstruct(st1, st2));
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
        	if(map1.containsKey(ch)){
        		map1.put(ch, map1.get(ch)+1);
        	}else{
        		map1.put(ch,1);
        	}
		}
        for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
        	if(map2.containsKey(ch)){
        		map2.put(ch, map2.get(ch)+1);
        	}else{
        		map2.put(ch,1);
        	}
		}
        for(Map.Entry<Character,Integer> entry:map1.entrySet()){
        	if(!map2.containsKey(entry.getKey()) || entry.getValue()>map2.get(entry.getKey())){
        		return false;
        	}
        }
		return true;
    }

}
