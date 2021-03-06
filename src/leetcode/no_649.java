package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class no_649 {
    static public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i=0;i<senate.length();i++)
        {
            if(senate.charAt(i)=='D')
                dire.offer(i);
            else
                radiant.offer(i);
        }
        while(!radiant.isEmpty()&&!dire.isEmpty())
        {
            int r = radiant.poll();
            int d = dire.poll();
            if(r>d)
            {
                dire.offer(d+senate.length());
            }
            else{radiant.offer(r+senate.length());}
        }
        if(radiant.isEmpty())
            return "Dire";
        else
            return "Radiant";
    }
    public static void main(String[] args)
    {
        String s = "RDD";
        String temp = predictPartyVictory(s);
        System.out.println(predictPartyVictory(s));
    }
}
