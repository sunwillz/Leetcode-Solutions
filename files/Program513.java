package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Program513 {

	public static void main(String[] args) {

	}
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        		root = queue.poll();
        		if(root.right!=null)
        			queue.add(root.right);
        		if(root.left!=null)
        			queue.add(root.left);
        }
        return root.val;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
