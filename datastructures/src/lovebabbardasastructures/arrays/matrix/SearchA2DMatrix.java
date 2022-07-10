package lovebabbardasastructures.arrays.matrix;

public class SearchA2DMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1, 3, 5, 7},
                       {10, 11, 16, 20},
                       {23, 30, 34, 60}};
        findTarget(arr);
    }
    private static void findTarget(int[][] arr) {
        int target = 34;
        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (target == arr[i][j]) {
                System.out.print(i + " , " + j);
                return;
            } else if (target < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
    }
}
