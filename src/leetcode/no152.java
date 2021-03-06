package leetcode;

public class no152 {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[n+1][2];//二维的第一个代表正数，第二个代表负数
        dp[0][0]=1;dp[0][1]=-1;
        for(int i=1;i<=n;i++)
        {
            if(nums[i-1]>0)
            {
                dp[i][0]=dp[i-1][0]*nums[i-1];
                dp[i][1]=dp[i-1][1]*nums[i-1];
            }
            else if(nums[i-1]<0)
            {
                dp[i][0]=dp[i-1][1]*nums[i-1];
                dp[i][1]=dp[i-1][0]*nums[i-1];
            }
            else
            {
                dp[i][0]=1;dp[i][1]=-1;
            }
            max=Math.max(max,dp[i][0]);
        }
        return max;
    }
    public static void main(String[] args)
    {
        no152 t=new no152();
        t.maxProduct(new int[]{2,3,-2,4});
    }
}
