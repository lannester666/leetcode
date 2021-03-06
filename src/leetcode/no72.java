package leetcode;

public class no72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n = word2.length();
        if(m==0||n==0)
            return Math.abs(m-n);
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;dp[0][1]=1;dp[1][0]=1;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                dp[i][j]=Math.abs(i-j);
            }
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                int temp=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                if(word1.charAt(i-1)!=word2.charAt(j-1))
                    dp[i][j]=temp+1;
                else dp[i][j]=temp;
            }
        return dp[m][n];
    }
    public static void main(String[] args)
    {
        no72 t= new no72();
        t.minDistance("ab","bc");
    }
}
