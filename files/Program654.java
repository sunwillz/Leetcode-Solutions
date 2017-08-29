package leetcode;

public class Program654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
   
    		return helper(nums,0,nums.length-1);
    }

	private TreeNode helper(int[] nums, int start, int end) {
		if(start==end) return new TreeNode(nums[start]);
		if(start<0||end>nums.length-1) return null; 
 		int max = nums[start];
		int idx = start;
		for (int i = start; i <=end; i++) {
			if(nums[i]>max){
				max = nums[i];
				idx = i;
			}
		}
        TreeNode root = new TreeNode(max);
        if(idx>start)
        {
        		TreeNode left = helper(nums,start,idx-1);
        		root.left = left;
        }
        if(idx<end)
        {
        		TreeNode right = helper(nums,idx+1,end);
        		root.right = right;
        }
        return root;
	}
}
