package linked_memory;

public class SinglyLinkedListInversion {
    public static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node reverseList(Node head){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node nextstate=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextstate;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.print("Original: ");
        printList(head); // Output: 10 -> 20 -> 30 -> null

        Node reversedHead = reverseList(head);

        System.out.print("Reversed: ");
        printList(reversedHead); // Expected Output: 30 -> 20 -> 10 -> null
    }
}
