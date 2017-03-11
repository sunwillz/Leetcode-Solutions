package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(s).toString());
	}
	 
	public static List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<List<String>>();
         if(strs==null || strs.length==0) return res;	
         
         Map<String,List<String>> map = new HashMap<String,List<String>>();
         List<String> templist=null;
         for (int i = 0; i < strs.length; i++) {
			//String nsts = getStringOnOrder(strs[i]);//将字符串字符排序
        	 char[] ch = strs[i].toCharArray();
     		 Arrays.sort(ch);
        	 String nsts = String.valueOf(ch);
			if(map.containsKey(nsts)){
				templist = map.get(nsts);
				templist.add(strs[i]);
				map.put(nsts,templist);
			}else{
				List<String> nlist = new ArrayList<>();
				nlist.add(strs[i]);
				map.put(nsts, nlist);
			}
		}
         for (List<String> i:map.values()) {
			res.add(i);
		}
         return res;
    }
	private static String getStringOnOrder(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
		/*StringBuilder sb = new StringBuilder();
		for (char c : ch) {
			sb.append(c);
		}
		return sb.toString();*/
	}
}
