package leetcode;

import java.util.*;

public class no1584 {
        public int minCostConnectPoints(int[][] points) {
            int count = 0;
            int n = points.length;
            Unionset un = new Unionset(n);
            List<edge> edges = new ArrayList<edge>();
            for(int i=0;i<n;i++)
                for(int j=i+1;j<n;j++)
                    edges.add(new edge(dist(points, i, j), i ,j));
            edges.sort(new Comparator<edge>(){
                public int compare(edge edge1, edge edge2)
                {return edge1.value - edge2.value;}
            });
            int result = 0;
            for(int i=0;i<edges.size();i++)
            {
                edge temp = edges.get(i);
                if(un.union(temp.x,temp.y))
                {
                    count++;
                    result+=temp.value;
                }
                if(count==n-1)
                    break;
            }
            return result;
        }
        public int dist(int[][] points, int x, int y)
        {
            return Math.abs(points[x][0]-points[y][0])+Math.abs(points[x][1]-points[y][1]);
        }

    class Unionset{
        int n;
        int[] parent;
        int[] rank;
        public Unionset(int n)
        {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.parent = new int[n];
            for(int i=0;i<n;i++)
                this.parent[i] = i;
        }
        public int find(int x)
        {
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        public boolean union(int x,int y)
        {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty)
                return false;
            if(rank[rootx]<rank[rooty])
            {
                int temp = rootx;
                rootx = rooty;
                rooty = temp;
            }
            rank[rootx]+=rank[rooty];
            parent[rooty] = rootx;
            return true;
        }
    }
    class edge{
        int value;
        int x;
        int y;
        public edge(int value,int x,int y)
        {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)
    {
        int[][] p = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        no1584 q= new no1584();
        int m = q.minCostConnectPoints(p);
        System.out.println(q.minCostConnectPoints(p));

    }
}
