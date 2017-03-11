package leetcode;

import java.util.HashMap;
import java.util.Map;


public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern="aa";
		String str="dog dog";
		System.out.println(wordPatern(pattern, str));
	}
	public static boolean wordPatern(String pattern,String str){
		Map<Character,String> mp = new HashMap<Character,String>();
		String[] array = str.split(" ");
		if(pattern.length()!=array.length)return false;
		for (int i = 0; i < pattern.length(); i++) {
			if(!mp.containsKey(pattern.charAt(i))){
				if(mp.containsValue(array[i])) return false;
				mp.put(pattern.charAt(i),array[i]);
			}
			else if(!mp.get(pattern.charAt(i)).equals(array[i])){
				
				return false;
			}
			
		}
		return true;
	}
		
}
