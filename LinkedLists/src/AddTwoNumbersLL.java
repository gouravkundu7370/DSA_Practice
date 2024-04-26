public class AddTwoNumbersLL {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
     ListNode listNode = new ListNode(1);

      listNode.next = new ListNode(3);
      listNode.next.next = new ListNode(8);
      listNode.next.next.next = new ListNode(1);
      listNode.next.next.next.next = new ListNode(9);
      listNode.next.next.next.next.next = new ListNode(1);
      PrintNode(listNode);
      System.out.println();

      ListNode listNode1 = new ListNode(1);

      listNode1.next = new ListNode(2);
      listNode1.next.next = new ListNode(3);
      listNode1.next.next.next = new ListNode(4);
      listNode1.next.next.next.next = new ListNode(5);
      
      PrintNode(listNode1);
      System.out.println();
      PrintNode(addTwoNumbers(listNode, listNode1));
  
      

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
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dh = new ListNode();
       ListNode temp = dh;
       int carry = 0;
       while (l1 != null || l2 != null || carry != 0) {
           int sum = 0;
           if (l1 != null) {
               sum += l1.val;
               l1 = l1.next;
           }
           if (l2 != null) {
               sum += l2.val;
               l2 = l2.next;
           }
           sum += carry;
           carry = sum / 10;
           ListNode node = new ListNode(sum % 10);
           temp.next = node;
           temp = temp.next;

       }
       return dh.next;

    }

}
