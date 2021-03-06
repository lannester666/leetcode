package leetcode;

import java.util.Stack;

public class no503 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        int max=0,index=0;
        for(int i=0;i<n;i++)
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
        res[index]=-1;
        stack.push(res[index]);
        index--;
        int count=1;
        while(count<n)
        {
            boolean flag=false;
            if(index<0)
                index+=n;
            while(!stack.empty())
            {
                int tp=stack.peek();
                if(tp>nums[index])
                {
                    res[index]=tp;
                    stack.push(nums[index]);
                    flag=true;
                    break;
                }
                else
                    stack.pop();
            }
            if(!flag)
            {
                stack.push(nums[index]);
                res[index]=-1;
            }
            count++;index--;
        }
        return res;
    }
    public static void main(String[] args)
    {
        no503 t=new no503();
        t.nextGreaterElements(new int[]{1,2,3,4,5});
    }
}
