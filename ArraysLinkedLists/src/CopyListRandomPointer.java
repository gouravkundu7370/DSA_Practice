

public class CopyListRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public void insertNode(Node head){
        Node temp=head;
        while(temp != null){
         Node copy=new Node(temp.val);
         copy.next=temp.next;
         temp.next=copy;
         temp=temp.next.next;
            
        }
    }
    public void connectrandom(Node head){
        Node temp=head;
        while(temp!=null){
          Node copy=temp.next;
          if(temp.random != null){
           copy.random=temp.random.next;
          }
          temp=temp.next.next;
        }
    }
    public Node getCopyNode(Node head){
        Node dummyNode=new Node(-1);
        Node point=dummyNode;
        Node temp=head;
        while(temp != null){
            point.next=temp.next;
            temp.next=temp.next.next;
            temp=temp.next;
            point=point.next;
        }
        return dummyNode.next;
    }
    public Node copyRandomList(Node head) {
   
   insertNode(head);
   connectrandom(head);
   return getCopyNode(head);



    }
    public static void main(String[] args) {
        System.out.println("");
    }
}
