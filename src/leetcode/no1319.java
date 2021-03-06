package leetcode;

import java.util.Arrays;

public class no1319 {
    public int makeConnected(int n, int[][] connections) {
        Unionset un = new Unionset(n);
        // boolean[] flag = new boolean[n];
        int count = 0;
        for(int i=0; i<connections.length;i++)
            if(un.Union(connections[i][0],connections[i][1]))
        count++;
        int result = 0;
        for(int i= 0 ;i<n-1;i++)
            if(!un.Union(i,i+1))
            {
                result++;
                count--;
            }
        if(count<0)
            return -1;
        else
            return result;
    }
    class Unionset{
        int[] parent;
        int[] rank;
        public Unionset(int n)
        {
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            for(int i=0; i<n;i++)
                this.parent[i] = i;
        }
        public int find(int x)
        {
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean Union(int x, int y)
        {
            int rx = find(x);
            int ry = find(y);
            if(rx==ry)
                return true;
            if(rank[rx]<rank[ry])
            {
                int temp = rx;
                rx = ry;
                ry = temp;
            }
            rank[rx]+=rank[ry];
            parent[ry] = rx;
            return false;
        }
    }
    public static void main(String[] args)
    {
        no1319 t = new no1319();
        int[][] p  = new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}};
        t.makeConnected(6,p);
    }
}
