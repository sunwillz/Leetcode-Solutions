package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program337 {

	public static void main(String[] args) {

	}

	public static int rob(TreeNode root) {
		int[] res = robsub(root);

		return Math.max(res[0], res[1]);
	}

	private static int[] robsub(TreeNode root) {
		if (root == null)
			return new int[2];

		int[] left = robsub(root.left);
		int[] right = robsub(root.right);

		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = Math.max(left[0], right[0]) + root.val;
		return res;
	}
	public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
        
    }

	private int depth(TreeNode root) {
		return root==null?0:1+Math.max(depth(root.left), depth(root.right));
	}
	//建立二叉查找树
	public  List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        
        return res;
    }
class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
