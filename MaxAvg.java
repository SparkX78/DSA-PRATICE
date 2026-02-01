public class MaxAvg {
    public static double maxAvg(int[] nums, int k){
        int start_index = 0;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int maxSum = sum;
        int endIndex = k;
        while(endIndex < nums.length){
            sum -= nums[start_index];
            start_index++;

            sum += nums[endIndex];
            endIndex++;

            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum/k;
    }
    public static void main(String[] args){
        int[] nums = {-2, 5, 1, 2, 5};
        int k = 2;
        System.out.println(maxAvg(nums, k));

    }
}
