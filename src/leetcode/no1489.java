package leetcode;

import java.util.*;

public class no1489 {
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> t = new ArrayList<Integer>();
            result.add(t);
            result.add(t);
            List<Edge> edge = new ArrayList<Edge>();
            Map<Edge,Integer> map = new HashMap<Edge, Integer>();
            for(int i=0;i<edges.length;i++)
            {
                Edge e = new Edge(edges[i][0],edges[i][1],edges[i][2]);
                edge.add(e);
                map.put(e,i);
            }
            edge.sort(new Comparator<Edge>(){public int compare(Edge edge1, Edge edge2){return edge1.value-edge2.value;}});
            int value = 0;
            Unionset un = new Unionset(n);
            for(int i = 0;i<edge.size();i++)
            {
                Edge temp = edge.get(i);
                if(!un.Union(temp.x,temp.y))
                    value+=temp.value;
            }
            for(int i=0;i<edge.size();i++)
            {
                Unionset unset = new Unionset(n);
                int value1 = 0;
                for(int j=0;j<edge.size();j++)
                {
                    Edge temp1 = edge.get(j);
                    if(i!=j&&!unset.Union(temp1.x,temp1.y))
                        value1+=temp1.value;
                }
                if(unset.num<n||(unset.num==n&&value1>value))
                    result.get(0).add(map.get(edge.get(i)));
                if(unset.num==n&&value1==value)
                    result.get(1).add(map.get(edge.get(i)));
            }
            return result;
        }
        class Unionset{
            int[] parent;
            int[] rank;
            int num;
            public Unionset(int n)
            {
                this.num = 1;
                this.parent = new int[n];
                for(int i= 0 ;i<n;i++)
                    this.parent[i] = i;
                this.rank = new int[n];
                Arrays.fill(this.rank,1);
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
                if(rx == ry)
                    return true;
                if(rank[rx]<rank[ry])
                {
                    int temp = rx;
                    rx = ry;
                    ry = temp;
                }
                rank[rx]+=rank[ry];
                parent[ry] = rx;
                num++;
                return false;
            }
        }
        class Edge {
            int x;
            int y;
            int value;

            public Edge(int x, int y, int value) {
                this.x = x;
                this.y = y;
                this.value = value;
            }
        }
        public static void main(String[] args)
        {
            no1489 t = new no1489();
            int n  = 5;
            int[][] edges = new int[][]{{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
            t.findCriticalAndPseudoCriticalEdges(n, edges);

        }
}
