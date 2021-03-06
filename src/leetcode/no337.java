package leetcode;

public class no337 {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        int max=0;
        public int rob(TreeNode root) {
            if(root==null)
                return 0;
            return find(root,false,0);
        }
        public int find(TreeNode root,boolean pre,int sum)
        {
            if(root==null)
                return sum;
            if(pre)
            {
                int left=find(root.left,false,sum);
                return find(root.right,false,left);
            }
            else
            {
                int left=find(root.left,true,sum+root.val);
                int res=find(root.right,true,left);
                int left1=find(root.left,false,sum);
                return (Math.max(res,find(root.right,false,left1)));
            }
        }
    public static void main(String[] args)
    {
        no337 t=new no337();
        TreeNode p=new TreeNode(3);
        p.left=new TreeNode(2);
        p.left.right=new TreeNode(3);
        p.right=new TreeNode(3);
        p.right.right=new TreeNode(1);
        t.rob(p);
    }
}
