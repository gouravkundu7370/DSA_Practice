public class ReverseLinkedList {
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
      PrintNode(listNode);
      System.out.println();
      PrintNode(reverseList(listNode));


  }

  public static ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
          ListNode temp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = temp;
      }
      return prev;
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
