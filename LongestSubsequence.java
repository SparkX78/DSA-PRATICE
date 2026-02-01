import java.util.*;
public class LongestSubsequence {
    public static int longSubsequent(int[] nums){
        int longest = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], false);
        }
        for(int num : nums){
            int current_length = 1;
            int nextNum = num + 1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                map.put(nextNum, true);
                current_length++;
                nextNum ++;

            }
            int prev_num = num - 1;
            while(map.containsKey(prev_num) && map.get(prev_num) == false){
                map.put(prev_num, true);
                prev_num--;
                current_length++;

            }
            longest = Math.max(longest, current_length);
        }
        return longest;
        
    }
    public static void main(String[] args){
        int[] nums = {2, 6, 10, 7, 9, 3, 4};
        System.out.println(longSubsequent(nums));
    }
}
