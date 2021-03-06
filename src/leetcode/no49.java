package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class no49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n=strs.length;
        Map<Character,Integer>[] maps = new Map[n];
        List<Map<Character,Integer>> resultset=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            maps[i] = new HashMap<>();
            for(int j=0;j<strs[i].length();j++)
            {
                Character temp=strs[i].charAt(j);
                if(!maps[i].containsKey(temp))
                    maps[i].put(temp,1);
                else
                    maps[i].put(temp,maps[i].get(temp)+1);
            }
        }
        for(int i=0;i<n;i++)
        {
            boolean flag=false;
            for(int j=0;j<resultset.size();j++)
                if(maps[i].equals(j))
                {
                    flag=true;
                    result.get(j).add(strs[i]);
                }
            if(!flag)
            {
                resultset.add(maps[i]);
                List<String> t = new ArrayList<>();
                t.add(strs[i]);
                result.add(t);
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        no49 t = new no49();
        t.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
