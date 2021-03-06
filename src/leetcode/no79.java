package leetcode;

public class no79 {
    int[][] loc=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int len=word.length();
        boolean[] result=new boolean[1];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(result[0])
                    break;
                if(board[i][j]==word.charAt(0))
                {
                    boolean[][] flag =new boolean[m][n];
                    backtrace(len,0,i,j,board,result,flag,word);
                }
            }
        return result[0];
    }
    void backtrace(int len,int n,int x,int y,char[][] board,boolean[] result,boolean[][] flag,String word)
    {
        int m=board.length;
        int nn=board[0].length;
        if(n==len-1)
        {
            result[0]=true;
            return;
        }
        if(result[0]||flag[x][y])
            return;
        flag[x][y]=true;
        for(int i=0;i<4;i++)
        {
            int tx=x+loc[i][0];
            int ty=y+loc[i][1];
            if(tx<0||tx>=m||ty<0||ty>=nn||flag[tx][ty])
                continue;
            if(board[tx][ty]==word.charAt(n+1))
                backtrace(len,n+1,tx,ty,board,result,flag,word);
            flag[tx][ty]=false;
        }
    }
    public static void main(String[] args)
    {
        no79 t= new no79();
        System.out.println(t.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},
                "ABCESEEEFS"));
    }
}
