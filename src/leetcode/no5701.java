package leetcode;

public class no5701 {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        int flag=0;
        int pre=0,next=0;
        for(int i=0;i<n;i++)
            if(s1.charAt(i)!=s2.charAt(i)&&flag==0)
            {
                flag++;
                pre=i;
            }
            else if(s1.charAt(i)!=s2.charAt(i)&&flag==1)
            {
                flag++;
                next=i;
            }
            else if(s1.charAt(i)!=s2.charAt(i)&&flag==2)
                return false;
        if(flag==0)
            return true;
        if(s1.charAt(next)==s2.charAt(pre)&&s1.charAt(pre)==s1.charAt(next))
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        no5701 t=new no5701();
        t.areAlmostEqual("bank","kanb");
    }
}
