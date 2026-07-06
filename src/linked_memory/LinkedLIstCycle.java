package linked_memory;

public class LinkedLIstCycle {
    public static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static boolean hasCycle(Node head){
        if(head==null || head.next==null){
            return false;
        }
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Creating a structural cycle: 40 points back to 20
        node4.next = node2;

        System.out.println("Cycle detected: " + hasCycle(head)); // Expected: true
    }
}
