package leetcode;

public class no5711 {
        long num;
        long idx;
        long max;
        public int maxValue(int n, int index, int maxSum) {
            num=n;idx=index;max=maxSum;
            if(idx>=n/2)
                idx=n-1-index;
            long l=0;
            long r=maxSum;
            long mid=0;
            int m=0;
            while(l<=r)
            {
                mid=(l+r)/2;
                if(isright(mid))
                {
                    m=Math.max((int)mid,m);
                    l=mid+1;
                }
                else
                    r=mid-1;
            }
            System.out.println(m);
            return m;
        }
        boolean isright(long mid)
        {
            long res=max-mid;
            long min=mid-idx;
            if(min>0)
            {
                res-=(mid-idx+mid-1)*idx;
                if(res<0)
                    return false;
                long remain=num-1-idx*2;
                if(min>remain)
                {
                   long t=(min-1+min-remain);
                   t=t*remain/2;
                    res-=t;
                }
                else
                {
                    long x=remain-(min-1);
                    res-=min*(min-1)/2;
                    res-=x;
                }
            }
            else
            {
                long x=idx-mid+1;
                long t=mid*(mid-1);
                res-=t;
                if(res<0)
                    return false;
                res-=x*2;
                res-=num-1-idx*2;
            }
            return res >= 0;
        }
    public static void main(String[] args)
    {
        no5711 t=new no5711();
        t.maxValue(8257285,
                4828516,
                850015631);

    }
}
