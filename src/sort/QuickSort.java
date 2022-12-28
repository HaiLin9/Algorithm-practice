package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr= {3,1,4,1,5,9,2,7,6,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left<right) {
            int temp = arr[left];
            int ori_left = left;
            int ori_right = right;
            while (left<right){
                while(left<right && arr[right]>=temp){
                    right--;
                }
                while(left<right && arr[left]<=temp){
                    left++;
                }
                if(left<right){
                    swap(arr, left, right);
                }
            }
            arr[ori_left]= arr[left];
            arr[left] = temp;
            quickSort(arr, ori_left, left-1);
            quickSort(arr, left+1, ori_right);
        }
    }

    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
