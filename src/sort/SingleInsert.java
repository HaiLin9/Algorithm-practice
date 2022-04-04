package sort;

import java.util.Arrays;

public class SingleInsert {


    public static void main(String[] args) {
        int[] arr= {3,1,4,1,5,9,2,7,6,8};
        singleInsert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void singleInsert(int[] arr) {
        for(int i=1; i<arr.length ;i++) {
            for(int j = i;j>0 && arr[j]<arr[j-1];j--){
                int temp=arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}
