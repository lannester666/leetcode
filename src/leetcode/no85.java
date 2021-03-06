package leetcode;

import java.util.Stack;

public class no85 {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        for(int i=0;i<m;i++)
        {
            int[] left = new int[n];
            int[] right = new int[n];
            Stack<Integer> stack = new Stack<>();
            int[] height = new int[n];
            for(int j=0;j<n;j++)
            {
                int start=i;
                while(start<m&&matrix[start][j]=='1')
                    start++;
                height[i]=start-i;
            }
            for(int j=0;j<n;j++)
            {
                while(!stack.empty()&&height[stack.peek()]>=height[j])
                    stack.pop();
                if(stack.empty())
                    left[j]=-1;
                else
                    left[j]=stack.peek();
                stack.push(j);
            }
            stack.clear();
            for(int j=n-1;j>=0;j--)
            {
                while(!stack.empty()&&height[stack.peek()]>=height[j])
                    stack.pop();
                if(stack.empty())
                    right[j]=n;
                else
                    right[j]=stack.peek();
                stack.push(j);
            }
            for(int j=0;j<n;j++)
                max=Math.max(max,(right[j]-left[j]-1)*height[j]);
        }
        return max;
    }
    public static void main(String[] args)
    {
        no85 t= new no85();
        t.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
