package leetcode;


public class Program200 {

	public static void main(String[] args) {
		char[][] board = {{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'},
		};
		System.out.println(numIslands(board));
		
	}
	public static int numIslands(char[][] board){
		if(board==null || board.length==0) 
			return 0;
		int result = 0;
		int row = board.length, column = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(board[i][j]=='1'){
					dfs(board,i,j);
					result++;
				}
			}
		}
		return result;
	}
	private static void dfs(char[][] board, int i, int j) {
		if(i<0 || j<0 || i>=board.length || j>=board[0].length)
			return ;
		if(board[i][j]=='1'){
			board[i][j]='2';
		  dfs(board,i-1,j);
		  dfs(board,i+1,j);
		  dfs(board,i,j+1);
		  dfs(board,i,j-1);
		}
	}

}
