package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program95 {
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1,n);
    }

	private List<TreeNode> helper(int s, int e) {
		List<TreeNode> ret = new ArrayList<>();
		
		if(s>e){
			ret.add(null);
			return ret;
		}
		for (int i = s; i <= e; i++) {
			List<TreeNode> left = helper(s,i-1);
			List<TreeNode> right = helper(i+1,e);
			for (TreeNode leftTree : left) {
				for (TreeNode rightTree : right) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					ret.add(root);
				}
			}
		}
		return ret;
	}
}
