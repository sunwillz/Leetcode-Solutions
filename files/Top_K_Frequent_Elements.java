package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Top_K_Frequent_Elements {

	public static void main(String[] args) {
		int[] arr={1,1,1,1,4,4,4,2,3};
		int k=2;
		System.out.println(topKRequent(arr, k).toString());
	}
	public static List<Integer> topKRequent(int[] nums,int k){
		List<Integer> result =new ArrayList<Integer>();
		if(nums.length==0 || nums.length<k) return result;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {//将数组元素放入map,对应的value是其出现的次数
			int temp = nums[i];
			if(map.containsKey(temp))
				map.put(temp, map.get(temp)+1);
			else
				map.put(temp, 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());//map集合包装成list，对map中的value进行排序
		
		Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
			
		});
		for (int j=0;j<k;j++) {
			System.out.println(list.get(j).getKey()+" : "+list.get(j).getValue());
			result.add(list.get(j).getKey());
		}
		return result;
	}

}
