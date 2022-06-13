package Linked_List;

public class Merge_Two_Linked_List {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null && list2 != null)
            return list2;
        if (list1 != null && list2 == null)
            return list1;

        ListNode head;

        if (list1.val > list2.val) {
            head = new ListNode(list2.val);
            list2 = list2.next;
        } else {
            head = new ListNode(list1.val);
            list1 = list1.next;
        }

        ListNode main = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                main.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                main.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            main = main.next;
        }

        if (list1 != null) {
            main.next = list1;
        } else if (list2 != null) {
            main.next = list2;
        }

        return head;
    }
}
