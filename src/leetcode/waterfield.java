package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class waterfield {
    public static int dfs(boolean[][] w, int[][] land, int row, int col,int m)
    {
        if(land[row][col]!=0)
            return 0;
        if(w[row][col])
            return 0;
        w[row][col] = true;
        int count=1;
        if(row< m-1&&col<m-1)
        count+=dfs(w,land,row+1,col+1,m);
        if(row< m-1) count+=dfs(w,land,row+1,col,m);
        if(col<m-1)
            count+=dfs(w,land,row,col+1,m);
        if(row< m-1&&col>0)
            count+=dfs(w,land,row+1,col-1,m);
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] land = new int[1000][1000];
        ArrayList<Integer> num = new ArrayList<>();
        boolean[][] w = new boolean[m][m];
        int p=1;
        for(int i=0;i<m;i++)
            for(int j=0;j<m;j++)
                land[i][j]=scanner.nextInt();
        for(int i=0;i<m;i++)
            for(int j=0;j<m;j++)
                if (land[i][j] == 0&&!w[i][j]) {
                    num.add(dfs(w, land, i, j,m));
                }
        int[] n = new int[num.size()];
        for(int i=0;i<num.size();i++)
            n[i] = num.get(i);
        Arrays.sort(n);
                for(int i:n)
                    System.out.println(i);

    }
}
