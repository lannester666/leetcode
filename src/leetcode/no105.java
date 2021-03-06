package leetcode;

import java.util.HashMap;
import java.util.Map;

public class no105 {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n=preorder.length;
            if(n==0)
                return null;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++)
                map.put(inorder[i],i);
            return backtrace(0,n-1,0,n-1,preorder,inorder,map);
        }
        TreeNode backtrace(int prestart,int preend,int instart,int inend,int[] preorder,int[] inorder,Map<Integer,Integer> map)
        {
            if(prestart<preend)
                return null;
            TreeNode root= new TreeNode(preorder[prestart]);
            int temp=map.get(preorder[prestart])-instart;
            root.left=backtrace(prestart+1,prestart+temp,instart,temp-1,preorder,inorder,map);
            root.right=backtrace(prestart+temp+1,preend,instart+temp+1,inend,preorder,inorder,map);
            return root;
        }
        public static void main(String[] args)
        {
            no105 t = new no105();
            t.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        }
    }

