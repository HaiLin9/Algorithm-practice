import java.util.Arrays;
import java.util.Comparator;

public class Offer45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0;i<strs.length;i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuffer sb = new StringBuffer();
        for(String s:strs){
            sb.append(s);
        }
        return sb.toString();

    }


}
