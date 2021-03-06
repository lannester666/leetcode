package leetcode;

import java.util.Arrays;

public class no5691 {
    public int minOperations(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m>n*6||n>m*6)
            return -1;
        int count1=0;
        int count2=0;
        int count=0;
        for(int i=0;i<n;i++)
            count1+=nums1[i];
        for(int i=0;i<m;i++)
            count2+=nums2[i];
        int sub=count1-count2;
        if(sub==0)
            return 0;
        else if(sub>0)
        {
            int start=0;
            int end=n-1;
            while(start<m&&end>=0)
            {
                int t1=6-nums2[start];
                int t2=nums1[end]-1;
                if(Math.max(t1,t2)>sub)
                    return count+1;
                else
                {
                    if(t1>t2)
                    {
                        count++;
                        start++;
                        sub-=t1;
                    }
                    else
                    {
                        count++;
                        end--;
                        sub-=t2;
                    }
                }
            }
            if(sub>0&&start<m)
            {
                while(start<m)
                {
                    int temp=6-nums2[start];
                    if(temp>sub)
                        return count+1;
                    else
                    {
                        count++;
                        start++;
                        sub-=temp;
                    }
                }
            }
            if(sub>0&&end>=0)
            {
                while(end>=0)
                {
                    int temp=nums1[end]-1;
                    if(temp>sub)
                        return count+1;
                    else
                    {
                        count++;
                        end--;
                        sub-=temp;
                    }
                }
            }
            return count;
        }
        else
        {
            sub=-sub;
            int start=0;
            int end=m-1;
            while(start<n&&end>=0)
            {
                int t1=6-nums1[start];
                int t2=nums2[end]-1;
                if(Math.max(t1,t2)>sub)
                    return count+1;
                else
                {
                    if(t1>t2)
                    {
                        count++;
                        start++;
                        sub-=t1;
                    }
                    else
                    {
                        count++;
                        end--;
                        sub-=t2;
                    }
                }
            }
            if(sub>0&&start<n)
            {
                while(start<n)
                {
                    int temp=6-nums1[start];
                    if(temp>sub)
                        return count+1;
                    else
                    {
                        count++;
                        start++;
                        sub-=temp;
                    }
                }
            }
            if(sub>0&&end>=0)
            {
                while(end>=0)
                {
                    int temp=nums2[end]-1;
                    if(temp>sub)
                        return count+1;
                    else
                    {
                        count++;
                        end--;
                        sub-=temp;
                    }
                }
            }
            return count;
        }


    }
    public static void main(String[] args)
    {
        no5691 t=new no5691();
        System.out.println(t.minOperations(new int[]{5,2,1,5,2,2,2,2,4,3,3,5},new int[]{1,4,5,5,6,3,1,3,3}));
    }
}
