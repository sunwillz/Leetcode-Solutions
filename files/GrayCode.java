package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		System.out.println(2^3);
		System.out.println(grayCode(4).toString());
	}
	public static List<Integer> grayCode(int n){
		
		List<Integer> res = new ArrayList<Integer>();
		 int num = 1<<n;  
		 System.out.println(num);
	     int i = 0;  
	     while(i<num)  
	            res.add((i>>1)^(i++));  
	     return res; 
	}

}
