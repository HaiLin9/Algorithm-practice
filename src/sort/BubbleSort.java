package sort;
import java.util.Arrays;
/**
 * 优化版冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] arr=new int[]{6,2,4,1,3,0,8,9,7};
        bubbleSort(arr);
        System.out.println(arr);
    }

    public static void bubbleSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            boolean isSorted = true;
            for(int j = 1;j<arr.length-i+1; j++){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                    isSorted=false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
