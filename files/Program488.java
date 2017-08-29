package leetcode;

public class Program488 {

	public static void main(String[] args) {

	}
	static int ans= 6;
    public static int findMinStep(String board, String hand) {
         int[] handCnt = new int[26];
         for (int i = 0; i < hand.length(); i++) handCnt[hand.charAt(i)-'A']++;
         int ret = helper(board+"#",handCnt);
		 return ret==ans?-1:ret;
    }
	private static int helper(String board, int[] handCnt) {
		board = removeConseBalls(board);
		if(board.equals("#")) return 0;
		int ret = ans,need = 0;
		for (int i = 0,j=0; j < board.length(); j++) {
			if(board.charAt(j)==board.charAt(i)) continue;
			need = 3-(j-i);
			if(handCnt[board.charAt(i)-'A']>=need){
				handCnt[board.charAt(i)-'A']-=need;
				ret = Math.min(ret, need+helper(board.substring(0,i)+board.substring(j),handCnt));
				handCnt[board.charAt(i)-'A']+=need;
			}
			i=j;
		}
		return ret;
	}
	private static String removeConseBalls(String board) {
		for (int i =0,j = 0; j < board.length(); j++) {
			if(board.charAt(j)==board.charAt(i)) continue;
			if((j-i)>=3) return removeConseBalls(board.substring(0,i)+board.substring(j));
			else i=j;
		}
		return board;
	}
}
