package stacks_queues;
import java.util.ArrayDeque;
import java.util.Arrays;
public class SlidingWindowMax {
    public static int[] maxslidingwindow(int[] nums,int k){
        if(nums == null || nums.length==0) {
            return new int[0];
        }
        int n=nums.length;
        int[] result=new int[n-k+1];
        int re=0;
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n;i++){

            if(!deque.isEmpty() && deque.peekFirst()<=(i-k)){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]) {
                deque.pollLast();

            }
            deque.addLast(i);
            if(!deque.isEmpty() && i>=k-1 ){
                int val=deque.peekFirst();
                result[re++]=nums[val];

            }
        }
        return result;

    }public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] maxes = maxslidingwindow(nums, k);
        // Expected Output: [3, 3, 5, 5, 6, 7]
        System.out.println("Window Maximums: " + Arrays.toString(maxes));
    }
}
