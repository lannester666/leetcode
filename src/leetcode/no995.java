package leetcode;

public class no995 {
    public int minKBitFlips(int[] A, int K) {
        int n=A.length;
        int start=0;
        int end=0;
        int count=0;
        boolean flag=false;
        while(start<n)
        {
            if(A[start]==0)
            {
                end=start;
                if(end+K>n)
                {
                    flag=true;
                    break;
                }
                for(int i=end;i<K+end;i++)
                {
                    A[end]=(A[end]+1)%2;
                }
                count++;
            }
            start++;
        }
        if(flag)
            return -1;
        else
            return count;
    }
    public static void main(String[] args)
    {
        no995 t= new no995();
        t.minKBitFlips(new int[]{0,0,0,1,0,1,1,0},3);
    }
}
