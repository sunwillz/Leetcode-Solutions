package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program336 {

	public static void main(String[] args) {
		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		System.out.println(palindromePairs(words).toString());
	}
	public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<String> list = Arrays.asList(words);
        for (int i = 0; i < words.length; i++) {
			String reverse_word = new StringBuilder(words[i]).reverse().toString();
			int len = reverse_word.length();
			for (int j = 0; j <= len; j++){
				String left = reverse_word.substring(0, j);
				String right = reverse_word.substring(j, len);
				if(list.contains(left)&&i!=list.indexOf(left)&&isPalindrome(right)){
					res.add(Arrays.asList(list.indexOf(left),i));
				}
				if(list.contains(right)&&j!=0&&i!=list.indexOf(right)&&isPalindrome(left)){
					res.add(Arrays.asList(i,list.indexOf(right)));
				}
			}
		}
        
        return res;
    }
	private static boolean isPalindrome(String word) {
		int i =0;
		int j = word.length()-1;
		while(i<j){
			if(word.charAt(i++)!=word.charAt(j--)) return false;
		}
		return true;
	}
}
