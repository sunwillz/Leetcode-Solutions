package leetcode;

public class IsSelfCrossing {

	public static void main(String[] args) {
	int[] arr={3,3,3,2,1,1};
	System.out.println(isSelfCrossing(arr));
	}
	public static boolean isSelfCrossing(int[] x) {
        if(x.length<4) return false;
		for (int i = 3; i < x.length; i++) {
			if(x[i]>=x[i-2] && x[i-3]>=x[i-1]) return true;
			if(i>=4 && x[i-1]==x[i-3] && x[i-2]<=x[i]+x[i-4]) return true;
			if( i>=5 && x[i-2]>=x[i-4] && x[i-3]>=x[i-1] && x[i-2]<=x[i]+x[i-4] && x[i-3]<=x[i-1]+x[i-5])return true;
		}
		return false;
    }
}
