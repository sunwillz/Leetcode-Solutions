package leetcode;

import java.util.Arrays;

public class Program455 {

	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[]{1, 2},new int[]{1,2,3}));
	}
    public static int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < g.length; i++) {
			int minSize = g[i];
			while(j<s.length&&s[j]<minSize)j++;
			if(j<s.length) {
				ans++;
				j++;
			}
		}
        return ans;
    }
}
