package array;

/**
 * 二分查找法
 */
public class binarySearch {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,5,7,8,9,10,13,67,98};
        System.out.println(binarySearch(arr,67));
    }

    public static int binarySearch(int[] arr, int key){
        int min=0,max=arr.length-1,mid=(min+max)/2;

        while(min<=max){
            mid=(min+max)/2;
            if(key>arr[mid]){
                min = mid+1;
            } else if(key<arr[mid]){
                max = mid -1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
