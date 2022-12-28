

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Mian2 {

    public static String insertChar(String s){
        int left =0;
        int right =s.length()-1;
        while(left<right&& s.charAt(left) ==s.charAt(right)){
            left++;
            right--;
        }
        if(left==right){
            return s;
        }
        s = s.substring(0,right+1)+ s.charAt(left) + s.substring(right+1,s.length());
        if (isHui(s)){
            return s;
        } else {
            return "";
        }
    }

    public static  boolean isHui(String s){
        int left =0;
        int right =s.length()-1;
        while(left<right){
            if(s.charAt(left) !=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(insertChar("abcza"));
    }
}
