package leetcode;

import java.util.Scanner;

public class no_164 {
    static int solution(int[] nums)
    {
        int max,min;
        max=0;
        min = (int) (Math.pow(2,31)-1);
        for (int num : nums) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }
        int size = Math.max((max-min)/(nums.length-1),1);
        int num = (max-min)/size+1;
        int[][] bucket = new int[num][2];//【num】【0】存桶中最小，【num】【1】存桶中最大
        for(int i=0;i<num;i++)
            bucket[i][0]=bucket[i][1]=-1;
        for (int j : nums) {
            int temp = (j - min) / size;
            if (bucket[temp][0] == -1)
                bucket[temp][0] = j;
            if (bucket[temp][1] == -1)
                bucket[temp][1] = j;
            if (bucket[temp][0] > j)
                bucket[temp][0] = j;
            if (bucket[temp][1] < j)
                bucket[temp][1] = j;
        }
        int m = 0;
        int p=0,q=1;
        while(q<num&&p<num)
        {
            if(bucket[p][0]==-1)
            {p++;
            if(p==q)
            q++;}
            else if(bucket[q][0]==-1)
            {q++;}
            else{
                int temp = bucket[q][0]-bucket[p][1];
                m=Math.max(m,temp);
                p++;
                q++;
            }
        }
        return m;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = scanner.nextInt();
        int m = solution(nums);
        System.out.println(m);
    }
}
