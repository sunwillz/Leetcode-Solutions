package leetcode;

public class Program124 {

	public static void main(String[] args) {
		
	}
	private static int maxSum = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
        if(root==null) return 0;
		helper(root);
		return maxSum;
    }
	private static int helper(TreeNode root) {
		if(root==null) return 0;
		int left = Math.max(0,helper(root.left));
		int right = Math.max(0, helper(root.right));
		maxSum= Math.max(maxSum, left + right + root.val);
		return Math.max(root.val,Math.max(root.val+left, root.val+right));
	}

}
