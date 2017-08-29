package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Program649 {
	public static void main(String[] args) {
		System.out.println(predictPartyVictory("DDRRRR"));
	}
    public static String predictPartyVictory(String senate) {
    		int n =senate.length();
    		Queue<Integer> r = new LinkedList<Integer>();
    		Queue<Integer> d = new LinkedList<Integer>();
    		for (int i = 0; i < senate.length(); i++) {
				if(senate.charAt(i)=='R')r.add(i);
				else d.add(i);
			}
    		while(!r.isEmpty()&&!d.isEmpty()){
    			int r_index = r.poll();
    			int d_index = d.poll();
    			if(r_index<d_index) r.add(r_index+n);
    			else d.add(d_index+n);
    		}
    		return r.size()>d.size()?"Radiant":"Dire";
    }
    public String predictPartyVictory1(String senate) {
        int r = 0, d = 0, start = 0;
        char[] arr = senate.toCharArray();
        for (char c : arr) {
            if (c == 'R') r++;
            else d++;
        }
        
        while (r > 0 && d > 0) {
            while (arr[start] != 'R' && arr[start] != 'D') {
                start = (start + 1) % arr.length;
            }
            
            char ban = 'R';
            if (arr[start] == 'R') {
                ban = 'D';
                d--;
            }
            else {
                r--;
            }
            int idx = (start + 1) % arr.length;
            while (arr[idx] != ban) {
                idx = (idx + 1) % arr.length;
            }
            
            arr[idx] = ' ';
            start = (start + 1) % arr.length;
        }
        
        return d == 0 ? "Radiant" : "Dire";
    }
}
