package leetcode;

public class no1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n=customers.length;
        int init=0;
        for(int i=0;i<n;i++)
        {
            if(grumpy[i]==0)
                init+=customers[i];
        }
        int max=0;
        int start=0;
        int end=X-1;
        for(int i=0;i<=end;i++)
            if(grumpy[i]==1)
                max+=customers[i];
        while(end<n)
        {
            int temp=max;
            end++;
            if(end==n)
                break;
            if(grumpy[end]==1)
                temp+=customers[end];
            if(grumpy[start]==1)
                temp-=customers[start];
            start++;
            max=Math.max(max,temp);
        }
        return init+max;
    }
    public static void main(String[] args)
    {
        no1052 t=new no1052();
        t.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3);
    }
}
