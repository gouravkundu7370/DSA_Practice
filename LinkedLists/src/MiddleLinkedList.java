public class MiddleLinkedList {
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
      PrintNode(middleNode(listNode));

  }
  public static ListNode middleNode(ListNode head) {
      ListNode fast = head;
      ListNode slow = head;
     
      
      while (fast != null && fast.next != null ) {
          slow = slow.next;
          fast = fast.next.next;

      }
      return slow;
    }
   public static void PrintNode(ListNode head) {
      ListNode curr = head;
      if (head == null) {
          System.out.print("List is Empty");
          return;
      }
      while (curr != null ) {
          System.out.print(curr.val + " -> ");
          curr = curr.next;
      }
    }
    
}
