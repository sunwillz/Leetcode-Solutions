package leetcode;

public class Program98 {

	public static void main(String[] args) {

	}
    public static boolean isValidBST(TreeNode root) {
    		if(root==null) return true;
    		if(root.left==null&&root.right==null) return true;
    		if(root.left!=null) {
    			int leftMax = maxVal(root.left);
    			if(root.val<=leftMax)return false;
    		}
    		if(root.right!=null) {
    			int rightMax = minVal(root.right);
    			if(root.val>=rightMax) return false;
    		}
    		return isValidBST(root.left)&&isValidBST(root.right);
    }
	private static int minVal(TreeNode root) {
		if(root==null) return Integer.MAX_VALUE;
		int left = minVal(root.left);
		int right = minVal(root.right);
		int m = Math.min(left, right);
		return Math.min(m, root.val);
	}
	private static int maxVal(TreeNode root) {
		if(root==null) return Integer.MIN_VALUE;
		int left = maxVal(root.left);
		int right = maxVal(root.right);
		int m = Math.max(left, right);
		return Math.max(m, root.val);
	}
}
