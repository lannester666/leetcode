package leetcode;

import java.util.Scanner;

public class no_474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] value = new int[m+1][n+1];
        int[][] num=new int[strs.length][2];
        for(int i=0;i< strs.length;i++)
        {
            for(int j=0;j<strs[i].length();j++)
                if(strs[i].charAt(j)=='0')
                    num[i][0]++;
                else
                    num[i][1]++;
        }

        for(int i=0;i< strs.length;i++) {
            int bound;
            int max=m;
            for(int q= strs.length-1;q>i;q--)
                max-=num[q][0];
            bound = Math.max(max,num[i][0]);
            for (int j = m; j >= bound; j--)//m为0，n为1
            {
                max=n;
                for(int q= strs.length-1;q>i;q--)
                    max-=num[q][1];
                int bound1= Math.max(max,num[i][1]);
                for (int k = n; k >= bound1; k--)
                    if (j - num[i][0] >= 0 && k - num[i][1] >= 0)
                        value[j][k] = Math.max(value[j][k], value[j - num[i][0]][k - num[i][1]] + 1);
            }
        }
                    int max=0;
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
              max=Math.max(max,value[i][j]);
            return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] strs = new String[num];
        for(int i=0;i<num;i++)
            strs[i] = scanner.next();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(strs.length);
        int p = findMaxForm(strs,m,n);
        System.out.println(p);
    }
}
