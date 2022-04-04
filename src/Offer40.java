import java.util.Arrays;

public class Offer40 {


    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k==0 || arr.length ==0){
            return new int[0];
        }
        return getLeastNumbers(arr, k-1, 0, arr.length-1);
    }


    public static int[] getLeastNumbers(int[] arr, int k, int left, int right) {
        int i=partition(arr, left, right);
        if(i==k) {
            return Arrays.copyOf(arr, k+1);
        }
        return i>k? getLeastNumbers(arr, k, left, i-1): getLeastNumbers(arr, k, i+1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        int ori_left = left;
        while(left<right) {
            while(left<right && arr[right]>=temp){
                right--;
            }
            while(left<right && arr[left]<=temp){
                left++;
            }
            if(left < right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        arr[ori_left] = arr[left];
        arr[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[]{3,2,1}, 2);
    }
}
