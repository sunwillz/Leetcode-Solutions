package leetcode;

import java.util.LinkedList;
import java.util.List;

public class UglyNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(10));
	}
	public static int nthUglyNumber(int n){
		int p = 0;
		List<Integer> l1 = new LinkedList<Integer>();
		List<Integer> l2 = new LinkedList<Integer>();
		List<Integer> l3 = new LinkedList<Integer>();
		l1.add(1);
		l2.add(2);
		l3.add(3);
		for (int i = 0; i < n; i++) {
			p = Math.min(Math.min(l1.get(0),l2.get(0)),l3.get(0));
			if(p==l1.get(0)) l1.remove(0);
			if(p==l2.get(0)) l2.remove(0);
			if(p==l3.get(0)) l3.remove(0);
			
			l1.add(p*2);
			l2.add(p*3);
			l3.add(p*5);
			
 		}
		return p;
	}
	//最长回文子串
	public static String longestPalindrome(String s) {
        
		for (int i = 0; i < s.length(); i++) {
			
		} 
		
		return "";
    }

}
