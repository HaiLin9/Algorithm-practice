package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,6,9,0,-4,0};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid+1, right);
        }
    }

    public static void merge(int[] arr, int i, int m, int j) {
        if(i<j) {
            int[] temp = new int[j - i + 1];
            int p = i;
            int q = m;
            int t = 0;
            while (p <= m - 1 && q <= j) {
                temp[t++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
            }
            while (p <= m - 1) {
                temp[t++] = arr[p++];
            }
            while (q <= j) {
                temp[t++] = arr[q++];
            }
            System.arraycopy(temp, 0, arr, i, temp.length);
        }
    }
}

