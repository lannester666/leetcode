package leetcode;

import java.util.HashMap;
import java.util.Map;

public class no_290 {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> map1 = new HashMap<String, Character>();
        int start=0;
        int end = 0;
        boolean flag = true;
        for(int i=0;i<pattern.length();i++)
        {
            while(end<s.length())
            {
                if(s.charAt(end)!=' ')
                    end++;
                else
                    break;
            }
            String temp;
            if(end==s.length())
                temp = s.substring(start);
            else
                temp = s.substring(start, end);
            end++;
            start = end;
            if(map.containsKey(pattern.charAt(i)))
            {
                if(!temp.equals(map.get(pattern.charAt(i))))
                {
                    flag = false;
                    break;
                }
            }
            else if(map1.containsKey(temp))
            {
                if(pattern.charAt(i)!=map1.get(temp))
                {
                    flag = false;
                    break;
                }
            }
            else{
                map.put(pattern.charAt(i), temp);
                map1.put(temp, pattern.charAt(i));
            }
        }
        if(end<s.length())
            flag = false;
        return flag;
    }
    public static void main(String[] args) {
    String p = "jquery";
    String s = "jquery";
        System.out.println(wordPattern(p, s));
    }
}
