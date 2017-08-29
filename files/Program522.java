package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Program522 {
	public static void main(String[] args){
		System.out.println(subSeqSet("abcd"));
	}
	/*
	 * 先求出所有的子序列，遍历这些子序列，当出现次数为1时，取长度最长的
	 */
    public static int findLUSlength(String[] strs) {
        int ans = 0;
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String string : strs) {
			for (String subSeq : subSeqSet(string)) {
				map.put(subSeq, map.getOrDefault(subSeq, 0)+1);
			}
		}
        for(Map.Entry<String, Integer> entry:map.entrySet())
        		if(entry.getValue()==1) ans = Math.max(ans, entry.getKey().length());
        return ans;
    }

	private static Set<String> subSeqSet(String string) {
		Set<String> set =new HashSet<String>();
		if(string.length()==0){
			set.add("");
			return set;
		}
		Set<String> resSet = subSeqSet(string.substring(1));
		set.addAll(resSet);
		for (String seq : resSet) {
			set.add(string.charAt(0)+seq);
		}
		return set;
	}
}
