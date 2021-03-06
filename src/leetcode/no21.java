package leetcode;

public class no21 {

       static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode node1 = l1;
            ListNode node2 = l2;
            if(node1==null)
                return node2;
            else if(node2==null)
                return node1;
            ListNode solve = new ListNode(0);
            ListNode result = solve;
            while(node1!=null&&node2!=null)
            {
                if(node1==null)
                    sort(solve,node2);
                else if(node2==null)
                    sort(solve,node1);
                else
                {
                    if(node1.val<node2.val)
                        sort(solve,node1);
                    else
                        sort(solve,node2);
                }
            }
            return result.next;
        }
        public void sort(ListNode n1,ListNode n2)
        {
            n1.next=new ListNode(n2.val);
            n1=n1.next;
            n2=n2.next;
        }
        public static void main(String[] args)
        {
            no21 t = new no21();
            ListNode t1 = new ListNode(1);
            t1.next = new ListNode(2);
            t1.next.next = new ListNode(4);
            ListNode t2 = new ListNode(1);
            t2.next = new ListNode(3);
            t2.next.next = new ListNode(4);
            t.mergeTwoLists(t1,t2);
        }
}
