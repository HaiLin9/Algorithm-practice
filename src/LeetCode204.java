public class LeetCode204 {
    public int countPrimes(int n) {
        int res =0;
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                res++;
            }
        }
        return res;
    }

    public boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
