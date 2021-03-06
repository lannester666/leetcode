package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class no354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] l1,int[] l2)
            {
                return (l1[0]==l2[0])?l1[1]-l2[1]:l1[0]-l2[0];
            }
        });
        List<Integer> aux=new ArrayList<>();
        aux.add(envelopes[0][1]);
        for(int i=1;i<n;i++)
            if(envelopes[i][1]>aux.get(aux.size()-1))
                aux.add(envelopes[i][1]);
            else
            {
                int temp=binarySearch(envelopes[i][1],aux);
                aux.set(temp+1,envelopes[i][1]);
            }
        return  aux.size();
    }
    public int binarySearch(int num,List<Integer> aux)
    {
        int low=0;
        int high=aux.size()-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(aux.get(mid)>=num)
                high=mid-1;
            else
                low=mid+1;
        }
        return high;
    }
    public static void main(String[] args)
    {
        no354 t=new no354();
        t.maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}});
    }
}
