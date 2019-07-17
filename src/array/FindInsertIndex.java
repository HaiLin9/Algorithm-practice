package array;

/**
 * 该程序找到元素应该插入到有序数组中的位置
 */
public class FindInsertIndex {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,5,7,8,9,10,13,67,98};
        System.out.println(findInsertIndex(arr,68));
    }

    public static int findInsertIndex(int[] arr, int key){
        int min=0,max=arr.length-1,mid = (min + max)/2;
        while(min<=max){
            mid=(min + max) /2;
            if(key>arr[mid]){
                min = mid+1;
            } else if(key<arr[mid]){
                max = mid -1;
            } else{
                return mid;
            }
        }
        return min;
    }
}
