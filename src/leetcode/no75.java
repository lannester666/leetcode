package leetcode;

public class no75 {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int pointer0=-1;
        int pointer2=n;
        int start=0;
        while(pointer0<n-1&&nums[pointer0+1]==0)
            pointer0++;
        while(pointer2>0&&nums[pointer2-1]==2)
            pointer2--;
        start=Math.max(start,pointer0+1);
        while(start<pointer2)
        {
            if(nums[start]==2)
            {
                nums[start]=nums[pointer2-1];
                nums[pointer2-1]=2;
            }
            else if(nums[start]==1)
                start++;
            else
            {
                nums[start]=nums[pointer0+1];
                nums[pointer0+1]=0;
            }
            while(pointer0<n-1&&nums[pointer0+1]==0)
                pointer0++;
            while(pointer2>1&&nums[pointer2-1]==2)
                pointer2--;
            start=Math.max(start,pointer0+1);
        }

        for(int i:nums)
            System.out.println(i);
    }
    public static void main(String[] args)
    {
        no75 t = new no75();
        t.sortColors(new int[]{2,0});
    }
}
