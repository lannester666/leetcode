package leetcode;

public class no437 {
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


        int count=0;
        int ans;
        public int pathSum(TreeNode root, int sum) {
            ans=sum;
            dfs(root,sum);
            return count;
        }
        public void dfs(TreeNode root,int remain)
        {
            if(root==null)
                return;
            if(remain==root.val)
                count++;
            dfs(root.left,ans);
            dfs(root.right,ans);
            dfs(root.left,remain-root.val);
            dfs(root.right,remain-root.val);
        }
    public static void main(String[] args)
    {
        no437 t=new no437();
        TreeNode p=new TreeNode(1);
        p.right=new TreeNode(2);
        p.right.right=new TreeNode(3);
        t.pathSum(p,3);
    }
}
