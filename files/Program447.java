package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program447 {

	public static void main(String[] args) {

	}
    public static int numberOfBoomerangs(int[][] points) {
    		int ans = 0;
    		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    		for (int i = 0; i < points.length; i++) {
				for (int j = 0; j < points.length; j++) {
					if(i==j) continue;
					int d = getDis(points[i],points[j]);
					map.put(d, map.getOrDefault(d, 0)+1);
				}
				for (int val : map.values()) {
					ans+=val*(val-1);
				}
				map.clear();
			}
    		
    		return ans;
    }
	private static int getDis(int[] a, int[] b) {
		int xx = a[0]-b[0];
		int yy = a[1]-b[1];
		return xx*xx+yy*yy;
	}

}
