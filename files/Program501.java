package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Program501 {

	public static void main(String[] args) {

	}
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[]{};
        Map<Integer,Integer> counts = new HashMap<>();
    		Queue<TreeNode> queue = new LinkedList<>();
    		queue.add(root);
    		while(!queue.isEmpty()){
    			TreeNode node = queue.poll();
    			if(node.left!=null) queue.add(node.left);
    			if(node.right!=null) queue.add(node.right);
    			counts.put(node.val, counts.getOrDefault(node.val, 0)+1);
    		}
    		int maxC = Integer.MIN_VALUE;
    		List<Integer> list = new ArrayList<>();
    		for (int k : counts.keySet()) {
				maxC = Math.max(maxC, counts.get(k));
		}
    		for (int k : counts.keySet()) {
				if(counts.get(k)==maxC)list.add(k);
		}
    		int[] ans = new int[list.size()];
    		for (int i = 0; i < ans.length; i++) {
				ans[i]=list.get(i);
			}
    		return ans;
    }
}
