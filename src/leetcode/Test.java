package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
        public static void pondSizes(int[][] land) {
            boolean[][] marked = new boolean[land.length][land[0].length];
            ArrayList<Integer> num = new ArrayList<>();
            for(int i=0;i<land.length;i++)
                for(int j=0;j<land.length;j++)
                    marked[i][j] = false;
            for(int i=0;i<land.length;i++)
                for(int j=0;j<land[i].length;j++)
                    if(land[i][j]==0&&!marked[i][j])
                        num.add(dfs(marked,land,i,j));
            int[] n = new int[num.size()];
            for(int i=0;i<num.size();i++)
                n[i] = num.get(i);
            Arrays.sort(n);
           for(int i:n)
               System.out.println(i);
        }
        public static int dfs(boolean[][] w, int[][] land, int row, int col)
        {
            if(row>=land.length||col>=land[0].length||col<0||row<0||land[row][col]!=0 )
                return 0;
            if(w[row][col])
                return 0;
            w[row][col] = true;
            int count=1;
            count+=dfs(w,land,row+1,col+1);
            count+=dfs(w,land,row+1,col);
            count+=dfs(w,land,row,col+1);
            count+=dfs(w,land,row+1,col-1);
            count+=dfs(w,land,row-1,col);
            count+=dfs(w,land,row-1,col-1);
            count+=dfs(w,land,row-1,col+1);
            count+=dfs(w,land,row,col-1);
            return count;
        }
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

       String p="";
       p+='a';
        System.out.println(p);
    }
}
