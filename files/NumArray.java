package leetcode;

public class NumArray {

	class SegmentTree{
		int start;
		int end;
		SegmentTree left;
		SegmentTree right;
		int sum;
		
		public SegmentTree(int start,int end){
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}
	SegmentTree root = null;
    public NumArray(int[] nums) {
       root = buildTree(nums,0,nums.length);
       
    }
    
    private SegmentTree buildTree(int[] nums, int start, int end) {
    		if(start>end) return null;
    		else{
    			SegmentTree node = new SegmentTree(start,end);
    			if(start==end) node.sum = nums[start];
    			else{
    				int mid = start+(end-start)/2;
    				node.left = buildTree(nums,start,mid);
    				node.right = buildTree(nums,mid+1,end);
    				node.sum = node.left.sum+node.right.sum;
    			}
    			return node;
    		}
	}

	public void update(int i, int val) {
        update(root,i,val);
    }
    
    private void update(SegmentTree node, int pos, int val) {
		if(node.start==node.end) node.sum = val;
		else{
			int mid = node.start+(node.end-node.start)/2;
			if(pos<=mid){
				update(node.left,pos,val);
			}else{
				update(node.right,pos,val);
			}
			node.sum = node.left.sum+node.right.sum;	
		}
	}

	public int sumRange(int i, int j) {
       return sumRange(root,i,j);
    }

	private int sumRange(SegmentTree node, int start, int end) {
		if(node.start==start&&node.end == end) return node.sum;
		else{
			int mid = node.start+(node.end-node.start)/2;
			if(end<=mid){
				return sumRange(node.left,start,end);
			}else if(start>=mid+1){
				return sumRange(node.right,start,end);
			}else{
				return sumRange(node.left,start,mid)+sumRange(node.right,mid+1,end);
			}
		}
	}
}
