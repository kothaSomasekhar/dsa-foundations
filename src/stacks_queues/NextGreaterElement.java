package stacks_queues;
import java.util.ArrayDeque;
import java.util.Arrays;
public class NextGreaterElement {

    public static int[] nextGreater(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        Arrays.fill(result,-1);

        for(int i=0;i<n;i++){

            while(stack.peek()!=null && arr[i]>arr[stack.peek()]){
                int val=stack.pop();
                result[val]=arr[i];

            }
            stack.push(i);

        }
        return result;
    }
    public static void main(String[] args) {
        int[] metrics = {4, 5, 2, 25};
        int[] answers = nextGreater(metrics);

        // Expected Output: [5, 25, 25, -1]
        System.out.println("Resolved Metrics: " + Arrays.toString(answers));
    }
}