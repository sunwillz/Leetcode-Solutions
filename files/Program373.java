package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Program373 {
    
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if(nums1.length==0||nums2.length==0||nums1==null||nums2==null) return ret;
        Comparator<Pair> compare = new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2){
	            return Long.compare(p1.sum, p2.sum);
	        }
		};
		
		int len2=nums2.length;  
		PriorityQueue<Pair> q = new PriorityQueue(k,compare); 
        for (int i=0; i<nums1.length && i<k ; i++) {  
            q.offer(new Pair(0,nums1[i],nums2[0]));
        }
        for (int i=1; i<=k && !q.isEmpty(); i++) {
            Pair p = q.poll(); 
            ret.add( p.pair );
            if (p.idx < len2 -1 ) { 
                int next = p.idx+1;
                q.offer( new Pair(next, p.pair[0], nums2[next]) );
            }
        }
        return ret;
    }
	public static void main(String[] args) {
		int[] nums1={1,2,5,7,9};
		int[] nums2={2,4,6,8,10};
		List<int[]> ret = kSmallestPairs(nums1, nums2, 15);
		for (int i = 0; i < 15; i++) {
			System.out.println("["+ret.get(i)[0]+","+ret.get(i)[1]+"]");
		}
	}
	
}
class Pair{
    int[] pair;
    int idx; 
    long sum;
    Pair(int idx, int n1, int n2){
        this.idx = idx;
        pair = new int[]{n1, n2};
        sum = (long) n1 + (long) n2;
    }
}