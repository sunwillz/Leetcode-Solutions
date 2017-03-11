package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Program107 {

	public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(2);
		 TreeNode node3 = new TreeNode(3);
		 TreeNode node4 = new TreeNode(4);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(3);
		 root.left=node1;
		 root.right=node2;
		 node1.left=node3;
		 node1.right=node4;
		 node2.left=node5;
		 node2.right=node6;
		 System.out.println(isSymmetric1(root));
		}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root==null) return new ArrayList<List<Integer>>();
        List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
        List<TreeNode> par = new ArrayList<TreeNode>();
        par.add(root);
        List<TreeNode> child = new ArrayList<TreeNode>();
        while(!par.isEmpty()){
        	res.add(par);
        	for (TreeNode node : par) {
        		TreeNode left = node.left;
        		TreeNode right = node.right;
				if(left!=null) child.add(left);
				if(right!=null) child.add(right);
			}
        	par = child;
        	child = new ArrayList<TreeNode>();
        }
        for (List<TreeNode> t : res) {
			for (TreeNode node : t) {
				System.out.print(node.val+" ");
			}
			System.out.println();
		}
        return getReverseOrder(res);
    }
	private static List<List<Integer>> getReverseOrder(List<List<TreeNode>> res) {
		if(res.isEmpty()) return new ArrayList<List<Integer>>();
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		ListIterator<List<TreeNode>> it = res.listIterator();
		List<Integer> tp = new ArrayList<Integer>();
		while(it.hasNext()) it.next();
		while(it.hasPrevious()){
			List<TreeNode> lever = it.previous();
			for (TreeNode i : lever) {
				tp.add(i.val);
			}
			result.add(new ArrayList<>(tp));
			tp.clear();
		}
		return result;
	}
	
	/**
	 * 判断是否为镜像树(对称树),递归
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true; 
		
		return check(root.left,root.right);
    }
	
	/**
	 * 判断是否为镜像树(对称树),非递归
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric1(TreeNode root) {
        if(root==null) return true; 
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root.left);
		s.push(root.right);
		while(!s.isEmpty()){
			TreeNode r = s.pop();
			TreeNode l = s.pop();
			if(r==null && l==null) continue;
			if(r==null || l==null) return false;
			if(r.val!=l.val) return false;
			s.push(l.left);
			s.push(r.right);
			s.push(l.right);
			s.push(r.left);
		}
		return true;
    }
	private static boolean check(TreeNode left, TreeNode right) {
		if(left==null && right==null) 
			return true;
		if(left==null || right==null)
			return false;
		return left.val==right.val && check(left.left,right.right) && check(left.right,right.left);
	}
}
