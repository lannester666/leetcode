package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class no1004 {
    public int longestOnes(int[] A, int K) {
        int n=A.length;
        int max=0;
        int start=0;
        int end=0;
        int count=K;
        Queue<Integer> aux=new LinkedList<>();
        while(end<n)
        {
            if(A[end]==0)
            {
                if(count==0)
                {
                    max=Math.max(max,end-start);
                    if(K==0)
                        continue;
                    else
                    {
                        aux.add(end);
                        start=aux.poll()+1;
                    }
                }
                else
                {
                    aux.add(end);
                    count--;
                }
            }
            end++;
        }
        max=Math.max(max,end-start);
        return max;
    }
    public static void main(String[] args)
    {
        no1004 t= new no1004();
        System.out.println(t.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
}
