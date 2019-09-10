package leetcode.integer;

import java.util.BitSet;

/**
 * 输出n以内的素数，利用java BitSet
 */
import java.lang.Enum;
public class PrimeNumber {
    public static void main(String[] args){
        primeNumber(10);
    }
    public static void primeNumber(int n){
        BitSet bs = new BitSet(n+1);
        for(int i=2;i<=n;i++){
            bs.set(i);
        }

        for(int i=2;i*i<=n;i++){
            if(bs.get(i)){
                int k = 2*i;
                while(k <= n){
                    bs.clear(k);
                    k+=i;
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(bs.get(i)){
                System.out.println(i);
            }
        }
    }
}
