

public class DetectCycle {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
      ListNode listNode = new ListNode(3);

      listNode.next = new ListNode(2);
      listNode.next.next = new ListNode(0);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = listNode.next;
    //   PrintNode(listNode);
    System.out.println(hasCycle(listNode));
    System.out.println();
    PrintNode(detectFirstCycleNode(listNode));
      
 

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

  public static boolean hasCycle(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          if (slow == fast) {
              return true;
          }
      }
      return false;
  }
     public static ListNode detectFirstCycleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
