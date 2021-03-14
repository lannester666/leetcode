package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class no1514 {
    class Node{
        int v;
        double w,d;
        public Node(int v,double w)
        {
            this.v=v;
            this.w=w;
        }
    }
    PriorityQueue<Node> pq;
    double[] dist;
    ArrayList<Node>[] adj;
    int n;
    public void dijkstra()
    {
        dist=new double[n];
        boolean[] visited=new boolean[n];
        Arrays.fill(dist,-1);
        pq=new PriorityQueue(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.d>n2.d)
                return -1;
                if(n1.d<n2.d)
                    return 1;
                    return 0;}
        });
        pq.add(new Node(n-1,1));
        dist[n-1]=1;
        while(!pq.isEmpty())
        {
            Node node=pq.poll();
            int v=node.v;
            if(visited[v])
                continue;
            visited[v]=true;
            for(Node nx:adj[v])
            {
                if(dist[nx.v]<dist[v]*nx.w)
                {
                    dist[nx.v]=dist[v]*nx.w;
                    nx.d=dist[nx.v];
                    pq.add(nx);
                }
            }
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        this.n=n-1;
        adj=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int u=edges[i][0],v=edges[i][1];
            double choice=succProb[i];
            adj[u].add(new Node(v,choice));
            adj[v].add(new Node(u,choice));
        }
        dijkstra();
        return dist[0];
    }
}
