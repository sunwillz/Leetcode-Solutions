package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxSum = 0;
        for (int w : wall.get(0)) {
			maxSum +=w;
		}
        for (List<Integer> list : wall) {
			int sum = 0;
			for (int i : list) {
				sum+=i;
				if(sum>0&&sum<maxSum)
				map.put(sum, map.getOrDefault(sum, 0)+1);
			}
		}
        
        int ans = 0;
        for (int count : map.values()) {
			ans = Math.max(ans, count);
		}
        return wall.size()-ans;
    }
}
