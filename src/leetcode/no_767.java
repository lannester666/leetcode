package leetcode;

import algo.bag_limit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class no_767 {
    static class struct implements Comparable<struct>
    {
        int time;
        char c;
        @Override
        public int compareTo(struct o) {
            return Integer.compare(this.time, o.time);
        }
        struct(char c,int time)
        {
            this.c=c;
            this.time=time;
        }
    }
    public static String reorganizeString(String S) {
        struct[] structs = new struct[26];
        String value="";
        for(int i=0;i<26;i++)
            structs[i]=new struct((char)(i+97),0);
        for(int i=0;i<S.length();i++) {
            int temp = (int) S.charAt(i) - 97;
            structs[temp].time++;
        }
        Arrays.sort(structs);
        int temp = structs[25].time;
        int start=24;
        while(structs[start].time==0)
            start++;
            if(temp>(S.length()+1)/2)
                return "";
            else
            {
                int end=25;
                int count=0;
                boolean flag=false;
                while(count<S.length())
                {
                    if(!flag)
                    {
                        if(end<0)
                            flag=true;

                        else if(structs[end].time>0&&start!=end)
                        {
                            value+=structs[end].c;
                            structs[end].time--;
                            flag=true;
                            count++;
                        }
                        else
                            end--;
                    }
                    else
                    {
                        if(start<0)
                            flag=false;
                        else if(structs[start].time>0&&start!=end)
                        {
                            value+=structs[start].c;
                            structs[start].time--;
                            flag=false;
                            count++;
                        }
                        else
                            start--;
                    }
                }
                return value;
            }

    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s="tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao";
        String temp = reorganizeString(s);

        System.out.println(temp);

    }
}
