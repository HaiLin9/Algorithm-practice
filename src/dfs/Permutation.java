package dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hailin
 * 全排列
 */
public class Permutation {
    private static int num;
    static int[] a;
    static int[] b;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        a = new int[num+1];
        b = new int[num+1];
        permutation(1);
    }

    public static void permutation(int n){
        if(n==num+1) {
            System.out.println(Arrays.toString(a));

        } else {
            for(int j=1; j<=num; j++){
                if(b[j]==0){
                    b[j]=1;
                    a[n]=j;
                    permutation(n+1);
                    b[j]=0;
                }
            }
        }
    }
}
