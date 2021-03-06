package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class no_31 {
        public static void nextPermutation(int[] nums) {
            int a, b;
            a = -1;
            b = 0;
            for (int i = nums.length - 2; i >= 0; i--)
                if (nums[i] < nums[i + 1]) {
                    a = i;
                    break;
                }
            if (a == -1) {
                Arrays.sort(nums);
            } else {
                for (int i = nums.length - 1; i > 0; i--)
                    if (nums[i] > nums[a]) {
                        b = i;
                        break;
                    }
                if (b > 0) {
                    int temp = nums[a];
                    nums[a] = nums[b];
                    nums[b] = temp;
                    Arrays.sort(nums, a + 1, nums.length - 1);
                }
            }

        }
        public static void main(String[] args)
        {
            int[] nums=new int[3];
            Scanner scanner=new Scanner(System.in);
            for(int i=0;i<3;i++)
                nums[i]=scanner.nextInt();
            nextPermutation(nums);
            for(int i:nums)
                System.out.println(i);
        }
}
