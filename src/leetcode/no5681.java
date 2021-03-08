package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no5681 {
    public boolean checkPowersOfThree(int n) {
        List<Integer> list=new ArrayList<>();
        int start=1;
        boolean[] dp=new boolean[n+1];
        while(start<=n)
        {
            list.add(start);

            start*=3;
        }
        dp[0]=true;
        boolean flag=false;
        for(int i=0;i<list.size();i++)
        {
            for(int j=n;j>0;j--)
            {
                int tp=j-list.get(i);
                if(tp>=0)
                {
                    if(dp[tp])
                        dp[j]=true;
                }

            }
            if(dp[n])
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args)
    {
        no5681 t=new no5681();
        t.checkPowersOfThree(7800000);
    }
}
