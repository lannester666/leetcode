package leetcode;

public class no124 {


      public class TreeNode {
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

    class Solution {
        int max=-1000;
        public int maxPathSum(TreeNode root) {
            max=Math.max(max,root.val);
            if(root.left==null&&root.right==null)
                return root.val;
            int temp=findmax(root);
            return Math.max(max,temp);
        }
        int findmax(TreeNode root)
        {
            if(root.left==null&&root.right==null)
                return root.val;
            max=Math.max(max,root.val);
            int left,right;
            left=-1000;right=-1000;
            if(root.left!=null)
                left=Math.max(findmax(root.left),left);
            if(root.right!=null)
                right=Math.max(findmax(root.right),right);
            int temp1=Math.max(left,right);
            max=Math.max(max,left+right+root.val);
            return Math.max(root.val,root.val+temp1);
        }
    }
}
