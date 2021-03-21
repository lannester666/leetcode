package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no54 {
    int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int n=matrix.length,m=matrix[0].length;
        int count=m*n;
        boolean[][] flag=new boolean[n][m];
        int now = 0,x=0,y=0,px=0,py=0;
        while(count>0)
        {
            if(x>=0&&x<n&&y>=0&&y<m&&!flag[x][y])
            {
                res.add(matrix[y][x]);
                flag[x][y]=true;
                px=x;py=y;
                x+=dir[now][0];y+=dir[now][1];
                count--;
            }
            else{
                x=px;y=py;
                if(now==3)
                    now=0;
                else
                    now++;
                x+=dir[now][0];y+=dir[now][1];
            }
        }
        System.out.println(res);
        return res;
    }
    public static void main(String[] args)
    {
        no54 t=new no54();
        t.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }
}
