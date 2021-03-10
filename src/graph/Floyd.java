package graph;

public class Floyd {
        public int[][] floyd(int[][] graph,int n)
        {
            int[][] edge=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    edge[i][j]=graph[i][i];
            for(int k=0;k<n;k++)
                for(int i=0;i<n;i++)
                    for(int j=0;j<n;j++)
                        if(edge[i][j]>edge[i][k]+edge[k][j])
                            edge[i][j]=edge[i][k]+edge[k][j];
                        return edge;
        }

}
