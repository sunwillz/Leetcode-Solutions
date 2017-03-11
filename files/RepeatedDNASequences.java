package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString());
	}
	public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ls = new ArrayList<String>();
        if(s.length()==0 || s==null) return ls;
        int len = s.length();
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i <= len-10; i++) {
        	String str = s.substring(i,i+10);
			if(map.containsKey(str)){
				map.put(str, map.get(str)+1);
			}else{
				map.put(str, 1);
			}
		}
        for(Map.Entry<String, Integer> ent:map.entrySet()){
        	if(ent.getValue()>1) ls.add(ent.getKey());
        }
        return ls;
    }
}
