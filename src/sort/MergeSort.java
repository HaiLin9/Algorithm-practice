package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,6,9,0,-4};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right) {
             int mid = (left+right) / 2;
             mergeSort(arr, left, mid);
             mergeSort(arr, mid+1, right);
             merge(arr, left, mid, right);
        }
    }

    public static void merge(int[]arr, int l, int m, int r) {
        int[] temp = new int[r-l+1];
        int i = 0;
        int p = l;
        int q = m + 1;
        while(p<=m && q<=r){
            temp[i++] = arr[p] > arr[q]? arr[q++]: arr[p++];
        }
        while (p<=m) {
            temp[i++] = arr[p++];
        }
        while (q<=r) {
            temp[i++] = arr[q++];
        }
        System.arraycopy(temp, 0, arr, l, r-l+1);
    }
}
