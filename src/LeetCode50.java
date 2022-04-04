public class LeetCode50 {
    public double myPow(double x, int n) {
        long nn= n;
        if(n>=0){
            return pow(x,n);
        } else {
            return 1.0/pow(x,-n);
        }
    }

    double pow(double x, long n){
        if(n==0) {
            return 1;
        }
        double half = pow(x, n/2);
        if(n%2==0) {
            return half*half;
        } else {
            return half*half*x;
        }
    }
}
