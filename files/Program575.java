package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Program575 {

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[]{1,1,2,3,4,4}));
	}
    public static int distributeCandies(int[] candies) {
       int ans = 0;
       int len = candies.length; 
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       for (int i : candies) {
		if(!map.containsKey(i))
			map.put(i, 0);
		map.put(i,map.get(i)+1);
	}
       if(len/2>=map.size()){
    	   		ans = map.size();
       }else{
    	   		ans = len/2;
       }
       return ans;
    }

}
