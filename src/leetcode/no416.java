package leetcode;

import java.util.Arrays;

public class no416 {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n==1)
            return false;
        boolean flag=false;
        int ans=0;
        for(int i=0;i<n;i++)
            ans+=nums[i];
        if(ans%2==1)
            return false;
        int target=ans/2;
        Arrays.sort(nums);
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        int maxt=nums[0];
        dp[nums[0]]=true;
        for(int i=1;i<n;i++)
            for(int j=0;j<=maxt;j++)
            {
                if(j==nums[i])
                    continue;
                if(dp[j])
                {
                    int tp=j+nums[i];
                    if(tp>target)
                        continue;
                    maxt=Math.max(tp,maxt);
                    if(tp==target)
                    {
                        flag=true;
                        break;
                    }
                    else if(tp<target)
                        dp[tp]=true;
                }
            }
        return flag;
    }
    public static void main(String[] args)
    {
        no416 t=new no416();
        for(int i=1;i<10;i++)
                for(int j=1;j<7;j++)
                    break;
    }
}
