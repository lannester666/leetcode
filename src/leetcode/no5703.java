package leetcode;

import java.util.*;

public class no5703 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        class Pair{
            double total;
            double pass;
            double advantage;
            public Pair(int t,int p)
            {
                this.total=(double)t;
                this.pass=(double)p;
                advantage=(pass+1)/(total+1)-pass/total;
            }
            public double getv()
            {
                double res=advantage;
                total++;
                pass++;
                advantage=(pass+1)/(total+1)-pass/total;
                return res;
            }
        }
        PriorityQueue<Pair>  queue=new PriorityQueue(new Comparator<Pair>(){
            @Override
            public int compare(Pair n1, Pair n2) {
                if(n1.advantage>n2.advantage)
                    return -1;
                if(n1.advantage<n2.advantage)
                    return 1;
                return 0;}
        });
        Map<Integer,Pair> map=new HashMap<>();
        // Arrays.sort(classes,(n1,n2)->n1[1]-n2[1]);
        int n=classes.length;
        double res=0;
        for(int i=0;i<n;i++)
        {
            Pair tp=new Pair(classes[i][1],classes[i][0]);
            map.put(i,tp);
            queue.offer(tp);
            res+=(double)classes[i][0]/(double)classes[i][1];
        }
        for(int i=extraStudents;i>0;i--)
        {
            Pair tp=queue.poll();
            res+=tp.getv();
            queue.offer(tp);
        }
        System.out.println(res/n);
        return res/n;

    }
    public static void main(String[] args)
    {
        no5703 t=new no5703();
        t.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}},2);
    }
}
