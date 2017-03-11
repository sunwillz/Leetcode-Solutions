package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.apache.catalina.tribes.util.Arrays;

public class Program378 {

	public static void main(String[] args) {
		int[][] matrix =  { {1,  5,  9},
				   {10, 11, 13},
				   {12, 13, 15}};
		System.out.println(kthSmallest(matrix, 9));
	}
	public static int kthSmallest(int[][] matrix, int k) {
		if(k==1||matrix.length==1||matrix[0].length==1) return matrix[0][0];
		Comparator<Struct> compare = new Comparator<Struct>() {

			@Override
			public int compare(Struct o1, Struct o2) {
				return o1.v-o2.v;
			}
		};
        PriorityQueue<Struct> queue = new PriorityQueue<>(k,compare);
        int rowSum = matrix.length,colSum = matrix[0].length;
        boolean[][] bool = new boolean[rowSum][colSum];
        queue.offer(new Struct(matrix[0][0],0,0));
        bool[0][0] = true;
        for (int i = 1; i <=k &&!queue.isEmpty(); i++) {
			Struct st = queue.poll();
			int x = st.row;
			int y = st.col;
			if(y+1<colSum&& !bool[x][y+1]){
				queue.offer(new Struct(matrix[x][y+1],x,y+1));
				bool[x][y+1]=true;
			}
			if(x+1<rowSum && !bool[x+1][y]){
				queue.offer(new Struct(matrix[x+1][y],x+1,y));
				bool[x+1][y]=true;
			}
			if(i==k) return st.v;
		}
		return 0;
    }
}
class Struct{
	int v;
	int col;
	int row;
	public Struct(int v,int row,int col){
		this.v = v;
		this.row = row;
		this.col=col;
	}
}