package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program438 {

	public static void main(String[] args) {
		String s="acbaebabacd";
		String p="abc";
		System.out.println(findAnagrams(s, p).toString());
	}
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[26]; //character hash
	    //record each character in p to hash
	    for (char c : p.toCharArray()) {
	        hash[c-'a']++;
	    }
	    System.out.println(Arrays.toString(hash));
	    //two points, initialize count to p's length
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        //move right everytime, if the character exists in p's hash, decrease the count
	        //current hash value >= 1 means the character is existing in p
	        if (hash[s.charAt(right++)-'a']-- >= 1) count--; 
	        
	        //when the count is down to 0, means we found the right anagram
	        //then add window's left to result list
	        if (count == 0) list.add(left);
	    
	        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
	        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
	        if (right - left == p.length() && hash[s.charAt(left++)-'a']++ >= 0) count++;
	    }
	    return list;
    }
	public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length())
            return res;
        char[] sStr = s.toCharArray();
        int[]map = new int[26];
        for(char ch:p.toCharArray())
            map[ch - 'a']++;
        int n = s.length(), m = p.length();;
        int j = 0;
        for(j=0; j<m-1; j++)
            map[sStr[j] - 'a']--;
        for(int i=0; j<n; i++, j++){
            map[sStr[j] - 'a']--;
            if(check(map))
                res.add(i);
            map[sStr[i] - 'a']++;
        }
        return res;
    }
    public boolean check(int[]map){
        for(int n:map)
            if(n > 0)   return false;
        return true;
    }
}
