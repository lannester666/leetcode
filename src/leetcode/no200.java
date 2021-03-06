package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class no200 {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Unionset un=new Unionset(m*n);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    if(i-1>=0&&grid[i-1][j]==1)
                        un.union((i-1)*n+j,i*n+j);
                    if(j>0&&grid[i][j-1]=='1')
                        un.union(i*n+j-1,i*n+j);
                }
            }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='0')
                    continue;
                int temp=un.find(i*n+j);
                if(!map.containsKey(temp))
                    map.put(temp,1);
            }
        return map.size();
    }
    class Unionset{
        int[] parent;
        int[] rank;
        public Unionset(int n){
            this.parent=new int[n];
            this.rank=new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
            Arrays.fill(rank,1);
        }
        int find(int x)
        {
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }
        public boolean union(int x,int y)
        {
            int rx=find(x);
            int ry=find(y);
            if(rx==ry)
                return true;
            if(rank[rx]<rank[ry])
            {
                int temp=rx;
                rx=ry;
                ry=temp;
            }
            rank[rx]+=rank[ry];
            parent[ry]=rx;
            return false;
        }
    }
    public static void main(String[] args)
    {
        no200 t=new no200();
        t.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
    }
}
