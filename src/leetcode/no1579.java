package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class no1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int len = edges.length;
        List<edge> edgelist = new ArrayList<>();
        for(int i=0;i<len;i++)
            edgelist.add(new edge(edges[i][0],edges[i][1],edges[i][2]));
        edgelist.sort(new Comparator<edge>(){
            public int compare(edge edge1,edge edge2){return edge2.type - edge1.type;}
        });
        int result = 0;
        Unionset alice = new Unionset(n+1);
        Unionset bob = new Unionset(n+1);
        for(int i=0;i<edgelist.size();i++)
        {
            edge temp = edgelist.get(i);
            if(temp.type==3)
            {
                boolean t1 = alice.union(temp.x,temp.y);
                boolean t2 = bob.union(temp.x, temp.y);
                if(t1&&t2)
                    result++;
            }
            else if(temp.type==1)
                if(alice.union(temp.x, temp.y))
                    result++;
                else
                if(bob.union(temp.x,temp.y))
                    result++;
        }
        for(int i=1;i<=n;i++)
            if(alice.find(i)!=alice.find(1)||bob.find(i)!=bob.find(1))
                return -1;
        return result;
    }
    class Unionset
    {
        int[] parent;
        int[] rank;
        public Unionset(int n)
        {
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i= 0 ;i<n;i++)
                this.parent[i] = i;
            Arrays.fill(this.rank, 1);
        }
        public int find(int x)
        {
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int x, int y)
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
    class edge{
        int type;
        int x;
        int y;
        public edge(int type, int x, int y)
        {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    public static void main(String[] args)
    {
        no1579 t = new no1579();
        int[][] edges = new int[][]{{1,1,2},{2,1,2},{3,1,2}};
        t.maxNumEdgesToRemove(2, edges);
    }
}
