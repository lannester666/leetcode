package leetcode;

import java.util.HashMap;
import java.util.Map;

public class no888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int suma = 0;
        int sumb = 0;
        Map<Integer,Integer> mapB = new HashMap<>();
        for(int i=0;i<A.length;i++)
            suma+=i;
        for(int i=0;i<B.length;i++)
        {
            sumb+=i;
            mapB.put(B[i],i);
        }
        int c = (suma-sumb)/2;
        for(int i= 0;i<A.length;i++)
        {
            if(mapB.containsKey(A[i]-c))
                return new int[]{A[i],A[i]-c};
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args)
    {
        no888 t = new no888();
        t.fairCandySwap(new int[]{32,38,8,1,9
},new int[]{68,92});
    }
}
