package leetcode;

public class Program507 {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
	
		System.out.println(checkPerfectNumber(1200131));
		System.out.println(System.currentTimeMillis()-a);
	}
    public static boolean checkPerfectNumber(int num) {
    		if(num==1) return false;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i==0) sum+=i+num/i;
		}
        return num==sum+1;
    }

}
