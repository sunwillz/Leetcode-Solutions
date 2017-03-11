package leetcode;

import java.util.Arrays;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
	/*	Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		int[] t = new int[s.length];
		for (int i = 0; i < s.length; i++) 
			t[i] = Integer.parseInt(s[i]);
		System.out.println("数组为："+Arrays.toString(t));*/
		System.out.println("请输入数据组数：");
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();//数据组数
		in.nextLine();
		while (T-->0) {
			System.out.println("请输入n和k的值：");
			String[] s = in.nextLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			System.out.println("请输入牌的序列：");
			int[] array = new int[2*n];
			array= helper(in);
			System.out.println(Arrays.toString(getOrder(n,k,array)));
		}
	}

	private static int[] helper(Scanner in) {
		String[] s = in.nextLine().split(" ");
		int[] t = new int[s.length];
		for (int i = 0; i < s.length; i++) 
			t[i] = Integer.parseInt(s[i]);
		return t;
	}

	private static int[] getOrder(int n,int k, int[] array) {
		int[] result = new int[2*n];
		int nk = k%n==0?n:k%n;
		int m;
		for(int i=0;i<nk;i++){
			m=0;
			for (int j = 0; j < n; j++) {
				result[m++] = array[j];
				result[m++] = array[j+n];
			}
			for (int j1 = 0; j1 < result.length; j1++) {
				array[j1] = result[j1];
			}
		}
		return array;
	}

}
