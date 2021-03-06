package leetcode;

public class no959 {
    public int regionsBySlashes(String[] grid) {
        int n= grid.length;
        boolean[][] solve = new boolean[n+1][n+1];
        boolean[][] flag = new boolean[n+1][n+1];//自动初始化为false
        int[] result = new int[1];
        result[0] = 1;
        for(int i=0;i<n;i++)
        {
            int j = 0;
            int k =0;
            while(j<grid[i].length())
            {
                if(grid[i].charAt(j)==' ')
                    j++;
                else if(grid[i].charAt(j)=='/')
                {
                    j++;
                    solve[i+1][k] = true;
                    solve[i][k+1] = true;
                }
                else
                {
                    j+=2;
                    solve[i][k] = true;
                    solve[i+1][k+1] = true;
                }
                k++;
            }
        }
        for(int i = 0;i<n+1;i++)
        {
            if(!flag[i][0]&&solve[i][0])
                dfs(i, 0 , result,solve, flag,n);
        }
        for(int i = 0;i<n+1;i++)
        {
            if(!flag[i][n]&&solve[i][n])
                dfs(i, n , result,solve, flag,n);
        }
        for(int i = 1;i<n;i++)
        {
            if(!flag[0][i]&&solve[0][i])
                dfs(0, i , result,solve, flag,n);
        }
        for(int i = 1;i<n;i++)
        {
            if(!flag[n][i]&&solve[n][i])
                dfs(n, i , result,solve, flag,n);
        }
        return result[0];
    }
    public void dfs(int x, int y, int[] result,boolean[][] solve, boolean[][] flag,int n)
    {
        if(x<0||x>n||y<0||y>n)
            return;
        if(flag[x][y])
        {
            result[0]++;
            return;
        }
        int[] left = new int[]{x-1,y};
        int[] right = new int[]{x+1,y};
        int[] top = new int[]{x,y-1};
        int[] bot = new int[]{x,y+1};
        if(search(x,y,left,result,flag,n)&&solve[left[0]][left[1]])
            dfs(left[0],left[1],result,solve,flag,n);
        if(search(x,y,right,result,flag,n)&&solve[right[0]][right[1]])
            dfs(right[0],right[1],result,solve,flag,n);
        if(search(x,y,top,result,flag,n)&&solve[top[0]][top[1]])
            dfs(top[0],top[1],result,solve,flag,n);
        if(search(x,y,bot,result,flag,n)&&solve[bot[0]][bot[1]])
            dfs(bot[0],bot[1],result,solve,flag,n);
        flag[x][y]= true;
    }
    public boolean search(int x, int y ,int[] direction,int[] result,boolean[][] flag,int n)
    {
        if(direction[0]<0||direction[0]>n||direction[1]<0||direction[1]>n)
            return false;
        else if(direction[0]==0||direction[0]==n||direction[1]==0||direction[1]==n||flag[direction[0]][direction[1]])
        {
            result[0]++;
            return false;
        }
        else return true;
    }
    public static void main(String[] args)
    {
        no959 t = new no959();
        String[] grid = new String[2];
        grid[0] = " /";
        grid[1] = "/ ";
        t.regionsBySlashes(grid);
    }
}
