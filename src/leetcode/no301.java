package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class no301 {
    HashSet<String> set=new HashSet<>();
    int len;
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        len=s.length();
        int left=0;
        int right=0;
        int count=0;
        while(count<len)
        {
            if(s.charAt(count)=='(')
                left++;
            else if(s.charAt(count)==')')
            {
                if(left==0)
                    right++;
                else
                    left--;
            }
            count++;
        }
        dfs(left,right,0,0,0,s,new StringBuilder());
        System.out.println(set);
        return new ArrayList<>(set);
    }
    public void dfs(int left,int right,int countl,int countr,int index,String s,StringBuilder path)
    {
        if(index==len)
        {
            if(left==0&&right==0)
                set.add(path.toString());
            return;
        }
        char cur=s.charAt(index);
        if(cur=='('&&left>0)
            dfs(left-1,right,countl,countr,index+1,s,path);
        else if(cur==')'&&right>0)
            dfs(left,right-1,countl,countr,index+1,s,path);
        path.append(cur);
        if(cur=='(')
            dfs(left,right,countl+1,countr,index+1,s,path);
        else if(cur!=')')
            dfs(left,right,countl,countr,index+1,s,path);
        else if(countl>countr)
            dfs(left,right,countl,countr+1,index+1,s,path);
        path.deleteCharAt(path.length()-1);
    }
    public static void main(String[] args)
    {
        no301 t=new no301();
        t.removeInvalidParentheses("()())()");
    }
}
