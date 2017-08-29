package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Program404 {

	public static void main(String[] args) {

	}
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if(root==null) return 0;
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		queue.add(root);
    		while(!queue.isEmpty()){
    			TreeNode node = queue.poll();
    			if(node.left!=null){
    				queue.add(node.left);
    				if(node.left.left==null&& node.left.right==null) ans+=node.left.val;
    			}
    			if(node.right!=null) queue.add(node.right);
    			
    		}
    		return ans;
    }

}
