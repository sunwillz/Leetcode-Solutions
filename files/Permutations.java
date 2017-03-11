package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums={1,1,3};
		System.out.println(permuteUnique1(nums).toString());
	}
	public static List<List<Integer>> permuteUnique1(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack1(list, new ArrayList<Integer>(), nums, new boolean[nums.length]);
	    return list;
	}

	private static void backtrack1(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
	    if(tempList.size() == nums.length){
	        list.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack1(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if ( nums == null || nums.length == 0 ) { return result; }
        List<Integer> template = new ArrayList<Integer>();
        back_tracking ( result, nums, template, 0 );
        return result;
    }
    public static void back_tracking ( List<List<Integer>> result, int[] nums, List<Integer> template, int index ){
        if ( template.size() == nums.length ) {
            if (!result.contains(template)) {
            result.add( template );}
            return;
        }
        for ( int i = 0; i <= template.size(); ++i ) {
            List<Integer> copy = new ArrayList<Integer>(template);
            copy.add(i, nums[index]);
            back_tracking( result, nums, copy, index + 1);
        }
    }
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,new ArrayList<Integer>());
        return result;
    }
	private static void dfs(List<List<Integer>> result, int[] nums,
			List<Integer> arrayList) {
		if(arrayList.size()==nums.length) {
			result.add(new ArrayList<>(arrayList));
			return ;
		}
		for (int i = 0; i < nums.length; i++) {
			if(arrayList.contains(nums[i])) continue;
			arrayList.add(nums[i]);
			dfs(result,nums,arrayList);
			arrayList.remove(arrayList.size()-1);
		}
		
	}
	public static List<List<Integer>> permute1(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    if(nums == null || nums.length == 0 ) return list;
	    backtrack(list, new ArrayList<Integer>(), nums);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list, ArrayList<Integer> arrayList, int [] nums){
	    if(arrayList.size() == nums.length){
	        list.add(new ArrayList<>(arrayList));
	    } else{
	        for(int i = 0; i <= arrayList.size(); i++){
	            arrayList.add(i, nums[arrayList.size()]);
	            backtrack(list, arrayList, nums);
	            arrayList.remove(i);
	        } 
	    }
	}

}
