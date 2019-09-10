package dfs;

import java.util.Scanner;

/**
 * @author hailin
 * 邻接矩阵表示图，同时dfs遍历
 */
public class GraphDFS {
    static int v;    //顶点数
    static int e;    //边数
    static int arr[][];  //邻接矩阵
    static int book[];    //标识顶点是否访问
    static int max=99999;    //无穷
    static int total=0;    //统计已访问顶点个数

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        v=reader.nextInt();
        e=reader.nextInt();
        arr = new int[v][v];
        book = new int[v];
        //邻接矩阵初始化
        for(int i=0;i<v;i++) {
            book[i]=0;
            for(int j=0;j<v;j++) {
                if(i==j) {
                    arr[i][j]=0;
                }
                else {
                    arr[i][j]=max;
                }
            }
        }
        //读入边
        for(int i=0;i<e;i++) {
            int first_E=reader.nextInt();
            int second_E=reader.nextInt();
            arr[first_E][second_E]=1;
            arr[second_E][first_E]=1;
        }
        graph_dfs(0);    //从顶点0开始遍历
    }

    public static void graph_dfs(int n) {
        if(book[n]==0) {
            System.out.println("node:" + n );
            book[n]=1;
            total++;
        }
        if(total == v) {
            return;
        }
        for(int node = 0;node<v;node++){
            if(arr[n][node]==1 && book[node]==0){
                graph_dfs(node);
            }
        }
    }
}
