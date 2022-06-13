package Linked_List;

public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode ret = null;
        while (head != null) {
            ret = new ListNode(head.val, ret);
            head = head.next;
        }

        return ret;
    }
}
