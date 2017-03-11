package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program500 {

	public static void main(String[] args) {
		String[] str = {"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(findWords(str)));
	}
	public static String[] findWords(String[] words){
		String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < strs.length; i++) {
			for (char c : strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		List<String> list = new ArrayList<String>();
		for (String w : words) {
			if(w.equals(""))continue;
			int index = map.get(w.toUpperCase().charAt(0));
			for (char c : w.toUpperCase().toCharArray()) {
				if(map.get(c)!=index){
					index = -1;
					break;
				}
			}
			if(index!=-1)list.add(w);
		}
		return list.toArray(new String[0]);
	}

}
