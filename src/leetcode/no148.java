package leetcode;

public class no148 {
         static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail)
    {
        if(head==null)
            return head;
        if(head.next==tail)
        {
            head.next=null;
            return head;//若链表只含一个元素及以下，则不需要进行排序
        }
        ListNode fast=head,slow=head;
        while(fast!=tail)
        {
            fast=fast.next;
            slow=slow.next;
            if(fast!=tail)
                fast=fast.next;
        }
        ListNode mid=slow;
        ListNode list1=sortList(head,mid);
        ListNode list2=sortList(mid.next,fast);
        ListNode sorted=merge(list1,list2);
        return sorted;
    }
    public ListNode merge(ListNode head1,ListNode head2)
    {
        ListNode dummynode=new ListNode();
        ListNode temp=dummynode,temp1=head1,temp2=head2;
        while(temp1!=null&&temp2!=null)
        {
            if(temp1.val<temp2.val)
            {
                temp.next=temp1;
                temp=temp.next;
                temp1=temp1.next;
            }
            else
            {
                temp.next=temp2;
                temp2=temp2.next;
                temp=temp.next;
            }
        }
        if(temp1!=null)
        {
            temp.next=temp1;
        }
        if(temp2!=null)
        {
            temp.next=temp2;
        }
        return dummynode.next;
    }
    public static void main(String[] args)
    {
        ListNode t=new ListNode(4);
        t.next=new ListNode(2);
        t.next.next=new ListNode(1);
        t.next.next.next=new ListNode(3);
        no148 q= new no148();
        q.sortList(t);
    }
}
