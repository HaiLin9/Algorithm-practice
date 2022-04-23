package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,6,9,0,-4};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left +right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int index =0;
        int p=left;
        int q=mid+1;
        while(p<=mid && q<=right) {
            temp[index++] = arr[p]<arr[q]? arr[p++]:arr[q++];
        }
        while(p<=mid) {
            temp[index++] = arr[p++];
        }
        while(q<=right) {
            temp[index++] = arr[q++];
        }
        System.arraycopy(temp, 0, arr, left, right - left + 1);
    }
}
