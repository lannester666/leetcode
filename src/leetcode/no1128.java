package leetcode;

import java.util.HashMap;
import java.util.Map;

public class no1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int[] dominoe : dominoes) {
            int temp1 = dominoe[0] * 10 + dominoe[1];
            int temp2 = dominoe[1] * 10 + dominoe[0];
            if (temp1 == temp2)
                if (!map.containsKey(temp2))
                    map.put(temp1, count++);
                else
                    result++;
            else {
                if (!map.containsKey(temp1) && !map.containsKey(temp2)) {
                    map.put(temp1, count++);
                    map.put(temp2, count++);
                } else
                    result++;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        no1128 t = new no1128();
        int[][] m = new int[][]{{1,2},{2,1},{3,4},{5,6}};
        t.numEquivDominoPairs(m);
    }
}
