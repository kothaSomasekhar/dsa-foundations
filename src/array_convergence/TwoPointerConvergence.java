package array_convergence;
public class TwoPointerConvergence {

    public static int findMaximumVolume(int[] heights) {

        // Implement your convergence logic here
        int n=heights.length;
        int left=0;
        int right=n-1;
        int maxvol=0;
        while(left<right){
            int effectiveheight=heights[left]>heights[right]?heights[left]:heights[right];
            int width=right-left;
            int vol=effectiveheight*width;
            int rightvalue=heights[right];
            int leftvalue=heights[left];
            if(vol>maxvol){
                maxvol=vol;
            }
            if( rightvalue>leftvalue ) {
                left++;
            }else{
                right--;
            }


        }
        return maxvol;




    }

    public static void main(String[] args) {
        int[] heights={60,10,20,50,60,40};
        int ans=findMaximumVolume(heights);
        System.out.print(ans);

    }
}
