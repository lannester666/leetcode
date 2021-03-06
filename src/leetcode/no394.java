package leetcode;

import java.util.Stack;

public class no394 {
    public String decodeString(String s) {
        StringBuilder res= new StringBuilder();
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        int count=0;
        while(count<n)
        {
            char c=s.charAt(count);
            if(c==']')
            {
                StringBuilder tp= new StringBuilder();
                while(stack.peek()!='[')
                    tp.append(stack.pop());
                StringBuilder temp= new StringBuilder(new StringBuffer(tp.toString()).reverse().toString());
                stack.pop();
                StringBuilder num= new StringBuilder();
                while(!stack.empty()&&!(stack.peek()<48||stack.peek()>57))
                    num.append(stack.pop());
                StringBuilder r=new StringBuilder();
                r.append(temp);
                int nums=Integer.parseInt(new StringBuffer(num.toString()).reverse().toString());
                for(int i = 1; i<nums; i++)
                {
                    temp.append(r);
                }
                for(int i=0;i<temp.length();i++)
                    stack.push(temp.charAt(i));
            }
            else
                stack.push(c);
            count++;
        }
        while(!stack.empty())
            res.append(stack.pop());
        System.out.println(new StringBuffer(res.toString()).reverse().toString());
        return new StringBuffer(res.toString()).reverse().toString();
    }
    public static void main(String[] args)
    {
        no394 t=new no394();
        t.decodeString("30[a]2[bc]");
    }
}
