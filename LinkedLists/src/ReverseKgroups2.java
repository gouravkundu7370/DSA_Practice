public class ReverseKgroups2 {
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
      PrintNode(reverseKGroup1(listNode, 2));
      


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
    
 public static ListNode reverseKGroup1(ListNode head, int k) {
      ListNode preTail = null; // stores the tail node of previous LL.
      ListNode curHead = head; // stores the head node of current LL
      ListNode curTail = head; // stores the tail node of current LL

      ListNode nextHead = null; // stores the head node of next LL

      while (curHead != null) {
          // initialize count from 1
          int count = 1;

          // iterate the LL untill count becomes k or we reach the last node.
          while (curTail.next != null && count < k) {
              curTail = curTail.next;
              count++;
          }

          if (count != k) {
              break;
          }

          // set the nextHead pointer to the head of the next LL.
          nextHead = curTail.next;

          // detach the RHS of the current LL.
          curTail.next = null;

          // detach the LHS of the current LL.
          if (preTail != null) {
              preTail.next = null;
          }

          // after reversing the current LL, curHead becomes the new tail.
          // and curTail becomes the new head.

          curTail = reverse(curHead);

          // attach the LHS
          if (preTail != null) {
              preTail.next = curTail;
          } else {
              // if preTail is null then we have reversed the first LL
              // so store the reference of curHead in original head pointer.
              head = curTail;
          }

          // attach the RHS
          curHead.next = nextHead;

          // update the pointer
          preTail = curHead;
          curHead = nextHead;
          curTail = nextHead;
      }

      return head;
  }


    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        if (head == null) {
            return null;
        }
        while (curr != null) {
            ListNode nexListNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexListNode;
            if (curr != null) {
                nexListNode = curr.next;
            }
        }
        return prev;

}
}
