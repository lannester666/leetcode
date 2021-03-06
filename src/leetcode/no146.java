package leetcode;

import java.util.HashMap;
import java.util.Map;

public class no146 {
        private Map<Integer, Integer> map;
        private int size;
        private ListNode head;
        private ListNode pointer;
        class ListNode
        {
            int val;
            ListNode next;
            ListNode(int val)
            {
                this.val=val;
                this.next=null;
            }
        }
        public no146(int capacity) {
            this.size=capacity;
            this.map=new HashMap<>();
            this.head=new ListNode(0);
            this.pointer=head;
        }

        public int get(int key) {
            if(map.containsKey(key))
            {
                if(pointer.next.next!=null)
                {
                    head.next=pointer.next;
                    head=head.next;
                    pointer.next=pointer.next.next;
                    head.next=null;
                }
                return map.get(key);
            }
            else
                return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                if(pointer.next.next!=null)
                {
                    head.next=pointer.next;
                    head=head.next;
                    pointer.next=pointer.next.next;
                    head.next=null;
                }
                map.put(key, value);
            }
            else
            {
                if(map.size()<size)
                {
                    map.put(key,value);
                    head.next=new ListNode(key);
                    head=head.next;
                }
                else{
                    map.remove(pointer.next.val);
                    pointer=pointer.next;
                    map.put(key,value);
                    head.next=new ListNode(key);
                    head=head.next;
                }
            }
        }
    public static void main(String[] args)
    {
        no146 t =new no146(2);
        t.put(2,1);
        t.put(3,2);
        t.get(3);
        t.get(2);
        t.put(4,3);
        t.get(2);
        t.get(3);
        t.get(4);
        int p=3,q=4;
    }
}
