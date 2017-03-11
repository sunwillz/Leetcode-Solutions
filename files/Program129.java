package leetcode;

import java.util.Stack;

public class Program129 {

	public static void main(String[] args) {
		/*TreeNode nodeA = new TreeNode("A",1);
		TreeNode nodeB = new TreeNode("B",2);
		TreeNode nodeC = new TreeNode("C",5);
		TreeNode nodeD = new TreeNode("D",3);
		TreeNode nodeE = new TreeNode("E",4);
		TreeNode nodeF = new TreeNode("F",6);
		nodeA.left=nodeB;
		nodeA.right=nodeC;
		nodeB.left=nodeD;
		nodeB.right=nodeE;
		nodeC.left=nodeF;
		System.out.println(sumNumbers(nodeA));*/
	}
	 public static void preOrderStack_2(TreeNode root){  
	        if(root==null)return;  
	        Stack<TreeNode> s=new Stack<TreeNode>();  
	        while(root!=null||!s.isEmpty()){  
	            while(root!=null){  
	                System.out.print(root.name+" ");  
	                s.push(root);//先访问再入栈  
	                root=root.left;  
	            }  
	            root=s.pop();  
	            root=root.right;//如果是null，出栈并处理右子树  
	        }  
	    }  
	public static int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
	private static int helper(TreeNode root, int sum) {
		if(root ==null ) return 0;
		if(root.left==null && root.right==null) return 10*sum+root.val;
		else return helper(root.left,10*sum+root.val)+helper(root.right,10*sum+root.val);
	}
}

