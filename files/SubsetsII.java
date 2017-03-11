package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,2};
		/*List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l2.add(2);
		l2.add(1);
		Collections.sort(l2,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
			
		});
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		set.add(l1);
		set.add(l2);*/
		System.out.println(subsetsWithDup(arr).toString());
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();
        if(nums.length==0) return result;
        int totalNumber = 1 << nums.length;//子集合的个数
        for (int i=0; i<totalNumber; i++) {
            List<Integer> ls = new LinkedList<Integer>();
            for (int j=0; j<nums.length; j++) {
                if ((i & (1<<j)) != 0) {//位运算判断位上是0还是1
                    ls.add(nums[j]);
                }
            }
            set.add(helper(ls));
        }
        for (List<Integer> i : set) {
			result.add(i);
		}
        return result;
    }
    public static List<Integer> helper(List<Integer> list){
    	Collections.sort(list,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
			
		});
    	return list;
    }

}
