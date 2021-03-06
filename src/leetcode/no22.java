package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class no22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String str="";
        enlen(true, n*2,0,str,result);
        enlen(false,n*2,0,str,result);
        return result;
    }
    void enlen(boolean flag,int len,int index,String str,List<String> result)
    {
        if(index==len)
        {
            if(flag&&isvalid(str))
                result.add(str);
        }
        else
        {
            if(flag)
            {
                str=str+'(';
                int temp = index+1;
                enlen(true,len,temp,str,result);
                enlen(false,len,temp,str,result);
            }
            else
            {
                str=str+')';
                int temp = index+1;
                enlen(true,len,temp,str,result);
                enlen(false,len,temp,str,result);
            }
        }
    }
    boolean isvalid(String str)
    {
        int n=str.length();
        if(n%2==1)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)=='(')
                stack.push('(');
            else
            {
                if(stack.empty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.empty();
    }
    public static void main(String[] args)
    {
        no22 t = new no22();
        t.generateParenthesis(3);
    }
}
