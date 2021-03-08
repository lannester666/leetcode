package leetcode;

import java.util.HashMap;
import java.util.Map;

public class no5682 {
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;
        int[] aux=new int[26];

        for(int i=0;i<n;i++)
            aux[s.charAt(i)-'a']++;
        for(int i=n-1;i>=0;i--)
        {

            int[] aux1=new int[26];
            for(int k=0;k<26;k++)
                aux1[k]=aux[k];
            for(int j=0;j<i;j++)
            {
                int max1=0;
                int min1=500;
                for(int k=0;k<26;k++)
                {
                    if(aux1[k]==0)
                        continue;
                    max1=Math.max(max1,aux1[k]);
                    min1=Math.min(min1,aux1[k]);
                }
                if(max1==0||min1==500)
                    break;
                ans+=max1-min1;
                aux1[s.charAt(j)-'a']--;
            }
            char c=s.charAt(i);
            aux[c-'a']--;
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args)
    {
        no5682 t=new no5682();
        t.beautySum("aabcb");
    }
}
