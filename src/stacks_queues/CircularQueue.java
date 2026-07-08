package stacks_queues;

public class CircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int currentSize;
    private int capacity;
    public CircularQueue(int k){
        this.capacity=k;
        this.queue=new int[k];
        this.head=0;
        this.tail=-1;
        this.currentSize=0;
    }
    public boolean enqueue(int val){
        if(isFull()){
            return false;
        }
            this.tail=(this.tail+1)%capacity;
            queue[tail]=val;
            currentSize++;
            return true;

    }
    public boolean dequeue(){
        if(isEmpty()){return false;}
            this.head=(this.head+1)%capacity;
            currentSize--;
            return true;


    }
    public int Front(){
        if(isEmpty()){return -1;}
        return queue[head];
    }
    public int Rear(){
        if(isEmpty()){return -1;}
        return queue[tail];
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize==capacity;
    }
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        System.out.println("Enqueue 1: " + cq.enqueue(1));
        System.out.println("Enqueue 2: " + cq.enqueue(2));
        System.out.println("Enqueue 3: " + cq.enqueue(3));
        System.out.println("Enqueue 4 (Full): " + cq.enqueue(4));

        System.out.println("Rear element: " + cq.Rear());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Enqueue 4: " + cq.enqueue(4));
        System.out.println("Rear element now: " + cq.Rear());
    }

}
