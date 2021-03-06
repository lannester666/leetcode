package leetcode;

import java.util.*;

public class no1178 {
    TrieNode root;
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        root=new TrieNode();
        for(String word:words)
        {
            char[] aux=word.toCharArray();
            String aux1=removedublicate(aux);
            aux=aux1.toCharArray();
            Arrays.sort(aux);
            StringBuilder res=new StringBuilder();
            for(char c:aux)
                res.append(c);
            add(root, res.toString());
        }
        List<Integer> res=new ArrayList<>();
        for(String puzzle:puzzles)
        {
            char aux=puzzle.charAt(0);
            char[] aux1=puzzle.toCharArray();
            Arrays.sort(aux1);
            int tp=search(root,aux,new String(aux1),0);
            res.add(tp);
        }
        for(Integer i:res)
            System.out.println(i);
        return res;
    }
    private String removedublicate(char[] word)
    {
        StringBuilder res= new StringBuilder();
        HashSet<Character> h=new HashSet<>();
        for (char value : word) h.add(value);
        for(Character c:h)
            res.append(c);
        return res.toString();
    }
    public void add(TrieNode root,String word)
    {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
            char aux=word.charAt(i);
            if(temp.links[aux-'a']==null)
                temp.links[aux-'a']=new TrieNode();
            temp=temp.links[aux-'a'];
        }
        temp.frequency++;
    }
    public int search(TrieNode root,char require,String puzzle,int pos)
    {
        if(root==null)
            return 0;
        if(pos==7)
            return root.frequency;
        int ret=search(root.links[puzzle.charAt(pos)-'a'],require,puzzle,pos+1);//选择pos对应的puzzle上的字母
        if(puzzle.charAt(pos)!=require)
            ret+=search(root,require,puzzle,pos+1);//不选择
        return ret;
    }
    class TrieNode
    {
        TrieNode[] links;
        int frequency;
        public TrieNode(){
            this.links=new TrieNode[26];
            frequency=0;
        }
    }
    public static void main(String[] args)
    {
        no1178 t=new no1178();
        t.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"});

    }
}
