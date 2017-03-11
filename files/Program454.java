package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program454 {

	public static void main(String[] args) {
		int[] A = {1,2};
		int[] B = {-2,-1};
		int[] C = {-1,2};
		int[] D = {0,2};
		System.out.println(fourSumCount(A, B, C, D));
	}
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int ret = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i]+D[j];
				int cnt = map.get(sum)==null?0:map.get(sum);
				map.put(sum, cnt+1);
			}
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i]+B[j];
				if(map.containsKey(-sum)){
					ret+=map.get(-sum);
				}
			}
		}
		return ret;
    }

}
