package leetcode;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int countPrimes(int n) {
	     if(n<=2) return 0;
	     boolean[] p = new boolean[n];
	     for (int i = 2; i < p.length; i++) {
			p[i]=true;
		}
	     for (int i = 2; i*i <n ; i++) {
			if(p[i]){
				for (int j = i+i; j < n; j+=i) {
					p[j]=false;
				}
			}
		}
	     
	     int cunt=0;
	     for (int i = 2; i < n; i++) {
			if(p[i]) cunt++;
		}
	     return cunt; 
	 }
}
