package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//堆优化dijkstra+树形动归
public class no1786 {
    ArrayList<Node>[] adj;//邻接表
    PriorityQueue<Node> q;//堆优化
    int[] dist;//节点n到各个节点的距离
    class Node{
        int v,w,d;//点、权、最小值
        Node(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    int mod = (int)1e9+7;
    int n;
    long[] memory = new long[20005];//记忆化
    public long dfs(int u)
    {
        long res=0;
        if(u==n) return 1;
        if(memory[u]!=-1)
            return memory[u];
        for(Node ch:adj[u]){
            int v= ch.v;
            if(dist[v]>=dist[u])
                continue;
            res=(res+dfs(v))%mod;
        }
        memory[u] = res%mod;
        return memory[u];
    }
    public void dijkstra()
    {
        boolean[] visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE/2);
        dist[n] = 0;
        q = new PriorityQueue<>((n1,n2)->n1.d-n2.d);
        q.add(new Node(n,0));
        while(q.size()>0)
        {
            Node node = q.poll();
            int v = node.v;
            if(visited[v])
                continue;
            visited[v] = true;
            for(Node nx:adj[v])
            {
                int k=nx.v;
                int w=nx.w;
                if(!visited[k]&&dist[k]>dist[v]+w)
                {
                    dist[k] = dist[v]+w;
                    nx.d=dist[k];
                    q.add(nx);
                }
            }
        }
    }
    public int countRestrictedPaths(int n,int[][] edges)
    {
        this.n=n;
        adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            adj[i] = new ArrayList<>();
        for(int[] e:edges)
        {
            int u=e[0],v=e[1],w=e[2];
            adj[u].add(new Node(v,w));
            adj[v].add(new Node(u,w));
        }
        dijkstra();
        Arrays.fill(memory,-1);
        return (int)(dfs(1));
    }
}
