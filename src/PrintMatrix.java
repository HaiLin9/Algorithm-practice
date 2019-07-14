import java.util.Arrays;
/**
 * 一、问题描述
 *
 * 输入N,M 打印 N*M 螺旋矩阵
 */


public class PrintMatrix {
     public static int[][] arr;
     public static int num = 0;

     public static void main(String[] args){
         printMatrix(5,7);
         for(int[] a:arr){
             System.out.println(Arrays.toString(a));
         }
     }

     public static void printMatrix(int m, int n){
         arr = new int[m][n];
         int startX = 0, startY = 0;
         int endX = m-1, endY = n-1;
         for(;startX <= endX && startY <= endY; startX++, startY++, endX--, endY--){
             printCircle(startX, startY, endX, endY);
         }
     }

     public static void printCircle(int startX, int startY, int endX, int endY){
         if(startX == endX){
             for(int y = startY;y <= endY;y++){
                 arr[startX][y] = ++num;
             }
             return;
         }
         if(startY == endY){
             for(int x = startX;x <= endX;x++){
                 arr[x][startY] = ++num;
             }
             return;
         }

         for(int y = startY;y <= endY;y++){
             arr[startX][y] = ++num;
         }

         for(int x = startX+1; x <= endX; x++){
             arr[x][endY] = ++num;
         }

         for(int y = endY-1; y >= startY; y--){
             arr[endX][y] =  ++num;
         }

         for(int x = endX-1;x >= startX+1;x--){
             arr[x][startY] = ++num;
         }
     }
}
