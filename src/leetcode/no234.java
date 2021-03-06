package leetcode;

public class no234 {
static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
        public boolean isPalindrome(ListNode head) {
            if(head==null||head.next==null)
                return true;
            ListNode slow=head;
            ListNode fast=head;
            ListNode slow_pre=head;
            ListNode slow_next=head.next;
            while(fast.next!=null)
            {
                if(fast.next.next==null)
                {
                    while(slow_next!=null&&slow!=null)
                    {
                        if(slow.val!=slow_next.val)
                        {
                            return false;
                        }
                        else
                        {
                            slow_next=slow_next.next;
                            slow=slow.next;
                        }
                    }
                    return true;
                }
                else
                {
                    fast=fast.next.next;
                }
                slow_pre=slow;
                slow=slow_next;
                slow_next=slow_next.next;
                slow.next=slow_pre;

            }
            while(slow_pre!=null&&slow_next!=null)
            {
                if(slow_next.val!=slow_pre.val)
                {
                    return false;
                }
                else
                {
                    slow_pre=slow_pre.next;
                    slow_next=slow_next.next;
                }
            }
            return  true;
        }
        public static void main(String[] args)
        {
            ListNode t=new ListNode(1);
            t.next=new ListNode(2);
            t.next.next=new ListNode(2);
            t.next.next.next=new ListNode(1);
            no234 m=new no234();
            System.out.println( m.isPalindrome(t));
        }
    }

