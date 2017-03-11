package leetcode;

public class WaterAndJugProblem {

	public static void main(String[] args) {
		
		System.out.println(canMeasureWater(2,6,4));
	}
	public static  boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        if(z==0) return true;
        return z%gcd(x,y)==0;
        
    }
	public static int gcd(int x, int y){
		if(y==0 ) return x;
		if(x==0) return y;
 		while(x!=y){
		if(x>y) x=x-y;
		if(y>x) y=y-x;
		}
		return y==0?x:y;
	}
}
