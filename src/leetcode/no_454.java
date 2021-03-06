package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class no_454 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> ab = new HashMap<>();
        for(int i:A)
            for(int j:B)
            {
                ab.put(i+j,ab.getOrDefault(i+j,0)+1);
            }
        for(int i:C)
            for(int j:D)
                if(ab.containsKey(-i-j))
                    count++;
                return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a,b,c,d;
        a = new int[n];b=new int[n];c = new int[n];d=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scanner.nextInt();
            b[i]=scanner.nextInt();
            c[i]=scanner.nextInt();
            d[i]=scanner.nextInt();
        }
        int p=fourSumCount(a,b,c,d);
        System.out.println(p);
    }
}
