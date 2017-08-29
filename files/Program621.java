package leetcode;

import java.util.Arrays;

public class Program621 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char i : tasks) {
			c[i-'A']++;
		}
        Arrays.sort(c);
        int i = 25;
        while(i>=0&&c[i]==c[25]) i--;
        
        return Math.max(tasks.length,(c[25]-1)*(n+1)+25-i);
    }
}
