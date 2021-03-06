package leetcode;

import java.util.Stack;

public class no84 {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int n=heights.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!stack.empty()&&stack.peek()>=heights[i])
                stack.pop();
            if(stack.empty())
                left[i]=-1;
            else
                left[i]=stack.peek();
            stack.push(i);
        }
        Stack<Integer> stack1 = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!stack1.empty()&&stack1.peek()>=heights[i])
                stack1.pop();
            if(stack1.empty())
                right[i]=n;
            else
                right[i]=stack1.peek();
            stack1.push(i);
        }
        for(int i=0;i<n;i++)
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        return max;
    }
    public static void main(String[] args)
    {
        no84 t= new no84();
        t.largestRectangleArea(new int[]{1,1});
    }
}
