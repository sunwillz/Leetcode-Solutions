package leetcode;

import java.util.ArrayList;
import java.util.List;


public class NumberofDigitOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("b:"+(countDigitOne1(9999)-countDigitOne1(1000)));
		System.out.println("正确答案："+(countDigitOne1(4000)+countDigitOne1(500)+countDigitOne1(10)+countDigitOne1(8)));
		//System.out.println(countDigitOne(314826));
	}
	public static int countDigitOne(int n){
		int count=0;//n的位数
		int tmp=n;
		int result1=0;
		while(tmp!=0){
			tmp=tmp/10;
			count++;
		}
		result1+=(count-1)*Math.pow(10, count-2);
		System.out.println(result1);
		int result2=0;
	
		return result1+result2;
	}
	public static int countDigitOne1(int n) {
        int count=0;
		for (int i = 1; i <= n; i++) {
			int tmp = i;
			while(tmp!=0){
				if(tmp%10==1) count++;
				tmp=tmp/10;
			}
		}
		return count;
    }
}
