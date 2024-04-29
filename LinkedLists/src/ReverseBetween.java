public class ReverseBetween {
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
       listNode.next.next.next.next= new ListNode(5);
      PrintNode(listNode);
      System.out.println();
     
      


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

  public ListNode reverseBetween(ListNode head, int left, int right) {
      if (left == right) {
          return head;
      }
      ListNode curr = head;
      ListNode prev = null;
      for (int i = 0; curr != null && i < left - 1; i++) {
          prev = curr;
          curr = curr.next;

      }
      ListNode last = prev;
      ListNode newEnd = curr;
   
      for (int i = 0; curr != null && i < right - left + 1; i++) {
          ListNode nexListNode = curr.next;
          curr.next = prev;
          prev = curr;
          curr = nexListNode;
          if (curr != null) {
              nexListNode = curr.next;
          }
      }
      if (last != null) {
          last.next = prev;
      }
      else {
          head = prev;
      }
      newEnd.next = curr;
      return head;

  }

  


}
