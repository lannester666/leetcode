package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class no_300 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] value=new int[n];
        for(int i=0;i<n;i++)
            value[i]=1;
        for(int i=0;i<n;i++)
            for(int j=i;j>=0;j--)
                if(nums[i]>nums[j])
                value[i] = Math.max(value[i],value[j]+1);
      for(int i:value)
          System.out.println(i);

        return value[n-1];
    }//[1,3,6,7,9,4,10,5,6]
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for(int i=0;i<num;i++)
            nums[i] = scanner.nextInt();
        int p = lengthOfLIS(nums);
        System.out.println(p);
    }
}
