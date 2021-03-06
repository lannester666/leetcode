package leetcode;

import java.util.*;

public class no721 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            List<List<String>> result = new LinkedList<List<String>>();
            int count = 0;
            for (int i = 0; i < accounts.size(); i++)
                count += accounts.get(i).size();
            Union un = new Union(count);
            count = accounts.size();
            for (int i = 0; i < accounts.size(); i++) {
                List<String> temp = accounts.get(i);
                boolean flag = false;
                String same = "";
                for (int j = 1; j < temp.size(); j++) {
                    if (!map.containsKey(temp.get(j))) {
                        map.put(temp.get(j), count);
                        un.union(i, count);
                        count++;
                    } else {
                        same = temp.get(j);
                        int f = un.find(map.get(same));
                        un.union(f, i);
                    }
                }
//                if (flag) {
//                    int f = un.find(map.get(same));
//                    un.union(f, i);
//                }
            }
            Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
            int num = 0;
            for (int i = 0; i < accounts.size(); i++) {
                List<String> temp = accounts.get(i);
                for (int j = 1; j < temp.size(); j++) {
                    String string = temp.get(j);
                    int q = un.find(map.get(string));
                    if (!map1.containsKey(q)) {
                        map1.put(q, num);
                        List<String> temp1 = new LinkedList<String>();
                        temp1.add(accounts.get(q).get(0));
                        temp1.add(string);
                        result.add(temp1);
                        num++;
                    } else
                        result.get(map1.get(q)).add(string);
                }
            }
            for(int i=0;i<result.size();i++)
            {
                removedublicate(result.get(i));
                Collections.sort(result.get(i));
            }
            System.out.println(result);
            return result;
        }
    private void removedublicate(List<String> list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }
    class Union{
        int[] parent;
        public Union(int n)
        {
            parent= new int[n];
            for(int i=0;i<n;i++)
                parent[i] = i;
        }
        public int find(int x)
        {
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y)
        {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty)
                return;
            else
                parent[rooty] = rootx;
        }
    }
//    public static void accountsMerge(List<List<String>> accounts) {
//        List<List<String>> result = new LinkedList<List<String>>();
//        Map<String,Integer> map = new HashMap<String, Integer>();
//        Map<Integer,Integer> map1 = new HashMap<Integer, Integer>();
//        for(int i=0;i<accounts.size();i++)
//        {
//            removedublicate(accounts.get(i));
//            Collections.sort(accounts.get(i));
//            boolean flag = false;
//            int q = 0;
//            List<String> temp = accounts.get(i);
//            for(int j=1;j<temp.size();j++)
//                if(!map.containsKey(temp.get(j)))
//                    map.put(temp.get(j),i);
//                else
//                {
//                    q = map1.get(map.get(temp.get(j)));
//                    flag = true;
//                }
//            if(flag)
//            {
//                for(int k=1;k<temp.size();k++)
//                    result.get(q).add(temp.get(k));
//                map1.put(i,result.size()-1);
//            }
//            else
//            {
//                result.add(temp);
//                map1.put(i,result.size()-1);
//            }
//        }
//        for(int i=0;i<result.size();i++)
//        {
//            removedublicate(result.get(i));
//            Collections.sort(result.get(i));
//        }
//        System.out.println(123);
//    }
//   public static void removedublicate(List<String> list) {
//        HashSet h = new HashSet(list);
//        list.clear();
//        list.addAll(h);
//    }
    public static void main(String[] args)
    {
        List<List<String>> result = new LinkedList<List<String>>();
        no721 n = new no721();
//        [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],
//        ["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
        List<String> temp = Arrays.asList("David","David0@m.co","David1@m.co");
        List arrList = new ArrayList(temp);
        result.add(arrList);
        temp = Arrays.asList("David","David3@m.co","David4@m.co");
        arrList = new ArrayList(temp);
        result.add(arrList);
        temp = Arrays.asList("David","David4@m.co","David5@m.co");
        arrList = new ArrayList(temp);
        result.add(arrList);
        temp = Arrays.asList("David","David2@m.co","David3@m.co");
        arrList = new ArrayList(temp);
        result.add(arrList);
        temp = Arrays.asList("David","David1@m.co","David2@m.co");
        arrList = new ArrayList(temp);
        result.add(arrList);
        n.accountsMerge(result);
    }
}
