package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program36 {

	public static void main(String[] args) {

	}
	public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
		for (int i = 0; i < n; i++) {
			Map<Character,Boolean> rm = new HashMap<Character,Boolean>();
			Map<Character,Boolean> cm = new HashMap<Character,Boolean>();
			Map<Character,Boolean> sm = new HashMap<Character,Boolean>();
			
			for (int j = 0; j < n; j++) {
				if(board[i][j]!='.'){
					if(rm.containsKey(board[i][j])&&rm.get(board[i][j])==true)
						return false;
					rm.put(board[i][j], true);
				}
				if(board[j][i]!='.'){
					if(cm.containsKey(board[j][i])&&cm.get(board[j][i])==true)
						return false;
					cm.put(board[j][i], true);
				}
				if(board[i/3*3+j/3][i%3*3+j%3]!='.'){
					if(sm.containsKey(board[i/3*3+j/3][i%3*3+j%3])&&sm.get(board[i/3*3+j/3][i%3*3+j%3])==true)
						return false;
					sm.put(board[i/3*3+j/3][i%3*3+j%3], true);
				}
			}
		}
		return true;
    }

}
