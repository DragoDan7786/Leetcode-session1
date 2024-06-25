import java.util.Map;

public class SubarraySums {
    public int subarraysDivByK(int[] nums, int k) {
        //works but time complexity is too large
/*    //loop through array, add one if entry is divisible by k, then add one more if next index is also divisible by k
        int currentsum = 0;
        int numSubArrays = 0;
        for(int i =0; i < nums.length;i++){
            currentsum = nums[i];
            if(currentsum%k==0){
                numSubArrays++;
            }
            for (int j = i+1 ; j < nums.length; j++){
                currentsum += nums[j];
                if(currentsum%k==0){
                    numSubArrays++;
                }
            }
        }
        return numSubArrays;*/

        //hashmap implementation
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1); // Initialize with 0 remainder count

        for (int num : nums) {
            sum += num;
            int remainder = (sum % k + k) % k; // Compute the remainder, ensure it's positive

            if (remainderMap.containsKey(remainder)) {
                count += remainderMap.get(remainder);
            }

            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
