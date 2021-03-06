package leetcode;

public class no4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = m+n;
        if(ans%2==1)
        {
            int li = (ans-1)/2;//共有li个数比要求的小
            return Math.max(findnum(nums1,nums2,li),findnum(nums2,nums1,li));
        }
        else
        {
            int  li = ans/2-1;
            double d1,d2,d4;
            d1 = findnum(nums1,nums2,li);
            d4 = findnum(nums2,nums1,li);
//            d1 = Math.max(findnum(nums1,nums2,li),findnum(nums2,nums1,li));
//            d2 = Math.max(findnum(nums1,nums2,li+1),findnum(nums2,nums1,li+1));
            d2 = findnum(nums1,nums2,li+1);
            double d3 = findnum(nums2,nums1,li+1);
            d2=Math.max(d2,d3);
            d2=Math.max(d1,d2);
            return (d1+d2)/2;
        }
    }
    double findnum(int[] nums1,int[] nums2,int li)
    {
        int m=nums1.length;
        if(m==0)
            return (double)-1000000;
        int n=nums2.length;
        int ln1 = 0;
        int ln2 = 0;
        int hi = m-1;
        int lo = 0;
        boolean flag = false;
        while(lo<=hi)
        {
            ln1=(hi+lo)/2;
            ln2 = li-ln1;
            if(ln2==divide(nums2,nums1[ln1]))
            {
                flag = true;
                break;
            }
            else if(ln2>divide(nums2,nums1[ln1]))
                lo=ln1+1;
            else
                hi=ln1-1;

        }
        if(flag)
            return (double)nums1[ln1];
        else return (double)-1000000;
    }
    int divide(int[] nums,int x)
    {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            if(x==nums[mid])
                 return mid;
            else if(x>nums[mid])
                lo=mid+1;
            else
                hi=mid-1;
        }
        return lo;
    }
    public static void main(String[] args)
    {
        no4 t= new no4();
        t.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        System.out.println(t.findMedianSortedArrays(new int[]{1,2},new int[]{1,2}));
    }
}
