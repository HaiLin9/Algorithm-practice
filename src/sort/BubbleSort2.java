package sort;

import java.util.Arrays;

public class BubbleSort2 {

    public static void main(String[] args) {
        int[] arr= {3,1,4,1,5,9,2,7,6,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for(int i=1;i<= arr.length-1;i++){
            boolean isSorted = true;
            for(int j=0;j< arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (isSorted){
                return;
            }
        }
    }
}
