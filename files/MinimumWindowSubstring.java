package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * Given a string S and a string T, 
 * find the minimum window in S which will contain all the characters in T
 *  in complexity O(n).
	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC"
 * @author sun
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s ="bdabdsf";
		String t="ab";
		HashMap<String, Integer> target = new HashMap<String, Integer>();
		target.put("a", 1);
		target.put("a", 2);
		target.put("a", 3);
		target.put("b", 3);
		for (Map.Entry<String, Integer> entry:target.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
		//System.out.println("结果:"+minWindow1(s, t));
		//System.out.println("结果:"+minWindow(s, t));
	}
	public static String minWindow(String s, String t) {
		if(s.length()<t.length() || t=="") return "";
        String tempStr=null;
        String str=s;
        List<Character> charls = new ArrayList<Character>();
        
        for (int i = 0; i < s.length()-t.length()+1; i++) {
             charls.clear();
            for (int k = 0; k < t.length(); k++) {
     			charls.add(t.charAt(k));
     		}
            int j;
        	for ( j = i; j < s.length(); j++) {
        		if(charls.contains(s.charAt(j))){
        			charls.remove(charls.indexOf(s.charAt(j)));
        		}
				if(charls.size()==0 || j==s.length()-1) break;
			}
        	if(charls.size()==0){
        	tempStr=s.substring(i, j+1);
        	str=str.length()<tempStr.length()?str:tempStr;
        	}
        	if(i==0 && j==s.length()-1 && charls.size()>0) return "";
		}
		return str;
    }
	public static String minWindow1(String s, String t) {
	    if(t.length()>s.length()) 
	        return "";
	    String result = "";
	 
	    //character counter for t
	    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
	    for(int i=0; i<t.length(); i++){
	        char c = t.charAt(i);    
	        if(target.containsKey(c)){
	            target.put(c,target.get(c)+1);
	        }else{
	            target.put(c,1);  
	        }
	    }
	 
	    // character counter for s
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    int left = 0;
	    int minLen = s.length()+1;
	 
	    int count = 0; // the total of mapped characters
	    /*String s ="abcddfg";
		String t="bdd";*/
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(target.containsKey(c)){
	            if(map.containsKey(c)){
	                if(map.get(c)<target.get(c)){
	                    count++;
	                }
	                map.put(c,map.get(c)+1);
	            }else{
	                map.put(c,1);
	                count++;
	            }
	        }
	        /*String s ="bdabdsf";
			String t="ab";*/
	 
	        if(count == t.length()){
	            char sc = s.charAt(left);
	            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
	                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
	                    map.put(sc, map.get(sc) - 1);
	                left++;
	                sc = s.charAt(left);
	            }
	            
	            if (i - left + 1 < minLen) {
	                result = s.substring(left, i + 1);
	                minLen = i - left + 1;
	            }
	        }
	    }
	    for (Map.Entry<Character, Integer> entry:map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
	    return result;
	}
}
