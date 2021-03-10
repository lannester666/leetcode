package leetcode;

import java.util.Stack;

public class no1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        int n=S.length();
        stack.push(S.charAt(0));
        int count=1;
        while(count<n)
        {
            if(stack.empty())
            {
                stack.push(S.charAt(count));
                count++;
                continue;
            }
            boolean flag=false;
            while(count<n&&S.charAt(count)==stack.peek())
            {
                count++;flag=true;
            }
            if(flag)
                stack.pop();
            else
                stack.push(S.charAt(count));
            count++;
        }
        StringBuilder res=new StringBuilder();
        while(!stack.empty())
        res.append(stack.pop());
        return res.reverse().toString();

    }
}
