package leetcode;

public class no_714 {
    public static int maxProfit(int[] prices, int fee) {
        int[] sub = new int[prices.length];
        for(int i=1;i<prices.length;i++)
        {
            sub[i-1] = prices[i] - prices[i-1];
        }
        int flag = 0;
        int end = 0;
        int value = 0;
        int total_value = 0;
        int max_val = 0;
        while(end<prices.length-1)
        {
            if(max_val>fee&&value<fee)
            {
                value = 0;
                total_value+=(max_val-fee);
                max_val = 0;
            }
            if(sub[end]>0)
            {
                value+=sub[end];
            }
            else if(sub[end]<-fee)
            {
                if(value>fee)
                {
                    total_value+=(value-fee);
                    value = 0;
                }
                else
                    value = 0;
            }
            else
            {
                max_val = Math.max(value, max_val);
                value+=sub[end];
            }
            end++;
        }
        value = Math.max(value, max_val);
        if(value>fee)
            total_value+=(value-fee);
        return total_value;
    }
    public static void main(String[] args)
    {
        int[] prices = new int[]{1,2,1,5,3,5,5,4,1,5};
        int fee = 0;
        int total = maxProfit(prices, fee);

    }
}
