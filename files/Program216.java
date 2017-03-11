package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program216 {

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 9).toString());

	}
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result,new ArrayList<Integer>(),k,n,1);
        return result;
    }
	private static void dfs(List<List<Integer>> result, List<Integer> arrayList, int k, int n,int start) {
		if(n==0 && k==0){
			result.add(new ArrayList<Integer>(arrayList));
			return ;
		}
		for (int i = start; i <= 9; i++) {
			arrayList.add(i);
			dfs(result,arrayList,k-1,n-i,i+1);
			arrayList.remove(arrayList.size()-1);
		}
		
	}

}
