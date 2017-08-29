package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Program508 {
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {
    		if(root==null) return new int[]{};
        helper(root);
        List<Entry<Integer,Integer>> list =new ArrayList<Entry<Integer,Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
        		public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2) {
        			return (o2.getValue() - o1.getValue());
        		}
        });
        List<Integer> ret = new ArrayList<Integer>();
        int m = list.get(0).getValue();
        for (Entry<Integer, Integer> entry : list) {
			if(entry.getValue()<m)break;
			else ret.add(entry.getKey());
				
		}
        int[] ans = new int[ret.size()];
        for (int i = 0; i < list.size(); i++) {
			ans[i] = ret.get(i);
		}
        return ans;
    }

	private int helper(TreeNode root) {
		if(root==null)return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		int sum = root.val+left+right;
		map.put(sum, map.getOrDefault(sum, 0)+1);
		
		return root.val+left+right;
	}
}
