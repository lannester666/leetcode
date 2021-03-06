package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = k-1;
        double[] result = new double[nums.length-k+1];
        List<Integer> list = new ArrayList<>();
        for(int i=start;i<=end;i++)
            list.add(nums[i]);
        Collections.sort(list);
        if(k%2==1)
            result[0]=(double)list.get((k-1)/2);
        else
            result[0]=((double)list.get(k/2-1)+(double)list.get(k/2))/2;
        // System.out.println((double)list.get(k/2-1));
        // System.out.println((double)list.get(k/2));
        // System.out.println(result[0]);
        start++;
        end++;
        while(end<nums.length)
        {
            result[start] = find_mid(k,list,nums[start-1],nums[end]);
            start++;end++;
        }
        return result;
    }
    double find_mid(int k,List<Integer> list,int start,int end)
    {
        int lo = 0;
        int hi = list.size()-1;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            int temp = list.get(mid);
            if(temp==start) {
                list.remove(mid);
                break;
            }
            else if(temp<start)
                lo=mid+1;
            else
                hi = mid-1;
        }
        lo = 0;
        hi = list.size()-1;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            int temp = list.get(mid);
            if(temp<=end)
                lo=mid+1;
            else
                hi=mid-1;
        }
        list.add(lo,end);
        if(k%2==1)
            return (double)list.get((k-1)/2);
        else
            return ((double)list.get(k/2-1)+(double)list.get(k/2))/2;
    }
    public static void main(String[] args)
    {
        no480 t = new no480();
        int[] nums = new int[]{1,1,1,1};
        t.medianSlidingWindow(nums,2);
    }
}
