package leetcode;

public class Program235 {

	public static void main(String[] args) {

	}
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    		while((root.val-p.val)*(root.val-q.val)>0)
    			root = root.val<p.val?root.right:root.left;
    		return root;
    }
}
