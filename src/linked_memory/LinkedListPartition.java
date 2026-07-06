package linked_memory;

public class LinkedListPartition {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node partition(Node head,int x){
        Node smallerhead=new Node(0);
        Node greaterhead=new Node(0);

        Node small=smallerhead;
        Node great=greaterhead;

        Node curr=head;
        while(curr!=null){
            if(curr.data<x){
                small.next=curr;
                small=small.next;
            }else{
                great.next=curr;
                great=great.next;
            }
            curr=curr.next;
        }
        great.next=null;
        small.next=greaterhead.next;
        return smallerhead.next;
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
        Node head = new Node(14);
        head.next = new Node(24);
        head.next.next = new Node(10);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(34);

        System.out.print("Before Partition: ");
        printList(head); // Output: 14 -> 24 -> 10 -> 2 -> 34 -> null

        Node partitionedHead = partition(head, 20);

        System.out.print("After Partition:  ");
        printList(partitionedHead); // Expected Output: 14 -> 10 -> 2 -> 24 -> 34 -> null
    }



}
