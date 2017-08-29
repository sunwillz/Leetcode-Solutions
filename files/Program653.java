package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Program653 {
    public boolean findTarget(TreeNode root, int k) {
    		List<Integer> list = new ArrayList<>();
    		inorder(root,list);
    		for (int i = 0,j=list.size()-1; i <j; ) {
				if(list.get(i)+list.get(j)==k) return true;
				else if(list.get(i)+list.get(j)<k)i++;
				else j--;
			}
        return false;
    }

	private void inorder(TreeNode root, List<Integer> list) {
		if(root==null) return;
		inorder(root.left,list);
		list.add(root.val);
		inorder(root.right,list);
	}
	
	public boolean findTarget1(TreeNode root, int k){
		HashSet<Integer> set = new HashSet<>();
		return find(root,set,k);
	}

	private boolean find(TreeNode root, HashSet<Integer> set,int k) {
		if(root==null) return false;
		if(set.contains(k-root.val)) return true;
		set.add(root.val);
		return find(root.left,set,k)||find(root.right,set,k);
	}
}
