package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Program140 {

	public static void main(String[] args) {
		LinkedList<String> res = new LinkedList<String>(); 
		res.add("");
		System.out.println(res.isEmpty());
		String s ="catsanddog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(wordBreak(s, wordDict).toString());
		System.out.println(wordBreak2(s, wordDict).toString());
	}
	public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if(s==null || s.length()==0) return result;
		dfs(s,wordDict,0,"",result);
        return result;
    }
	private static void dfs(String s, Set<String> wordDict, int idx,
			String str, List<String> result) {
		if(idx>=s.length()){
			result.add(str);
			return;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = idx; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if(wordDict.contains(sb.toString())){
				String newStr = str.length()>0?(str+" "+sb.toString()):sb.toString();
				dfs(s,wordDict,i+1,newStr,result);
			}
		}
	}
	public static List<String> wordBreak2(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}

}
