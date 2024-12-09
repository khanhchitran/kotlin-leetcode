package HackerRank;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.
 * Key Idea
    * This problem is related to cycle detection in a graph, where:
    * Each element in the array represents a vertex.
    * The desired sorted positions form directed edges between vertices.
 * Steps to Solve:
    * Observation:
    * Every element in the array belongs to a specific "cycle".
    * To sort the array, each cycle requires (cycle size - 1) swaps to place all elements in their correct positions.
 * Approach:
    * Use a visited array to track which elements are already in the correct position or processed as part of a cycle.
    * For each unvisited element, follow its cycle and count the number of swaps required.
 */
public class MinimumSwap2Java {
    static int minimumSwaps(int[] arr){
        int swaps = 0;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] || arr[i] == i + 1) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while(!visited[j]){
                visited[j] = true;
                j = arr[j] - 1;
                cycleSize++;
            }
            if(cycleSize > 1) {
                swaps = cycleSize - 1;
            }
        }
        return swaps;
    }
}
