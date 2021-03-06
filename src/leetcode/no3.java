package leetcode;

public class no3 {

        public int lengthOfLongestSubstring(String s) {
            if(s.length()==0)
                return 0;
            String p = "";
            p+=s.charAt(0);
            String result = "";
            for(int i=0;i<s.length()-1;i++)
            {
                boolean flag = true;
                for(int j=0;j<p.length();j++)
                    if(p.charAt(j)==s.charAt(i+1))
                    {
                        flag = false;
                        if(p.length()>result.length())
                            result = p.substring(0);
                            p =p.substring(j+1)+s.charAt(i+1);
                            break;
                    }
                if(flag)
                    p+=s.charAt(i+1);
            }
            if(p.length()>result.length())
                result = p.substring(0);
            System.out.println(result.length());
            return result.length();
        }
    public static void main(String[] args)
    {
        no3 t = new no3();
        t.lengthOfLongestSubstring("ohomm");
    }
}
