package lovebabbardasastructures.arrays.matrix;

public class SpiralTraversalClockWiseDirection {

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};

        int minR=0;
        int maxC=arr[0].length-1;
        int maxR= arr.length-1;
        int minC=0;
        int count=0;

        while(count<arr.length*4) {
            //tw
            for (int i = minC, j = minR; i <= maxC; i++) {
                System.out.print(arr[j][i] + " ");
                count++;
            }
            minR++;

            //rw
            for (int i = minR, j = maxC; i <= maxR; i++) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            maxC--;
            //bw
            for (int i = maxC, j = maxR; i >= minC; i--) {
                System.out.print(arr[j][i] + " ");
                count++;
            }
            maxR--;
            //lw
            for (int i = maxR, j = minC; i >= minR; i--) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            minC++;
        }
    }
}
