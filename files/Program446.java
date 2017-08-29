package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author sunwill
 * 求一个数组中有多少个子序列是等差序列
 */
public class Program446 {

	public static void main(String[] args) {
			System.out.println(numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
	}
    public static int numberOfArithmeticSlices(int[] A) {
     int ans = 0;
     Map<Integer,Integer>[] map =new HashMap[A.length];
     for (int i = 0; i < A.length; i++) {
    	 	map[i] = new HashMap<>();
		for (int j = 0; j <i; j++) {
			int diff = A[i]-A[j];
			if(!map[i].containsKey(diff))
				map[i].put(diff, 0);
			map[i].put(diff, map[i].get(diff)+1);
			if(map[j].containsKey(diff)){
				map[i].put(diff, map[i].get(diff)+map[j].get(diff));
				ans +=map[j].get(diff); 
			}
		}
	}
     return ans;
    }
    public static int numberOfArithmeticSlices1(int[] A){
        int re = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for(int i=0; i<A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for(int j=0; j<i; j++) {
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff,0)+count+1);
                re += count;
            }
        }
        return re;
    }

}
