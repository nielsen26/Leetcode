package Linked_List;

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head.next;
        ListNode fast = head.next;
        if (slow == null)
            return false;
        fast = fast.next;

        while (true) {
            if (fast == null)
                return false;
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                return false;
            fast = fast.next;
        }
    }
}
