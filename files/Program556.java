package leetcode;

import java.util.Arrays;

public class Program556 {
	public static void main(String[] args) {
		
		int i;
		for(i = 5;i>0;i--)
			if(3<2)
			break;
		
		System.out.println(i);
		
	}
    public static int nextGreaterElement(int n) {
    		char[] c = (n+"").toCharArray();
    		int len = c.length;
    		int i,j;
    		for(i = len-1;i>0;i--)
    			if(c[i-1]<c[i])
    				break;
    		
    		if(i==0) return -1;
    		
    		int smallest = i,x = c[i-1];
    		for (j = i+1; j < c.length; j++) {
    				if(c[j]>x&&c[j]<=c[smallest])
    					smallest = j; 
			}
    		char temp = c[smallest];
    		c[smallest] = c[i-1];
    		c[i-1] = temp;
    		Arrays.sort(c,i,c.length);
    		long val = Long.parseLong(new String(c));
    		return val<=Integer.MAX_VALUE?(int)val:-1;
    		
    }

}
