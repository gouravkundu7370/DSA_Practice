public class isPalindromeLL {
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
      listNode.next.next = new ListNode(2);
      listNode.next.next.next = new ListNode(1);
      PrintNode(listNode);
    System.out.println();
      System.out.println(isPalindrome(listNode));

  }
  
  public static boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
          return true;
      }
      ListNode slow = head;
      ListNode fast = head;
      while (fast.next != null && fast.next.next != null) {
          slow = slow.next;
          fast = fast.next.next;

      }
      slow.next = reverseList(slow.next);
      slow = slow.next;

      while (slow != null) {
          if (head.val != slow.val) {
              return false;
          }
          head = head.next;
          slow = slow.next;
      }
      
      return true;
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

