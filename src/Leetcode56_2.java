public class Leetcode56_2 {

    public int singleNumber(int[] nums) {
        int[] temp = new int[32];
        for(int n:nums){
            int bit = 1;
            while(bit<=31){
                if((n&(1<<(bit-1))) !=0){
                    temp[bit-1]+=1;
                }
                bit++;
            }
        }
        int res =0;
        for(int i=0;i<31;i++){
            int num = temp[i];
            if(num%3!=0){
                res+=1<<(i);
            }
        }
        return res;

    }
}
