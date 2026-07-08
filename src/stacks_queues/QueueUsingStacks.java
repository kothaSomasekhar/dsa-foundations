package stacks_queues;
import java.util.ArrayDeque;
public class QueueUsingStacks {
    private ArrayDeque<Integer> inputstack;
    private ArrayDeque<Integer> outputstack;
    public QueueUsingStacks(){
        inputstack=new ArrayDeque<>();
        outputstack=new ArrayDeque<>();
    }
    public void enqueue(int x){
        inputstack.push(x);
    }
    public int dequeue(){
        if(isempty()){
            throw new IllegalStateException("Queue Underflow: Pipeline is empty.");
        }
        if(outputstack.isEmpty()){
            shiftstacks();
        }
        return outputstack.pop();
    }
    public int peek(){
        if(isempty()){
            throw new IllegalStateException("Queue is empty");
        }
        if(outputstack.isEmpty()){
            shiftstacks();
        }
        return outputstack.peek();
    }
    public boolean isempty(){
        return outputstack.isEmpty() && inputstack.isEmpty();
    }

    private void shiftstacks(){
        if(outputstack.isEmpty()){
            while(!inputstack.isEmpty()){
                outputstack.push(inputstack.pop());
            }
        }
    }
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        System.out.println("Enqueuing elements: 10, 20, 30");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front Element (Peek): " + queue.peek()); // Expected: 10

        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 10
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 20

        System.out.println("Enqueuing element: 40");
        queue.enqueue(40);

        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 30
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 40
    }
}
