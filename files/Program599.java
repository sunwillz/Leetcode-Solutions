package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program599 {

	public static void main(String[] args) {

	}
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        int minIndexSum = Integer.MAX_VALUE;
        List<String> list  = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
			map.put(list1[i],i);
		}
        for (int i = 0; i < list2.length; i++) {
			if(map.containsKey(list2[i])){
				int j = map.get(list2[i]);
				if(i+j<=minIndexSum){
					if(i+j<minIndexSum){
						minIndexSum = i+j;
						list = new ArrayList<>();
					}
					list.add(list2[i]);
				}
			}
		}
        return list.toArray(new String[list.size()]);
    }

}
