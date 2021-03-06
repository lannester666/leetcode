package leetcode;

public class no566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length;
        int n = nums[0].length;
        if(m*n!=r*c)
            return nums;
        int[][] res=new int[r][c];
        int end1=0;
        int end2=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(end1<c)
                {
                    res[end2][end1]=nums[i][j];
                    end1++;
                }
                else
                {
                    end1=0;end2++;
                    res[end2][end1]=nums[i][j];
                }
        return res;
    }
    public static void main(String[] args)
    {
        no566 t= new no566();
        t.matrixReshape(new int[][]{{1,2},{3,4}},4,1);
    }
}
