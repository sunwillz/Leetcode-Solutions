package leetcode;

public class Program461 {

	public static void main(String[] args) {
		System.out.println(hammingDistance(2, 4));
	}
	public static int hammingDistance(int x, int y) {
        int ret = 0;
        String xx = Integer.toBinaryString(x);
        String yy = Integer.toBinaryString(y);
        int len = Math.max(xx.length(),yy.length());
        if(xx.length()>yy.length()){
        	String str = "";
        	for(int i=0;i<xx.length()-yy.length();i++)
        		str +="0";
        	yy =str+yy;
        }else{
        	String str = "";
        	for(int i=0;i<yy.length()-xx.length();i++)
        		str +="0";
        	xx =str+xx;
        }
        for(int i=0;i<len;i++){
        	if(xx.charAt(i)!=yy.charAt(i))ret++;
        }
        return ret;
    }
	public static int totalHammingDistance(int[] nums) {
		int ret = 0;
        for (int i = 0; i < 32; i++) {
			int bitcount = 0;
			for (int j = 0; j < nums.length; j++) {
				bitcount +=(nums[j]>>i)&1;
			}
			ret +=bitcount*(nums.length-bitcount);
		}
        return ret;
    }
}
