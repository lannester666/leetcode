package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int count =0 ;
        while(count<n)
        {
            int temp=nums[count]-1;
            while(temp>=0)
            {
                int pre=temp;
                temp=nums[pre]-1;
                nums[pre]=0;
            }
            count++;
        }
        for(int i=0;i<n;i++)
            if(nums[i]>0)
                res.add(i+1);
        return res;
    }
    public static void main(String[] args)
    {
        no448 t = new no448();
        t.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println( t.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
