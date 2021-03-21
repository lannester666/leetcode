package leetcode;

public class No73 {
    public void setZeroes(int[][] matrix) {
        boolean col=false,row=false;
        int n=matrix.length,m=matrix[0].length;
        for(int i=0;i<m;i++)
            if(matrix[0][i]==0)
                row=true;
        for(int i=0;i<n;i++)
            if(matrix[i][0]==0)
                col=true;
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                if(matrix[i][j]==0)
                {matrix[i][0]=0;
                    matrix[0][j]=0;
                    break;}
        for(int i=1;i<m;i++)
        {
            if(matrix[0][i]==0)
            {
                for(int j=1;j<n;j++)
                    matrix[j][i]=0;
            }
            if(row)
            {
                for(int j=1;j<m;j++)
                    matrix[0][j]=0;
            }
        }
        for(int i=1;i<n;i++)
        {
            if(matrix[i][0]==0)
            {for(int j=1;j<m;j++)
                matrix[i][j]=0;}
            if(col)
            {
                for(int j=0;j<n;j++)
                    matrix[j][0]=0;
            }
        }
    }
    public static void main(String[] args)
    {
        No73 t=new No73();
        t.setZeroes(new int[][]{{1,0}});
    }
}
