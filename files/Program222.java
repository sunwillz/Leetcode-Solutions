package leetcode;

public class Program222 {
	public static void main(String[] args) {
		System.out.println(1<<2);
	}
    public int countNodes(TreeNode root) {
    		int h = height(root);
       return h<0?0:height(root.right)==h-1?(1<<h+countNodes(root.right)):(1<<h)+countNodes(root.left)+(1<<h-1); 
    }
    private int height(TreeNode root){
    		return root==null?-1:1+height(root.left);
    }
}
