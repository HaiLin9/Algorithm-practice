import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        int[] arr = new int[set2.size()];
        int j=0;
        for(int i:set2){
            arr[j++] = i;
        }
        return arr;
    }

    /**
     * Êı×é°æ
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectionV2(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<nums1.length; i++){
            hash[nums1[i]] =1;
        }
        for(int i=0;i<nums2.length; i++){
            if(hash[nums2[i]] ==1){
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt((k)->k).toArray();
    }
}
