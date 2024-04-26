public class MergeTwoSortedList {
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
      listNode.next.next.next = new ListNode(10);
      listNode.next.next.next.next = new ListNode(11);
      listNode.next.next.next.next.next = new ListNode(19);
      PrintNode(listNode);
      System.out.println();

      ListNode listNode1 = new ListNode(1);

      listNode1.next = new ListNode(2);
      listNode1.next.next = new ListNode(3);
      listNode1.next.next.next = new ListNode(4);
      listNode1.next.next.next.next = new ListNode(5);
      listNode1.next.next.next.next.next = new ListNode(6);
      PrintNode(listNode1);
      System.out.println();
      PrintNode(mergeTwoLists(listNode, listNode1));


  }
   public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     ListNode dh = new ListNode();
        ListNode tail = dh;
    while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }
            else {
                tail.next =list2;
                list2 = list2.next;
                tail = tail.next;
            }

        }
        tail.next = (list1 != null) ? list1 : list2 ;
        return dh.next;
        
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
