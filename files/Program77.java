package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program77 {

	public static void main(String[] args) {
		System.out.println(combine(4, 2).toString());
	}
	static List<List<Integer>> result ;
	public static List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
		helper(n,k,1,new ArrayList<Integer>());
		return result;
    }
	private static void helper(int n, int k, int start,List<Integer> curList) {
		if(curList.size()==k){
			result.add(new ArrayList<>(curList));
			return;
		}
		for (int i = start; i <= n; i++) {
			curList.add(i);
			helper(n, k, i+1, curList);
			curList.remove(curList.size()-1);
		}
	}

}
