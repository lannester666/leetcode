package leetcode;

import java.io.InterruptedIOException;
import java.util.*;

public class Test31 {
//        public boolean checkStraightLine(int[][] coordinates) {
//            if(coordinates.length<=2)
//                return true;
//            else
//            {
//                boolean flag = false;
//                if((coordinates[1][0]-coordinates[0][0])!=0)
//                {
//                        int k = 0;
//                    double b = coordinates[0][1]-k*coordinates[0][0];
//                    for(int i=2;i<coordinates.length;i++)
//                    {
//                        if((double)coordinates[i][1]!=coordinates[i][0]*k+b)
//                        {
//                            flag = true;
//                            break;
//                        }
//                    }
//                }
//                else
//                {
//                    for(int i=2;i<coordinates.length;i++)
//                    {
//                        if(coordinates[i][0]!=coordinates[0][0])
//                        {
//                            flag = true;
//                            break;
//                        }
//                    }
//                }
//                return !flag;
//            }
//        }
static class edge {
    int type;
    int x;
    int y;

    public edge(int type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
    public static void test(Map<Integer,Integer> map)
    {
        System.out.println(map.get(0));
    }


    public static void main(String[] args)
    {
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        };
//        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
//        queue.add(10);
//        queue.add(15);
//        queue.add(5);
//        System.out.println(Objects.requireNonNull(queue.poll()).intValue());
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(1,100);
        System.out.println(list);
    }
}
