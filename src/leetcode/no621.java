package leetcode;

import java.util.Arrays;

public class no621 {
    public int leastInterval(char[] tasks, int n) {
        if(n==0)
            return tasks.length;
        int[] cnt=new int[26];
        int m=tasks.length;
        for(int i=0;i<m;i++)
            cnt[tasks[i]-'A']++;
        Arrays.sort(cnt);
        boolean[][] bucket=new boolean[cnt[25]][n];
        int t=24,count=0,remain=1;//count代表多少个相同任务数的最大任务
        while(t>=0&&count<n&&cnt[t]==cnt[25])
        {
            for(int i=0;i<cnt[25];i++)
                bucket[i][count]=true;
            cnt[t]=0;
            t--;count++;remain++;
        }
        int index=0;
        boolean flag=false;
        while(t>=0&&cnt[t]>0)
        {
            if(count==n)
            {
                flag=true;
                break;
            }
            while(cnt[t]>0)
            {
                cnt[t]--;
                bucket[index++][count]=true;
                if(index==cnt[25]-1)
                {
                    count++;index=0;
                }
                if(count==n)
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
            t--;
        }
        if(flag)
        {
           for(int i=0;i<25;i++)
               remain+=cnt[i];
        }
        return (cnt[25]-1)*(n+1)+remain;
    }
    public static void main(String[] args)
    {
        no621 t=new no621();
        System.out.println(t.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},1));
    }
}
