package leetcode;

public class Program495 {
	public static void main(String[] args) {
		System.out.println(findPoisonedDuration(new int[]{1,2,4,9,10}, 2));
	}
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int n = timeSeries.length;
        for (int i = 0; i < n; i++) {
			int end = timeSeries[i]+duration;
			if(i<n-1&&end<=timeSeries[i+1]) ans+= duration;
			else if(i<n-1&&end>timeSeries[i+1]) ans+=timeSeries[i+1]-timeSeries[i];
			else{
				ans+=duration;
			}
		}
        return ans;
    }
}
