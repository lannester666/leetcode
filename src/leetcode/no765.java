package leetcode;

import java.util.*;

public class no765 {
    public int minSwapsCouples(int[] row) {
        int n=row.length;
        Unionset un = new Unionset(n/2);
        for(int i=0;i<n;i+=2)
            un.union(row[i]/2,row[i+1]/2);
        return n/2-un.count;
    }
    class Unionset
    {
        int[] parent;
        int[] rank;
        int count;
        Unionset(int n)
        {
            this.count=n;
            this.parent=new int[n];
            this.rank=new int[n];
            Arrays.fill(rank,1);
            for(int i=0;i<n;i++)
                this.parent[i]=i;
        }
        public int find(int x)
        {
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }
        public void union(int x,int y)
        {
            int rx=find(x);
            int ry=find(y);
            if(rx==ry)
                return;
            if(rank[rx]<rank[ry])
            {
                int temp=rx;
                rx=ry;
                ry=temp;
            }
            count--;
            rank[rx]+=rank[ry];
            parent[ry]=rx;
        }
    }


    public static void main(String[] args)
    {
        no765 t = new no765();
        System.out.println(t.minSwapsCouples(new int[]{10,7,4,2,3,0,9,11,1,5,6,8}));
    }
}
