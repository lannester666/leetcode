package leetcode;

import java.util.*;

public class no315 {
    private int[] aux;
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        reshape(nums);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<aux.length;i++)
            map.put(aux[i],i);
        int[] value=new int[aux.length];
        array_tree tree=new array_tree(value.length);
        List<Integer> res=new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            int temp=map.get(nums[i]);

            if(temp==0)
                res.add(0);
            else {
                int t1=tree.sumrange(0, temp - 1);
                res.add(t1);
            }
            tree.update(temp,1);
        }
        Collections.reverse(res);
        for(int i:res)
            System.out.println(i);
        return res;
    }
    class array_tree
    {
        private int[] seg;
        private int n;
        public array_tree(int n){
            this.n=n;
            if(n>0)
                seg=new int[n*4];
            Arrays.fill(seg,0);
        }
        public void update(int i,int val)
        {
            update(0,n-1,i,val,0);
        }
        public void update(int start,int end,int i,int value,int index)
        {
            if(start==end)
            {
                seg[index]=seg[index]+value;
                return;
            }
            int mid=(start+end)/2;
            if(i<=mid)
                update(start,mid,i,value,2*index+1);
            else
                update(mid+1,end,i,value,2*index+2);
            seg[index]=seg[index*2+1]+seg[index*2+2];
        }
        public int sumrange(int i,int j)
        {
            return sumrange(0,n-1,i,j,0);
        }
        public int sumrange(int start,int end,int i,int j,int idx)
        {
            if(j<start||i>end)
                return 0;
            if(start>=i&&end<=j)
                return seg[idx];
            int mid=(start+end)/2;
            return sumrange(start,mid,i,j,idx*2+1)+sumrange(mid+1,end,i,j,idx*2+2);
        }
    }
    public void reshape(int[] nums)
    {
        Set<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        aux=new int[set.size()];
        int index=0;
        for(int i:set)
            aux[index++]=i;
        Arrays.sort(aux);
    }
    public static void main(String[] args)
    {
        no315 t=new no315();
        t.countSmaller(new int[]{5,2,6,1});

    }
}
