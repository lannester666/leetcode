package leetcode;

import java.util.Stack;

public class no224 {
    public int calculate(String s) {
        int res=0;
        int n=s.length();
        Stack<loc> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int index=0;
        while(index<n)
        {
            if(s.charAt(index)=='(')
                stack2.push(index);
            else if(s.charAt(index)==' ')
            {index++;continue;}
            else if(s.charAt(index)==')')
            {
                int start=stack2.pop();
                int tp=0;
                while(stack1.peek().index>start)
                {
                    String temp=stack1.pop().s.toString();
                    if(stack1.empty()||stack1.peek().index<start)
                    {
                        tp+=Integer.parseInt(temp);
                        stack1.push(new loc(String.valueOf(tp),start));
                        break;
                    }
                    if(s.charAt(stack1.peek().index)=='+')
                    {
                        stack1.pop();
                        tp+=Integer.parseInt(temp);
                    }
                    else if(s.charAt(stack1.peek().index)=='-')
                    {
                        stack1.pop();
                        tp-=Integer.parseInt(temp);
                    }
                }
            }
            else
            {

                char c=s.charAt(index);
                if(c=='+'||c=='-')
                    stack1.push(new loc(c,index));
                else
                {
                    StringBuilder temp = new StringBuilder();
                    while(index<n&&s.charAt(index)>='0'&&s.charAt(index)<='9')
                    {temp.append(s.charAt(index));index++;}
                    stack1.push(new loc(temp.toString(),index));
                    continue;
                }

            }
            index++;
        }
        while(!stack1.empty())
        {
            String temp=stack1.pop().s.toString();
            if(stack1.empty())
            {
                res+=Integer.parseInt(temp);
                break;
            }
            else
            {
                String symbol=stack1.pop().s.toString();
                if(symbol.equals("+"))
                    res+=Integer.parseInt(temp);
                else
                    res-=Integer.parseInt(temp);
            }
        }
        return res;
    }
    class loc{
        StringBuilder s=new StringBuilder();
        int index;
        public loc(char c,int index)
        {
            this.index=index;
            s.append(c);
        }
        public loc(String c,int index)
        {
            this.index=index;
            s.append(c);
        }
    }
    public static void main(String[] args)
    {
        no224 t=new no224();
        System.out.println(t.calculate("16 + 17"));
    }
}
