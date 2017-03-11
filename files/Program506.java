package leetcode;

import java.util.Arrays;


public class Program506 {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(findRelativeRanks(new int[]{123123,11921,1,0,123})));
	}
	public static String[] findRelativeRanks(int[] nums){
		int len = nums.length;
		if(len==1){
			return new String[]{"Gold Model"};
		}
		if(len==2){
			if(nums[0]>nums[1])
				return new String[]{"Gold Model","Silver Model"};
			else
				return new String[]{"Silver Model","Gold Model"};
		}
		String[] ret = new String[len];
		int[] idx = find(nums,len);
		for (int i = 0; i < idx.length; i++) {
			ret[idx[i]] = String.valueOf(i+1);
		}
		ret[idx[0]]="Gold Medal";
		ret[idx[1]]="Silver Medal";
		ret[idx[2]]="Bronze Medal";
		return ret;
	}
	public static int[] find(int[] nums,int cnt){
		int out[] = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			int k = -1;
			for (int j = 0; j < cnt; j++) {
				if (k < nums[j]) {
					k = nums[j];
					out[i] = j;
				}
			}
			nums[out[i]] = -1;
		}
		return out;
	}
	public static int[] findIndex(int[] nums,int cnt){
		int[] tn = new int[cnt];
		boolean[] flag = new boolean[cnt];
		for (int i = 0; i < cnt; i++) {
			int temp = 0;
			for (int j = 0; j < nums.length; j++) {
				if(temp<nums[j] && !flag[j]){
					temp = nums[j];
					tn[i] = j;
				}
			}
			flag[tn[i]] = true;
		}
		/*for (int i = 3; i < nums.length; i++) {
			if(nums[i]>=nums[tn[2]]){//大于等于第三大的数
				if(nums[i]>=nums[tn[1]]){//大于等于第二大的数
					if(nums[i]>=nums[tn[0]]){//大于等于第一大的数
						tn[2] = tn[1];
						tn[1] = tn[0];
						tn[0] = i;
					}else{
						tn[2] = tn[1];
						tn[1] = i;
					}
				}else{
					tn[2] = i;
				}
			}
		}*/
		return tn;
	}

}
