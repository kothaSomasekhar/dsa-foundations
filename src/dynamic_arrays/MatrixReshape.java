package dynamic_arrays;

public class MatrixReshape {
    public static int[][] reshapeMatrix(int nums[][], int r, int c) {
        int oldrows = nums.length;
        int oldcols = nums[0].length;
        if (oldrows * oldcols != r * c) {
            return nums;
        }
        int[][] newarray = new int[r][c];
        for (int i = 0; i < (r * c ); i++) {
           newarray[(i / c) ][(i % c) ]=nums[i/oldcols][(i % oldcols) ];
        }
        return newarray;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}};
        int[][] newarr = reshapeMatrix(arr, 3, 4);
        for (int i = 0; i < newarr.length; i++) {
            for (int j = 0; j < newarr[0].length; j++) {
                System.out.print(newarr[i][j]);
            }
            System.out.println();
        }
    }
}
