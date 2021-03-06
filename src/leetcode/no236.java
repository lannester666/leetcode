package leetcode;

import java.util.ArrayList;
import java.util.List;

public class no236 {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<Boolean> list1=new ArrayList<>();
            List<Boolean> list2=new ArrayList<>();
            Boolean[] flag1=new Boolean[1];
            flag1[0]=false;
            Boolean[] flag2=new Boolean[1];
            flag2[0]=false;
            find(root,p,list1,0,flag1);
            find(root,q,list2,0,flag2);
            int i=0;
            List<Boolean> l=new ArrayList<>();
            while(i<list1.size()&&i<list2.size())
            {
                if(list1.get(i)==list2.get(i))
                    l.add(list1.get(i));
                else
                    break;
                i++;
            }
            TreeNode res=root;
            for(int j=0;j<l.size();j++)
                if(l.get(j))
                    res=root.left;
                else
                    res=root.right;
            return res;
        }
        void find(TreeNode root,TreeNode target,List<Boolean> list,int count,Boolean[] flag)
        {
            if(flag[0]||root==null)
                return;
            if(root==target)
            {
                flag[0]=true;
                return;
            }
            if(list.size()>=count+1)
            list.set(count,true);
            else
                list.add(true);
            find(root.left,target,list,count+1,flag);
            if(flag[0])
                return;
            if(list.size()>=count+1)
                list.set(count,false);
            else
                list.add(false);
            find(root.right,target,list,count+1,flag);
            return;
        }
    public static void main(String[] args)
    {
       TreeNode t=new TreeNode(1);
       t.left=new TreeNode(2);
       no236 p=new no236();
       p.lowestCommonAncestor(t,t,t.left);

    }
}
