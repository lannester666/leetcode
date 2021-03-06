package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class n_queen {
    public static Integer count=0;
    public static void trace(int n, int[][] p, int i, int j, Stack<int[][]> choose, Stack<Integer> choose1)
    {
        int[][] m=new int[n][];
        for(int q=0;q<n;q++)
            m[q]=choose.peek()[q].clone();
        if(i<0||i>=n||j<0||j>=n||m[i][j]==-1)
            return;
        if(i==n-1)
        {
            count++;
            choose1.push(j);
            Stack<Integer> temp1 = (Stack<Integer>) choose1.clone();
            Stack<Integer> temp = new Stack<>() ;
            char[][] c = new char[n][n];
            while(!temp1.isEmpty())
                temp.push(temp1.pop());
            for(int i1=0;i1<n;i1++)
                for (int i2 = 0; i2 < n; i2++)
                    c[i1][i2]='.';
                int q=0;
                while(!temp.isEmpty())
                {
                    c[q++][temp.pop()]='Q';
                }
               for(int i1=0;i1<n;i1++) {
                   for (int j1 = 0; j1 < n; j1++)
                       System.out.print(c[i1][j1]);
                   System.out.println();
               }
            return;
        }
        choose1.push(j);
        for(int t=0;t<n;t++)
        {
            m[i][t] = -1;
            m[t][j] = -1;
        }
        int i1,i2,j1,j2;
        i1=i2=i;j1=j2=j;
      while(i1<n&&j1>=0)
      {m[i1++][j1--]=-1;}
        while(i2>=0&&j2<n)
        {m[i2--][j2++]=-1;}
        int temp = i-j;
        if(temp>0)
        {
            int starti = temp;
            int startj = 0;
            while(starti<n)
                m[starti++][startj++]=-1;
        }
        else{
            int starti = 0;
            int startj = -temp;
            while(startj<n)
                m[starti++][startj++]=-1;
        }
        choose.push(m);
        for(int t = 0;t<n;t++)
        {
            if(!choose1.contains(t))
           {
                trace(n, p, i + 1, t, choose, choose1);
           }
        }
        choose.pop();
        choose1.pop();
    }
    public static void main(String[] args)
    {
        List<List<String>> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] p = new int[n][n];
        for(int i=0;i<n;i++) {
            Stack<int[][]> choose = new Stack<>();
            Stack<Integer> choose1 = new Stack<>();
            choose.push(p);
            trace(n, p, 0, i, choose, choose1);
        }
        System.out.println(count);
    }
}
