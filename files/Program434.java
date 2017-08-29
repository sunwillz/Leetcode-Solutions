package leetcode;

import java.util.Arrays;

public class Program434 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(" Hello, my name is John".split(" +")));
	}
    public int countSegments(String s) {
    		return ("x " + s).split(" +").length - 1;
    }	

}
