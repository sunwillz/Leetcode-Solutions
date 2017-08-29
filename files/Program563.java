package leetcode;

public class Program563 {
	int ans = 0;
    public int findTilt(TreeNode root) {
    		helper(root);
        
        return ans;
    }
	private int helper(TreeNode root) {
		if(root==null) return 0;
		
		int left = helper(root.left);
		int right = helper(root.right);
			
		ans +=Math.abs(left-right);
		
		return left+right+root.val;
	}
}
