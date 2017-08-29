package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历二叉树
 * @author sunwill
 *
 */
public class Program144 {

	public static void main(String[] args) {

	}
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
        		while(cur!=null){
        			stack.add(cur);
        			list.add(cur.val);
        			cur = cur.left;
        		}
        		cur = stack.pop();
        		cur = cur.right;
        }
        return list;
    }
}
