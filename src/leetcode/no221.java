package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class no221 {
    int m,n;
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == '1')
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0')
                    continue;
                if (dp[i - 1][j - 1] > 0) {
                    int t = dp[i - 1][j - 1];
                    boolean flag = true;
                    for (int k = i - t; k < i; k++)
                        if (matrix[k][j] == '0') {
                            flag = false;
                            break;
                        }
                    for (int k = j - t; k < j; k++)
                        if (matrix[i][k] == '0') {
                            flag = false;
                            break;
                        }
                    if (flag)
                        dp[i][j] = t + 1;
                }
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res = Math.max(res, dp[i][j]);
        return res * res;
    }
        public static void main(String[] args)
    {
        no221 t=new no221();
        System.out.println(t.maximalSquare(new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}));
    }
}
