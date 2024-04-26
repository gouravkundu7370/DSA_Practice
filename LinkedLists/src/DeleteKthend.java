public class DeleteKthend {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
      ListNode listNode = new ListNode(1);

      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(3);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = new ListNode(5);
      listNode.next.next.next.next.next = new ListNode(6);
      PrintNode(listNode);
      System.out.println();
      PrintNode(removeNthFromEnd(listNode, 0));
      

  }

  public static void PrintNode(ListNode head) {
      ListNode curr = head;
      if (head == null) {
          System.out.print("List is Empty");
          return;
      }
      while (curr != null) {
          System.out.print(curr.val + " -> ");
          curr = curr.next;
      }
  }

public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dh = new ListNode();
      ListNode temp = head;
      int total = 0;
      while (temp != null) {
          total += 1;
          temp = temp.next;

      }
      int deleteNode = total - n ;
      temp = dh;
      temp.next = head;
      for (int i = 0; i < deleteNode; i++) {
          temp = temp.next;
      }
      if (temp.next != null) {
          temp.next = temp.next.next;
      }
      return dh.next;
    }
}
