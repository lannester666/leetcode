package leetcode;

import java.util.*;

public class no_493 {
    static int count=0;
    static void sort(int[] nums,int lo,int hi)
    {
        if(lo>=hi)
            return;
        int mid = lo+(hi-lo)/2;
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    static void merge(int[] nums,int lo,int mid,int hi)
    {
        int[] aux = new int[nums.length];
        if(hi-lo+1>0)
           System.arraycopy(nums,lo,aux,lo,hi-lo+1);
        int j=lo;int k=mid+1;
        for(int i=lo;i<=hi;i++)
        {
            if(j>mid)
                nums[i]=aux[k++];
            else if(k>hi) {
                int temp=k;
                while(temp>mid+1&&aux[j]<=2*aux[temp-1])
                    temp--;
                count+=temp-mid-1;
                nums[i] = aux[j++];
            }
            else if(aux[j]>aux[k])
            {
                nums[i]=aux[k++];
            }
            else {
                if(aux[j]==aux[k])
                {
                    int temp=k;
                    while(temp>mid+1&&aux[j]<=2*aux[temp-1])
                        temp--;
                    count+=temp-mid-1;
                    nums[i]=aux[k++];
                }
                else {
                    int temp = k;
                    while (temp > mid + 1 && aux[j] <= 2 * aux[temp - 1])
                        temp--;
                    count += temp - mid - 1;
                    nums[i] = aux[j++];
                }
            }

        }
     }
    public static int reversePairs(int[] nums) {
//        HashMap[] maps=new HashMap[64];
//        for(int i=0;i<64;i++)
//            maps[i]=new HashMap<Integer,Integer>();\
        int lo=0;
        int hi= nums.length-1;
        sort(nums,lo,hi);
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = scanner.nextInt();
        int p = reversePairs(nums);
        System.out.println(p);
        for(int i:nums)
            System.out.println(i);
    }
}
