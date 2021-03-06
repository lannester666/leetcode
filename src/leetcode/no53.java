package leetcode;

public class no53 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] prenum=new int[n+1];
        for(int i=1;i<=n;i++)
            prenum[i]=prenum[i-1]+nums[i-1];
        int end=n-1;
        int start=1;
        int premin=100000;
        int sufmax=-100000;
        while(end>=start)
        {
            premin=Math.min(prenum[start],prenum[start-1]);
            sufmax=Math.max(prenum[end],prenum[end+1]);
            end--;start++;
        }
        return sufmax-premin;
    }
    public static void main(String[] args)
    {
        no53 t = new no53();
        t.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
