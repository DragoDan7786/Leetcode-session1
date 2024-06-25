import java.util.Arrays;

public class TwoCityProblem {
    //method to find cheapest way to get n people to city a and b with a size of 2n
    public int twoCitySchedCost(int[][] costs) {
        // Sort the costs array by the difference in cost of flying to city a and city b
        Arrays.sort(costs, (cost1, cost2) -> (cost1[0] - cost1[1]) - (cost2[0] - cost2[1]));

        int theCost = 0;
        int n = costs.length / 2;

        // Send the first n people to city a and the rest to city b
        for (int i = 0; i < n; i++) {
            theCost += costs[i][0]; // Cost for city a
        }
        for (int i = n; i < 2 * n; i++) {
            theCost += costs[i][1]; // Cost for city b
        }

        return theCost;
    }
}
