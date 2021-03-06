package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no395 {
    public int longestSubstring(String s, int k) {
        int n=s.length();
        if(k>n)
            return 0;
        return backtrace(0,n-1,k,s);
    }
    public int backtrace(int start,int end,int k,String s)
    {
        if(start>end)
            return 0;
        int[] aux=new int[26];
        int[] count=new int[26];
        for(int i=start;i<=end;i++)
        {
            aux[s.charAt(i)-'a']++;
            count[s.charAt(i)-'a']++;
        }
        int l=start;
        boolean flag=true;
        int res=0;
        for(int i=start;i<=end;i++)
        {
            char ch=s.charAt((i));
            if(aux[ch-'a']>0&&aux[ch-'a']<k)
            {
                count[ch-'a']--;
                flag=false;
                if(count[ch-'a']==0) {
                    res=Math.max(res,backtrace(l,i-1,k,s));
                    res=Math.max(res, backtrace(i + 1, end, k, s));
                }
                else {
                    res=Math.max(res,backtrace(l,i-1,k,s));
                    l = i + 1;
                }
            }
        }
        if(flag)
            return end-start+1;
        else
            return res;
    }
    public static void main(String[] args)
    {
        no395 t=new no395();
        System.out.println(t.longestSubstring("aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz",3));
    }
}
