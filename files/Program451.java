package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Program451 {

	public static void main(String[] args) {
		String s= "asddaada";
		System.out.println(new String(new char[4]).replace('\0', 'f'));
		System.out.println(frequencySort(s));
	}
	public static String frequencySort(String s ){
		int[] freq = new int [256];
	    for (char ch: s.toCharArray()) {
	    	freq[ch]++;
	    }
		TreeMap<Integer,List<Character>> tree = new TreeMap<Integer,List<Character>>();
		for (int i=0;i<freq.length;i++) {
			if(freq[i]>0){
				if(!tree.containsKey(freq[i])){
					tree.put(freq[i], new LinkedList<Character>());
				}
				tree.get(freq[i]).add((char)i);
			}
		}
		StringBuilder sb=new StringBuilder();
		while(tree.size()>0){
			Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
			for(char ch:entry.getValue())
			sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
		}
		return sb.toString();
	}

}
