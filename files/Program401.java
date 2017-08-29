package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Program401 {

	public static void main(String[] args) {

	}
    public static List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<String>();
        for (int h = 0; h < 12; h++) {
        		for(int m=0;m<60;m++){
        			if(Integer.bitCount(64*h+m)==num)
        				ret.add(String.format("%d:%02d", h,m));
        		}
		}
        return ret;
    }

}
