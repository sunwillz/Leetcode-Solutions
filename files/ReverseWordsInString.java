package leetcode;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="   a   b ";
		System.out.println(reverseWords(str).length());
	}
	public static String reverseWords(String s) {
		String[] arr= s.split("\\s+");
		StringBuffer sb = new StringBuffer();
		
		for (int i = arr.length-1; i>=0; i--) {
			sb.append(arr[i]+" ");
		}
		return sb.toString().trim();
		
    }

}
