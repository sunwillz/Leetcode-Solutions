package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program257 {

	/**
	 * 输出二叉树根节点到叶子节点的所有路径
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(3);
		 TreeNode node3 = new TreeNode(5);
	
		 root.left=node1;
		 root.right=node2;
		 node2.right=node3;
		
		 System.out.println(binaryTreePaths(root).toString());
		 
		 int[] nums={5,7,9,10,1,4,5,5};
		 System.out.println(findMin(nums));
	}
	//递归
	public static List<String> binaryTreePaths(TreeNode root){
		if(root==null) return new ArrayList<String>();
		
		List<String> res =new ArrayList<String>();
		dfs(root,res,"");
		return res;
	}
	private static void dfs(TreeNode root, List<String> res, String path) {
		if(root.left==null && root.right==null)
			res.add(path+root.val);
		if(root.left!=null) dfs(root.left,res,path+root.val+"->");
		if(root.right!=null) dfs(root.right,res,path+root.val+"->");
	}
	//非递归
	public static List<String> binaryTreePaths1(TreeNode root){
		if(root==null) return new ArrayList<String>();
		
		List<String> res =new ArrayList<String>();
		
		return res;
	}
	public static int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
	private static int helper(int[] nums, int start, int end) {
		if(start == end){
			return nums[start];
		}
		int mid = (start+end)/2;
		
		return Math.min(helper(nums,start,mid),helper(nums,mid+1,end));
	}

}
