package leetcode;

public class Program116 {
    public void connect(TreeLinkNode root) {
    		if(root==null)return;
    		TreeLinkNode level_start = root;
    		while(level_start!=null){
    			TreeLinkNode cur = level_start;
    			while(cur!=null){
    				if(cur.left!=null) cur.left.next = cur.right;
    				if(cur.right!=null&& cur.next!=null) cur.right.next = cur.next.left;
    				
    				cur = cur.next;
    			}
    			level_start = level_start.left;
    		}
    	   			
    }
}

// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
