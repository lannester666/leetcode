package leetcode;

public class no1157 {
    class segment_tree
    {
        public int start,end,candidate,count;
        public segment_tree left,right;
        public segment_tree(){};
        public segment_tree(int start,int end,int candidate)
        {
            this.start=start;
            this.end=end;
            this.candidate=candidate;
            this.count=1;
            this.left=null;
            this.right=null;
        }
        public segment_tree build(int[] A)
        { return buildhelper(0,A.length-1,A); }
        public segment_tree buildhelper(int left,int right,int[] A)
        {
            if(left>right)
                return null;
            segment_tree root=new segment_tree(left,right,A[left]);
            if(left==right)
                return root;
            int mid=(left+right)/2;
            root.left=buildhelper(left,mid,A);
            root.right=buildhelper(mid+1,right,A);
            if(root.left.candidate==root.right.candidate)
            {
                root.candidate=root.left.candidate;
                root.count=root.left.count+root.right.count;
            }
            else if(root.left.count>root.right.count)
            {
                root.candidate=root.left.candidate;
                root.count=root.left.count-root.right.count;
            }
            else
            {
                root.candidate=root.right.candidate;
                root.count=root.right.count-root.left.count;
            }
            return root;
        }
        public segment_tree query(segment_tree root,int start,int end)
        {
            if(root.start>end||root.end<start)
                return null;
            if(start<=root.start&&root.end<=end)
                return root;
            int mid=(root.start+root.end)/2;
            int count=0;
            segment_tree left=query(root.left,start,mid);
            segment_tree right=query(root.right,mid+1,end);
            if(left==null&&right==null)
                return root;
            else if(left==null)
            {
                return root.right;
            }
            else if(right==null)
                return root.left;
            else
            {
                if     (root.left.candidate==root.right.candidate)
                {
                    root.candidate=root.left.candidate;
                    root.count=root.left.count+root.right.count;
                }
                else if(root.left.count>root.right.count)
                {
                    root.candidate=root.left.candidate;
                    root.count=root.left.count-root.right.count;
                }
                else
                {
                    root.candidate=root.right.candidate;
                    root.count=root.right.count-root.left.count;
                }
                return root;
            }
        }
    }
    private segment_tree tree;
    public no1157(int[] arr) {
       segment_tree t=new segment_tree();
        this.tree=t.build(arr);
    }

    public int query(int left, int right, int threshold) {
        segment_tree temp=tree.query(tree,left,right);
            if((temp.count+(right-left)/2)>=threshold)
                return temp.candidate;
            else return -1;
    }
    public static void main(String[] args)
    {
        no1157 t=new no1157(new int[]{1,1,2,2,1,1});
        t.query(0,3,3);
    }
}
