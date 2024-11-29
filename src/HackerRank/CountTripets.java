package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTripets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        // Map to count the occurrences of each number
        HashMap<Long, Long> potentialPairs = new HashMap<>(); // Tracks potential (i, j) pairs
        HashMap<Long, Long> potentialTriplets = new HashMap<>(); // Tracks potential (i, j, k) triplets

        long count = 0;

        for (long value : arr) {
            // Step 3: If this value completes a triplet, add its count
            if (potentialTriplets.containsKey(value)) {
                count += potentialTriplets.get(value);
            }

            // Step 2: If this value can form a (j, k) pair, update potential triplets
            if (potentialPairs.containsKey(value)) {
                potentialTriplets.put(
                        value * r,
                        potentialTriplets.getOrDefault(value * r, 0L) + potentialPairs.get(value)
                );
            }

            // Step 1: Update potential pairs
            potentialPairs.put(
                    value * r,
                    potentialPairs.getOrDefault(value * r, 0L) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
