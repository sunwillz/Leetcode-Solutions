package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        if(root==null) return list;        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty()){
        	 	int n = queue.size();
        	 	double sum = 0.0;
        	 	for (int i = 0; i < n; i++) {
        	 		TreeNode node = queue.remove();
				sum +=node.val;
				if(node.left!=null) queue.add(node.left);
				if(node.right!=null) queue.add(node.right);
				}
        	 	list.add(sum/n);

        }
        return list;
    }

}
