package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println (1<<3);
	}
	private static boolean compare(String f, String s)
    {
        for ( int i = 0; i < f.length (); i++ )
        {
            for ( int j = 0; j < s.length (); j++ )
            {
                if (f.charAt (i) == s.charAt (j))
                {
                	return true;
                }
            }
        }
        return false;
    }
   
	public static int maxProduct(String[] words) {
        int res= 0;
        for (int i = 0; i < words.length; i++) 
        {
			for (int j = i+1; j < words.length; j++) 
			{
				if(!compare(words[i],words[j]))
				{//不含有相同的字符
					int pro=words[i].length()* words[j].length();
					res= res>pro?res:pro;
				}
			}
		}
		return res;
    }
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		int totalNumber = 1 << nums.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
		for (int i=0; i<totalNumber; i++) {
			List<Integer> set = new LinkedList<Integer>();
			for (int j=0; j<nums.length; j++) {
				if ((i & (1<<j)) != 0) {
					set.add(nums[j]);
				}
			}
			collection.add(set);
		}
		return collection;
    }
}
