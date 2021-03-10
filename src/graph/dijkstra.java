package graph;

public class dijkstra {
        int max=10000;
        public  void Dijkstra(int[][] matrix,int start,int terminal)
        {
            boolean[] isVisited = new boolean[matrix.length];
            int[] d = new int[matrix.length];
            for(int i=0;i<matrix.length;i++)
            {
                isVisited[i] = false;
                d[i] = max;
            }
            isVisited[start] = true;
            d[start] = 0;
            int unVisitNode = matrix.length;
            int index=start;
            while (unVisitNode>0&& !isVisited[terminal]) {
                int min = max;
                for (int i = 0; i < d.length; i++) {
                    if (min > d[i] && !isVisited[i]) {
                        index = i;
                        min = d[i];
                    }
                }

                for (int i = 0; i < matrix.length; i++)
                    if (d[index] + matrix[index][i] < d[i])
                        d[i] = d[index] + matrix[index][i];
                unVisitNode --;
                    isVisited[index] = true;
            }
        }
        public static  void main(String[] args)
        {

        }
}
