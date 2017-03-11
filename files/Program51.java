package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyangwei
 *N-queue问题
 */
public class Program51 {

	public static void main(String[] args) {

	}
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j]='.';
			}
		}
        solve(board,0,ret);
        return ret;
    }
	private static void solve(char[][] board, int colIndex, List<List<String>> ret) {
		for (int i = 0; i < board.length; i++) {
			if(colIndex==board.length){
				ret.add(convert(board));
				return;
			}
			if(isValid(board,i,colIndex)){
				board[i][colIndex] = 'Q';
				solve(board,colIndex+1,ret);
				board[i][colIndex] = '.';
			}
			
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
	private static List<String> convert(char[][] board) {
		List<String> ret = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String str = "";
			for (int j = 0; j < board.length; j++) {
				str +=board[i][j];
			}
			ret.add(str);
		}
		return ret;
	}

}
