package interviewprograms;

public class RemoveDuplicateElementsFromSortedArray {

    public static void main(String[] args) {

        int[] arr = {2, 4, 4, 7, 8, 8};

        int i = 0;
        int j = 1;

        while (j < arr.length) {

            if (arr[i] == arr[j]) {
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }

        int[] nd = new int[i+1];

        for(int x=0;x<nd.length;x++){
            nd[x]=arr[x];
        }

        for(int y=0;y<nd.length;y++){
            System.out.print(nd[y]+" ");
        }
    }
}
