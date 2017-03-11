package leetcode;

public class Program37 {

	public static void main(String[] args) {

	}
	public static void solveSudoku(char[][] board) {
        if(board==null||board.length==0)return;
        solve(board);
	}
	private static boolean solve(char[][] board) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j]=='.'){
					for (char c = '1'; c <= '9'; c++) {
						if(isValid(board,i,j,c)){
							board[i][j] = c;
							
							if(solve(board))
								return true;
							else
								board[i][j]='.';
						}
					}
					return false;
				}
			}
		}
		
		return true;
	}
	private static boolean isValid(char[][] board, int row, int col, char c) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			if(board[i][col]!='.' && board[i][col]==c) return false;
			if(board[row][i]!='.' && board[row][i]==c) return false;
			if(board[row/3*3+col/3][row%3*3+col%3]!='.'&&board[row/3*3+col/3][row%3*3+col%3]==c)return false;
		}
		return true;
	}

}
