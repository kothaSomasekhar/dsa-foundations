package array_partition;
import java.util.Arrays;

public class ThreeWayPartition {
    public static void swap(int[] arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    public static void partition(int[] arr,int pivot){
        if(arr==null || arr.length<=1){
            return;
        }
     int n=arr.length;
     int low=0;
     int mid=0;
     int high=n-1;
     while(mid<=high){
         int currval=arr[mid];
         if(currval<pivot){
             swap(arr,mid,low);
             mid++;
             low++;
         } else if(currval==pivot) {
             mid++;
         } else{
             swap(arr,mid,high);
             high--;
         }
     }

    }

    public static void main(String[] args) {
        int[] arr={70,80,10,20,50,60};
        System.out.println(java.util.Arrays.toString(arr));
        partition(arr,50);
        System.out.println(java.util.Arrays.toString(arr));

    }



}
