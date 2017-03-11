package leetcode;

public class Program397 {

	public static void main(String[] args) {
//		System.out.println(12>>>1);
		System.out.println(integerReplacement(13));
	}
	public static int integerReplacement(int n) {
        int ret=0;
		while(n!=1){
			if((n&1)==0){
				n >>>=1;
			}else if(n==3||Integer.bitCount(n+1)>Integer.bitCount(n-1)){
				n--;
			}else{
				n++;
			}
			ret++;
		}
		
		return ret;
    }
	private static int helper(int n, int k) {
		System.out.println(n);
		if(n==1) return k;
		if(n%2==0){
			return helper(n/2,k++);
		}else{
			return Math.min(helper(n-1,k++),helper(n+1,k++));
		}
	}
}
