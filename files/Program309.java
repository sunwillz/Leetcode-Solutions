package leetcode;

public class Program309 {
    public int maxProfit(int[] prices) {
        int cell = 0,pre_cell = 0,buy = Integer.MIN_VALUE,pre_buy ;
        for (int price : prices) {
			pre_buy = buy;
			buy = Math.max(pre_buy, pre_cell-price);
			pre_cell = cell;
			cell = Math.max(pre_cell,pre_buy+price );
		}
        return cell;
    }
}
