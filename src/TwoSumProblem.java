import java.util.HashMap;
import java.util.Map;

class TwoSumProblem {

    public static void main(String[] args) {

        int[] testArray = {2, 7, 11, 15};
        TwoSumProblem testCode = new TwoSumProblem();
        System.out.println(testCode.twoSum(testArray, 9));
    }

    public String twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(complement)) {
                // If it is, return the indices in the form of a string
                return map.get(complement) + ", " + i;
            }

            // If not, add the number and its index to the map
            map.put(nums[i], i);
        }

        // If no solution is found (though the problem guarantees there is one)
        throw new IllegalArgumentException("No two sum solution");
    }
}