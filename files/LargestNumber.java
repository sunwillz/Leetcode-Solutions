package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LargestNumber {

	public static void main(String[] args) {
		int[] nums={999999998,999999997,999999999};
		System.out.println(fun(120,23));
		/*List<Integer> a = new ArrayList<Integer>();  
        a.add(1);  
        a.add(2);  
        a.add(3);  
        a.add(4);  
        a.add(5);  
          
        List<List<Integer>> resList = cal(a); 
        StringBuffer sb = new StringBuffer();
        int max=0;
        int temp=0;
        for (List<Integer> intList : resList) {  
            for (Integer i : intList) {  
            	temp=Integer.valueOf(sb.append(i).toString());
            }  
            sb.setLength(0);
            System.out.println(temp);
            max=Math.max(temp, max);
        }  
        System.out.println("最大："+max);*/
		System.out.println(largestNumber(nums));
	}
	   
    public static List<List<Integer>> cal(List<Integer> a) {  
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        int size = a.size();  
        List<Integer> temp = null;  
        if(size == 2) {  
            temp = new ArrayList<Integer>(2);  
            temp.add(a.get(0));  
            temp.add(a.get(1));  
            res.add(temp);  
              
            temp = new ArrayList<Integer>(2);  
            temp.add(a.get(1));  
            temp.add(a.get(0));  
            res.add(temp);  
        } else if(size > 2) {  
            List<List<Integer>> tempRes = null;  
            Integer firstNum = null;  
            List<Integer> tempPar = null;  
            for(int i=0; i<size; i++) {  
                firstNum = a.get(i);  
                tempPar = new ArrayList<Integer>(a);  
                tempPar.remove(i);  
                tempRes = cal(tempPar);  
                if(tempRes != null && tempRes.size() > 0) {  
                    for (List<Integer> intList : tempRes) {  
                        intList.add(0, firstNum);  
                        res.add(intList);  
                    }  
                }  
                  
            }  
        }  
          
        return res;  
    }  
	 public static String largestNumber(int[] nums) {
		  Integer[] array = new Integer[nums.length];  
	        int i = 0;  
	        for (int value : nums) {  
	            array[i++] = Integer.valueOf(value);  
	        }         
	          
	        Arrays.sort(array, new Comparator<Integer>() {  
	            @Override  
	            public int compare(Integer a1, Integer a2) {  
	                int l1 = a1==0? 1 :  (int) Math.log10(Math.abs(a1)) + 1;  
	                int l2 = a2==0? 1 :  (int) Math.log10(Math.abs(a2)) + 1;  
	                  
	                long aa1 = (long) (a1 * Math.pow(10, l2) + a2);  
	                long aa2 = (long) (a2 * Math.pow(10, l1) + a1);  
	                  
	                return (int) (aa1-aa2);  
	            }  
	        }  
	                );  
	        StringBuilder sb = new StringBuilder();  
	        for(Integer e : array) {  
	            sb.append(e);  
	        }  
	        return sb.toString().replaceFirst("^0+(?!$)", ""); 
	    }
	 public static long fun(Integer a1,Integer a2){
		 int l1 = a1==0? 1 :  (int) Math.log10(Math.abs(a1)) + 1;  
         int l2 = a2==0? 1 :  (int) Math.log10(Math.abs(a2)) + 1;  
         //System.out.println(l2);
          // System.out.println(Math.pow(10, l2));
         long aa1 = (long) (a1 * Math.pow(10, l2) + a2);  
         long aa2 = (long) (a2 * Math.pow(10, l1) + a1); 
         return aa1;
	 }
}
class Cmp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		String ab = o1.concat(o2);
		String ba = o2.concat(o1);
		return Integer.parseInt(ba)-Integer.parseInt(ab);
	}
	
}
