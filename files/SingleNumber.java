package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="Live on evasions? No I save no evil.";
		System.out.println(reverseVowels(str));
	}
	public static int singleNumber(int[] nums){
		if(nums.length<2) return nums[0];
		Arrays.sort(nums);
		
		if(nums[0]!=nums[1] && nums[1]==nums[2]) return nums[0];
		else{
			for (int i = 0; i < nums.length-1; i+=2) {
				if(nums[i]!=nums[i+1]) return nums[i];
			}
			if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
		}
		return 0;
	}
	public static String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer();
        List<Character> vowel =new ArrayList<Character>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
		List<Character> ls =new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {//将s中所有元音字符放入集合
			if(vowel.contains(s.charAt(i)))
				ls.add(s.charAt(i));
		}
		System.out.println(ls.toString());
        for (int i = 0; i < s.length(); i++) {
			if(!vowel.contains(s.charAt(i)))
				sb.append(s.charAt(i));//非元音字符直接拼接成字符串
			else
				sb.append(ls.remove((ls.size()-1)));//反向拼接元音字符
		}
        
        return sb.toString();
    }

}
