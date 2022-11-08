public class lianxiang {


    public static void quickSort(int[] arr, int left, int right){
        if(left<right) {
            int temp = arr[left];
            int oriLeft = left;
            int oriRight = right;
            while(left<right){
                while(left<right && arr[right]>=temp){
                    right--;
                }
                while(left<right && arr[left]<=temp){
                    left++;
                }
                if(left<right){
                    int temp2= arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp2;
                }
            }
            arr[oriLeft]= arr[left];
            arr[left]=temp;
            quickSort(arr,oriLeft,left-1);
            quickSort(arr, left+1,oriRight);
        }
    }
}
