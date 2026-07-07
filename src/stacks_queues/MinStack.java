package stacks_queues;
import java.util.ArrayDeque;
public class MinStack {
    private ArrayDeque<Integer> datastack;
    private ArrayDeque<Integer> minstack;
    public MinStack(){
        datastack=new ArrayDeque<>();
        minstack=new ArrayDeque<>();
    }
    public void push(int val){
        datastack.push(val);
        if(minstack.peek()==null || minstack.peek()>=val ){
            minstack.push(val);
        }
    }
    public void pop(){
        if(datastack.isEmpty()) {
            return;
        }
        int vl=datastack.pop();
        if(minstack.peek()!=null && minstack.peek().equals(vl)){
            minstack.pop();
        }
    }
    public int top() {
        return datastack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);

        System.out.println("Min: " + s.getMin()); // Expected: -3
        s.pop();
        System.out.println("Top: " + s.top());    // Expected: 0
        System.out.println("Min: " + s.getMin()); // Expected: -2
    }
}