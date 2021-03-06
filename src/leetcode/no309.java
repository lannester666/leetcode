package leetcode;

public class no309 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1)
            return 0;
        int[][] dp=new int[n][2];
        dp[0][0]=0;dp[0][1]=0;
        dp[1][0]=prices[1]-prices[0];dp[1][1]=0;
        for(int i=2;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(j+2<i)
                {
                    dp[i][0]=Math.max(dp[i][0],Math.max(dp[j][0]+prices[i]-prices[j+2],dp[j][1]+prices[i]-prices[j]));
                    dp[i][1]=Math.max(dp[i-2][0],dp[i-1][1]);
                }
                else
                {
                    dp[i][0]=Math.max(dp[i][0],dp[j][1]+prices[i]-prices[j]);
                    dp[i][1]=Math.max(dp[i-2][0],dp[i-1][1]);
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++)
            res=Math.max(res,Math.max(dp[i][0],dp[i][1]));
        System.out.println(res);
        return res;
    }
    public static void main(String[] args)
    {
        no309 t=new no309();
        t.maxProfit(new int[]{6,1,6,4,3,0,2});
    }
}
