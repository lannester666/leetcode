package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no131 {
    List<List<String>> res=new ArrayList<>();
    List<String> aux=new ArrayList<>();
    boolean[][] dp;
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        dp=new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<=i;j++)
            {
                String tp=s.substring(j,i+1);
                if(new StringBuffer(tp).reverse().toString().equals(tp))
                    dp[j][i]=true;
            }
        backtrace(0,s);
        return res;
    }
    public void backtrace(int start,String s)
    {
        if(start==n)
        {
            res.add(new ArrayList<>(aux));
            return;
        }
        for(int i=start;i<n;i++)
            if(dp[start][i])
            {
                aux.add(s.substring(start,i+1));
                backtrace(i+1,s);
                aux.remove(aux.size()-1);
            }
    }
    public static void main(String[] args)
    {
        no131 t=new no131();
        t.partition("aab");
    }
}
