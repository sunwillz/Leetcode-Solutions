package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Program403 {

	public static void main(String[] args) {
		int[] stones = {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}
	public static boolean canCross(int[] stones) {
		if(stones[1]>1) return false;
		if(stones.length==2) return true;
		return helper(stones,1,1);
	}
	private static boolean helper(int[] stones, int i, int step) {
		boolean flag=  false;
		if(i==stones.length-1) return true;
		for (int j = i+1; j < stones.length; j++) {
			if(stones[j] <= stones[i] + step + 1 && stones[j] >= stones[i]+step-1)
				flag = flag || helper(stones,j,stones[j]-stones[i]);
		}
		return flag;
	}
	public static boolean canCross1(int[] stones) {
		boolean[] ret = new boolean[stones.length];
		ret[0] = true;
		Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>(); 
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}
		if(stones[1]==stones[0]+1){
			ret[1]=true;
			map.get(stones[1]).add(1);
		}
		for (int i = 2; i < stones.length; i++) {
			for (int j = 0; j < i; j++) {
				Set<Integer> tpset = map.get(stones[j]);
					for (Integer inte : tpset) {
						if(ret[j] && (inte+stones[j]==stones[i] || inte-1+stones[j]==stones[i]||inte+1+stones[j]==stones[i])){
							ret[i]=true;
							if(inte+stones[j]==stones[i]){
								map.get(stones[i]).add(inte);
							}
							else if(inte-1+stones[j]==stones[i]){
								map.get(stones[i]).add(inte-1);
							}else
								map.get(stones[i]).add(inte+1);
						}
					}
			}
		}
		System.out.println(Arrays.toString(ret));
        return ret[stones.length-1];
    }
}
