package leetcode;

import java.util.Arrays;

public class Program605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        int len = flowerbed.length;
        boolean[] bool = new boolean[len];
        Arrays.fill(bool, true);
        for (int i = 0; i < len; i++) {
			if(flowerbed[i]==1) {
				bool[i]=false;
				if(i+1<len) bool[i+1] = false;
				if(i-1>=0) bool[i-1] = false;
			}
		}
        for (int i = 0; i < bool.length; i++) {
			if(bool[i]) {
				sum++;
				if(i-1>=0) bool[i-1] = false;
				if(i+1<len) bool[i+1] = false;
			}
		}
        return sum>=n?true:false;
    }
}
