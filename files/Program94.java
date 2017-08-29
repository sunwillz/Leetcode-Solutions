package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 中序遍历二叉树
 * @author sunwill
 *
 */
public class Program94 {

	public static void main(String[] args) {

	}
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(cur!=null||!s.isEmpty()){
        		while(cur!=null){
        			s.add(cur);
        			cur = cur.left;
        		}
        		cur = s.pop();
        		list.add(cur.val);
        		cur = cur.right;
        }
        return list;
    }
}
