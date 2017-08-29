package leetcode;

public class Program530 {

	public static void main(String[] args) {

	}
	static int min = Integer.MAX_VALUE;
	static Integer pre = null;
	
    public static int getMinimumDifference(TreeNode root) {
    		if(root==null) return min;
    		getMinimumDifference(root.left);
    		
    		if(pre !=null)
    			min = Math.min(min,root.val-pre);
    		
    		pre = root.val;
    		
    		getMinimumDifference(root.right);
    	
    		return min;
    }

}
