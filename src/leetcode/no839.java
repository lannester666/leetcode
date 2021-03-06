package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class no839 {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            if(n==1)
                return 0;
            Unionset un = new Unionset(n);
            for(int i = 0;i<n;i++)
                for(int j = i+1;j<n;j++)
                    if(!un.isconnected(i,j))
                    {
                        if(issame(strs[i],strs[j]))
                            un.union(i,j);
                    }
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++) {
                int temp = un.find(i);
                if (!map.containsKey(temp))
                    map.put(temp, 0);
            }
            return map.size();
        }
        public boolean issame(String str1,String str2)
        {
            int dif = 0;
            for(int i=0;i<str1.length();i++)
                if(str1.charAt(i)!=str2.charAt(i))
                    dif++;
            if(dif==0||dif==2)
                return true;
            else
                return false;
        }
        class Unionset{
            int[] parent;
            int[] rank;
            public Unionset(int n)
            {
                this.parent = new int[n];
                for(int i=0 ; i<n;i++)
                    this.parent[i] = i;
                this.rank = new int[n];
                Arrays.fill(this.rank,1);
            }
            public int find(int x)
            {
                if(parent[x]!=x)
                    parent[x] = find(parent[x]);
                return parent[x];
            }
            public boolean union(int x, int y)
            {
                int rx = find(x);
                int ry = find(y);
                if(rx==ry)
                    return true;
                if(rank[rx]<rank[ry])
                {
                    int temp = rx;
                    rx = ry;
                    ry = temp;
                }
                rank[rx]+=rank[ry];
                parent[ry] = rx;
                return false;
            }
            public boolean isconnected(int x, int y)
            {return find(x)==find(y);}
        }
    public static void main(String[] args)
    {
        no839 t = new no839();
        String[] s = new String[]{"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic",
            "ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"};
        t.numSimilarGroups(s);
    }
}
