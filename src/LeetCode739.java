public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length ==0 ){
            return new int[0];
        }
        int[] res= new int[temperatures.length];
        for(int i=0;i<temperatures.length; i++){
            for(int j=i+1;j<temperatures.length;j++) {
                if(temperatures[j]>temperatures[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}
