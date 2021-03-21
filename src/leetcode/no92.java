package leetcode;

public class no92 {
      public static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==right)
                return head;
            ListNode h=new ListNode();
            h.next=head;
            int count=0;
            while(count+1<left)
            {
                count++;h=h.next;
            }
            ListNode pre=h;
            ListNode start=h.next;
            ListNode p1=h.next;
            ListNode now=h.next.next;
            ListNode tp=now.next;
            count++;
            while(count<right)
            {
                count++;
                now.next=p1;
                p1=now;
                now=tp;
                if(tp==null)
                    break;
                tp=tp.next;
            }
            start.next=now;
            pre.next=p1;
            return head;
        }
    public static void main(String[] args)
    {
        no92 t=new no92();
        ListNode h=new ListNode(3);
//        int count=1;
//        ListNode hh=h;
//        while(count<5)
//        {
//            h.next=new ListNode(h.val+1);
//            h=h.next;
//            count++;
//        }
        h.next=new ListNode(5);
        t.reverseBetween(h,1,2);
    }
}
