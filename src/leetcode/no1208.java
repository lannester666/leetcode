package leetcode;

public class no1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        // int result = 0;
        // int n=s.length();
        // int start=0;
        // int end=0;
        // int cost=maxCost;
        // while(start<n)
        // {
        //     int temp = Math.abs(s.charAt(start)-t.charAt(start));
        //     if(temp<=cost)
        //     {
        //     cost-=temp;
        //     start++;
        //     }
        //     else
        //     break;
        // }
        // result=start;
        // if(start==n)
        // return n;
        // else
        // {
        //     end=start;
        //     start=0;
        //     while(end<n)
        //     {
        //         int temp = Math.abs(s.charAt(end)-t.charAt(end));
        //         while(cost<temp)
        //         {
        //             cost+=Math.abs(s.charAt(start)-t.charAt(start));
        //             start++;
        //         }
        //         cost-=temp;
        //         result=Math.max(result,end-start+1);
        //         end++;
        //     }
        // }
        // return result;
        int n=s.length();
        int[] prenum = new int[n+1];
        int result=0;
        for(int i=1;i<=n;i++)
            prenum[i]=prenum[i-1]+Math.abs(s.charAt(i-1)-t.charAt(i-1));
        for(int i=0;i<n;i++)
        {
            int k = findmax(prenum,i,maxCost,n);
            result=Math.max(result,findmax(prenum,i,maxCost,n));
        }
        return result;
    }
    int findmax(int[] prenum,int start,int maxCost,int n)
    {
        int lo=start;
        int hi=n;
        int mid;
        while(lo<=hi)
        {
            mid=(hi+lo)/2;
            int temp = prenum[mid]-prenum[start];
            if(temp==maxCost)
                return mid-start;
            else if(temp>maxCost)
                hi=mid-1;
            else
                lo=mid+1;
        }
        return hi-start;
    }
    public static void main(String[] args)
    {
        no1208 t=  new no1208();
        t.equalSubstring("krpgjbjjznpzdfy","nxargkbydxmsgby",14);
    }
}
