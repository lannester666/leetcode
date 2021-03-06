package leetcode;

public class no76 {
        public String minWindow(String s, String t) {
            int m=s.length();
            int n = t.length();
            if(n>m)
                return "";
            int[] aux=new int[52];
            for(int i=0;i<n;i++)
                change(aux,t.charAt(i));
            int start=0;
            int end=n;
            int[] aux1=new int[52];
            for(int i=0;i<n;i++)
                change(aux1,s.charAt(i));
            while(end<m)
            {
                if(contains(aux,aux1))
                    break;
                change(aux1,s.charAt(end));
                end++;
            }
            result res=new result(0,end-1,end);
            while(contains(aux,aux1))
            {
                if(end-start<res.len)
                {
                    res.start=start;
                    res.end=end-1;
                    res.len=end-start;
                }
                change1(aux1,s.charAt(start));
                while(!contains(aux,aux1)&&end<m)
                {
                    change(aux1,s.charAt(end));
                    end++;
                }
                start++;
            }
            if(end-start+1<res.len)
            {
                res.start=start;
                res.end=end;
                res.len=end-start+1;
            }
            return s.substring(res.start,res.end+1);
        }
        class result{
            int start;
            int end;
            int len;
            public result(int start,int end,int len)
            {
                this.start=start;
                this.end=end;
                this.len=len;
            }
        }
        void change(int[] aux,char c)
        {
            if(c<97)
                aux[c-65]++;
            else
                aux[c-71]++;
        }
        void change1(int[] aux,char c)
        {
            if(c<97)
                aux[c-65]--;
            else
                aux[c-71]--;
        }
        boolean contains(int[] aux1,int[] aux2)
        {
            boolean flag=true;
            for(int i=0;i<52;i++)
                if(aux2[i]<aux1[i])
                {
                    flag=false;
                    break;
                }
            return flag;
        }
    public static void main(String[] args)
    {
        no76 t=new no76();
        String s=t.minWindow("ADOBECODEBANC","ABC");
        for(int i=0;i<s.length();i++)
            System.out.println(s.charAt(i));
    }
}
