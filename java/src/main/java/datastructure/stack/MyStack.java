package datastructure.stack;

class ListNode {
    Integer val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * Implemented with a LinkedList. Operation at the head.
 */
public class MyStack {

    private ListNode dummy;

    public MyStack() {
        dummy = new ListNode(-1);
    }

    public boolean empty() {
        return dummy.next == null;
    }
    public Integer peek() {
        return empty() ? null : dummy.next.val;
    }
    public Integer pop() {
        if (empty()) {
            return null;
        }
        ListNode node = dummy.next;
        dummy.next = node.next;
        return node.val;
    }
    public Integer push(int val) {
        ListNode next = dummy.next;
        dummy.next = new ListNode(val);
        dummy.next.next = next;
        return val;
    }
}
