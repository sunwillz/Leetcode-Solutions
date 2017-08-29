package leetcode;

import java.util.Stack;

public class Program572 {
	/*
	 * 判断t是否是s的子树
	 */
    public boolean isSubtree(TreeNode s, TreeNode t) {
    		if(t==null) return true;
    		if(s==null) return false;
    		if(isSame(s,t))return true;
    		return isSubtree(s.left, t)||isSubtree(s.right, t);
    }
    /*
     * 判断是否是同一棵二叉树
     */
	private boolean isSame(TreeNode s, TreeNode t) {
		if(s==null&&t==null) return true;
		if(s==null||t==null) return false;
		if(s.val!=t.val) return false;
		return isSame(s.left,t.left)&&isSame(s.right, t.right);
	}
	/*
	 * 算法二：得到前序的字符串表示
	 */
	public boolean isSubTree2(TreeNode s,TreeNode t){
		String sPreOrder = generatePreOrder(s);
		String tPreOrder = generatePreOrder(t);

		return sPreOrder.contains(tPreOrder);
	}
	/*
	 * 非递归前序遍历二叉树，空位置用“#”表示
	 */
	private String generatePreOrder(TreeNode t) {
		Stack<TreeNode> stack = new Stack<>();
		StringBuffer sb =new StringBuffer();
		stack.push(t);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node==null) sb.append("-#");
			else {
				sb.append("-"+node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		return sb.toString();
	}
	/*
	 * 非递归中序遍历二叉树
	 */
	private void inOrder(TreeNode t) {
		if(t==null) return;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty()){
			while(t!=null){
				stack.push(t);
				t=t.left;
			}
			t = stack.pop();
			System.out.println(t.val);
			t=t.right;
		}
	}
}
