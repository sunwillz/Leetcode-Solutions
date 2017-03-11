package leetcode;

public class Program79 {

	public static void main(String[] args) {
		char[][]board={
		               {'A','B','C','E'},
		               {'S','F','C','S'},
		               {'A','D','E','E'}
					};
		String word = "ABFDE";
		System.out.println(exist(board, word));
		
	}
	public static boolean exist(char [][]board,String word){
		char[] w = word.toCharArray();
		boolean[][] isvisit = new boolean[board.length][board[0].length];
	    for (int y=0; y<board.length; y++) {
	    	for (int x=0; x<board[y].length; x++) {
	    		if (board[x][y]==w[0] &&dfs(board, x, y, w, 0,isvisit)) return true;
	    	}
	    }
	    return false;
	}
	private static boolean dfs(char[][] board, int x, int y, char[] word, int idx, boolean[][] isvisit) {
		if(idx==word.length) return true;
		if(x<0 || y<0 || x==board.length || y==board[x].length ||word[idx] !=board[x][y]) return false;
		isvisit[x][y]=true;
		if(dfs(board,x+1,y,word,idx+1,isvisit) 
				||dfs(board,x-1,y,word,idx+1,isvisit)
				||dfs(board,x,y+1,word,idx+1,isvisit)
				||dfs(board,x,y-1,word,idx+1,isvisit))
			return true;
		isvisit[x][y]=false;
		return false;
		
	}

}
