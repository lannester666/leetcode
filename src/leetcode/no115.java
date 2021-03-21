package leetcode;

public class no115 {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m)
            return 0;
        if(m==0)
            return 1;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        dp[i][0]=1;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(j>i)
                    break;
                if(s.charAt(i)==t.charAt(j))
                    dp[i+1][j+1]=dp[i][j]+dp[i][j+1];
                else
                    dp[i][j+1]=dp[i][j];
            }
        System.out.println(dp[n][m]);
        return dp[n][m];
    }
    public static void main(String[] args)
    {
        no115 t=new no115();
        t.numDistinct("babgbag","bag");
    }
}
