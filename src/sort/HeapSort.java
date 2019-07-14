package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args){
        int[] arr = {4,1,6,2,8,3,0,9,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length/2-1; i>=0; i--){
            headAjust(arr,i,arr.length);
        }

        for(int i = arr.length-1; i >= 1 ;i--){
            swap(arr,0,i);
            headAjust(arr,0,i);
        }
    }

    public static void headAjust(int[] arr, int i, int length){
        int temp = arr[i];
        for(int k = 2*i+1;k<length;k = 2*k+1){
            if(k+1<length && arr[k+1]>arr[k]){
                k=k+1;
            }
            if(arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            }
            else{
                break;
            }
        }
        arr[i]=temp;
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
