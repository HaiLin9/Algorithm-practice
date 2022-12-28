package sort;
import java.util.Arrays;
/**
 * 优化版冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] arr=new int[]{6,2,4,1,3,0,8,9,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for(int i=1;i<=arr.length-1;i++){
            for(int j=0; j< arr.length-i;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
