

public class RotateLLright {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void PrintListNode(ListNode head) {
        ListNode curr = head;
        if (curr == null ) {
            System.out.println("List is Empty");
        }
        while (curr != null) {
            System.out.print(curr.val + " - > ");
            curr = curr.next;
        }
  }

  public static void main(String[] args) {
      ListNode listNode = new ListNode(1);
      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = new ListNode(5);
      PrintListNode(listNode);
      System.out.println();
      PrintListNode(rotateRight(listNode, 2));

  }
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode newTail = head;
        
        int count = 1;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        k = k % count;
        curr.next = head;
        k = count - k;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }
}
