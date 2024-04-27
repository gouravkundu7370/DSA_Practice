public class IntersectionPoint {
    
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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);

      listNode.next = new ListNode(1);
      listNode.next.next = new ListNode(8);
      listNode.next.next.next = new ListNode(4);
      listNode.next.next.next.next = new ListNode(5);
      
      PrintNode(listNode);
      System.out.println();

      ListNode listNode1 = new ListNode(5);

      listNode1.next = new ListNode(6);
      listNode1.next.next = new ListNode(1);
      listNode1.next.next.next = listNode.next.next;
      PrintNode(listNode1);
      System.out.println();
      PrintNode(getIntersectionNode(listNode, listNode1));
      
      
     

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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode dh1 = headA;
        ListNode dh2 = headB;
        while (dh1 != dh2) {
            dh1 = dh1 == null ? headB : dh1.next;
            dh2 = dh2 == null ? headA : dh2.next;

        }
        return dh1;

        

    }
}
