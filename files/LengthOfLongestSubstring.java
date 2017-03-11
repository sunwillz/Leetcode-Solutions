package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String str="asfafsdad";
		System.out.println(lengthOfLongestSubstring(str));
	}
	public static int lengthOfLongestSubstring(String s) {
        int max=0;
        if(s==null) return 0;
        if(s.length()==1) return 1;
		List<Character> ch = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
        	ch.add(s.charAt(i));
			for (int j = i+1; j < s.length(); j++) {
			   if(!ch.contains(s.charAt(j)))	{//没有重复的字符，加入集合
				  ch.add(s.charAt(j));
			   }else{
				   
				   break;
			   }
			}
			max=Math.max(max, ch.size());
			ch.clear();
		}
		return max;
    }
}
