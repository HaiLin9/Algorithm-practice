import java.util.Deque;
import java.util.LinkedList;

public class HuaWei2 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        System.out.println(calMedium(arr1, arr2));
    }

    public static int calMedium(int[] arr1, int[] arr2){
        int num1 = arr1.length;
        int num2 = arr2.length;
        int mid = (num1+num2)/2;
        Deque<Integer> stack =new LinkedList<>();
        int i=0;
        int j=0;
        while(i<num1 && j<num2){
            if(stack.size()==mid+1){
                return stack.pop();
            }
            if(arr1[i]<arr2[j]){
                stack.push(arr1[i]);
                i++;
            } else {
                stack.push(arr2[j]);
                j++;
            }
        }
        while(i<num1){
            if(stack.size()==mid+1){
                return stack.pop();
            }
            stack.push(arr1[i++]);
        }
        while(j<num2){
            if(stack.size()==mid+1){
                return stack.pop();
            }
            stack.push(arr2[j++]);
        }
        return -1;
    }

}
