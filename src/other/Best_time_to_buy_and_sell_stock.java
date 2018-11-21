package other;

/**
 * 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。
 * 设计一种算法来找到最大利润。您最多可以完成两个交易。
 */
public class Best_time_to_buy_and_sell_stock {

    public static void main(String[] args){
        int[] prices = {1,2,5,2,6,1,4,7};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE,buy2 = Integer.MIN_VALUE;
        int sell1 = 0,sell2 = 0;
        for (int i=0;i<prices.length;i++){
            //第一次买选择最低的股价
            buy1 = Math.max(buy1,-prices[i]);
            //第一次买的收益 要最大
            sell1 = Math.max(sell1,buy1+prices[i]);
            //第二次买 找最低的股价
            buy2 = Math.max(buy2,sell1-prices[i]);
            //第二次卖的收益最高
            sell2 = Math.max(sell2,prices[i]+buy2);
        }
        return sell2;
    }


}
