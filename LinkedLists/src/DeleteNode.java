public class DeleteNode {
    // no head is given . all nodes are unique and the node is not the last not that is given
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
        ListNode listNode = new ListNode(1);

        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        PrintNode(listNode);
        System.out.println();
        deleteNode(listNode.next.next.next);
       PrintNode(listNode);

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
     
    public static void deleteNode(ListNode node) {
       
        node.val = node.next.val;
        node.next = node.next.next;
 System.gc();
    }
}

