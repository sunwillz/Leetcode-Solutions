package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Program452 {

	public static void main(String[] args) {
		int[][] points = new int[][]{{1,6},{7,12},{2,8},{10,16}};
		
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0]) return a[1]-b[1];
				else return a[0]-b[0];
			}
		});
		int ans = 1;
		int maxCoordinaty = 	points[0][1];
	       for (int i = 0; i < points.length; i++) {
   	   		if(points[i][0]>maxCoordinaty){
	   			maxCoordinaty = points[i][1];
	   			ans++;
	   		}
	   		else{
	   			maxCoordinaty = Math.min(maxCoordinaty, points[i][1]);
	   		}
	       }
	       System.out.println(ans);
	}
    public static int findMinArrowShots(int[][] points) {
    	if(points==null || points.length==0 || points[0].length==0) return 0;
        int ans = 1;
//        Arrays.sort(points, (a, b) -> a[1] - b[1]);
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0]) return a[1]-b[1];
				else return a[0]-b[0];
			}
		});
		int maxCoordinaty = 	points[0][1];
       for (int i = 0; i < points.length; i++) {
    	   		if(points[i][0]>maxCoordinaty){
    	   			maxCoordinaty = points[i][1];
    	   			ans++;
    	   		}
    	   		else{
    	   			maxCoordinaty = Math.min(maxCoordinaty, points[i][1]);
    	   		}
       }
        
        return ans;
    }
}
