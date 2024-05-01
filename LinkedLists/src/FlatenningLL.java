public class FlatenningLL {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
 public static Node flatten(Node root)
 {

     if (root == null || root.next == null) {
         return root;
     }
     root.next = flatten(root.next);
     root = mergeTwoSorteList(root, root.next);
     return root;

 }

 public static Node mergeTwoSorteList(Node a, Node b) {

     Node temp = new Node(0);
     Node res = temp;
     while (a != null && b != null) {
         if (a.data < b.data) {

             temp.bottom = a;
             temp = temp.bottom;
             a = a.bottom;
         } else {
             temp.bottom = b;
             temp = temp.bottom;
             b = b.bottom;
         }
     }
     if (a != null) {
         temp.bottom = a;

     } else {
         temp.bottom = b;
     }
     return res.bottom;
 }
    public static void PrintNode(Node head) {
        Node curr = head;
        if (head == null) {
            System.out.print("List is Empty");
            return;
        }
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.bottom;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.bottom = new Node(2);
        node.bottom.bottom = new Node(5);
        node.next = new Node(4);
        node.next.bottom = new Node(10);
        node.next.next = new Node(20);
        node.next.next.next = new Node(22);
        node.next.next.next.bottom = new Node(25);

        PrintNode(flatten(node));
    }
}
