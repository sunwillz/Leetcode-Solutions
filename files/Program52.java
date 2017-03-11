package leetcode;

public class Program52 {

	public static void main(String[] args) {
		System.out.println(totalNQueens(10));
	}
	static int count=0;
	public static int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2*n];
        boolean[] d2 = new boolean[2*n];
        
        helper(0,col,d1,d2,n);
		return count;
    }
	
	private static void helper(int row, boolean[] col, boolean[] d1,
			boolean[] d2, int n) {
		if(row==n) count++;
		for (int i = 0; i < n; i++) {
			int id1 = i+row;
			int id2 = n+row-i;
			if(col[i]||d1[id1]||d2[id2]) 
				continue;
			col[i]=true;d1[id1]=true;d2[id2]=true;
			helper(row+1,col,d1,d2,n);
			col[i]=false;d1[id1]=false;d2[id2]=false;
		}
		
	}

	private static boolean isValid(char[][] board, int x, int y) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < y; j++) {
				if(board[i][j]=='Q' && ((i-j)==(x-y)||(i+j)==(x+y)||(x==i)))
					return false;
			}
		}
		return true;
		
	}

}
