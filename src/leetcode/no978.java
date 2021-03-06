package leetcode;

public class no978 {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        boolean flag=false;//flag为false代表奇数位比两边大，true代表比两边小
        int start=0;
        int max=1;
        while(start<n-1)
        {
            int temp=start+1;
            if(temp<n)
            {
                if(arr[temp]>arr[start])
                    flag=false;
                else if(arr[temp]<arr[start])
                    flag=true;
                else {start++;continue;}
            }
            while(temp<n-1)
            {
                if(arr[temp]==arr[temp+1])
                    break;
                else if(flag&&arr[temp]<arr[temp-1]&&arr[temp]<arr[temp+1])
                {
                    temp++;
                    flag=!flag;
                }
                else if(!flag&&arr[temp]>arr[temp-1]&&arr[temp]>arr[temp+1])
                {
                    temp++;flag=!flag;
                }
                else break;
            }
            max=Math.max(temp-start+1,max);
            start=temp;
        }
        return max;
    }
    public static void main(String[] args)
    {
        no978 t = new no978();
        t.maxTurbulenceSize(new int[]{9,9,9,9});
        System.out.println( t.maxTurbulenceSize(new int[]{9,9}));
    }
}
