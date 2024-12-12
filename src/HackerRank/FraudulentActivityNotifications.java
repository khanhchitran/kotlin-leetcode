package HackerRank;

import java.util.List;

public class FraudulentActivityNotifications {
    public static int activityNotifications(List<Integer> expenditure, int d) {
        int[] count = new int[201]; // Frequency array for expenditures (0-200)
        int notifications = 0;

        // Initialize the frequency array for the first `d` days
        for (int i = 0; i < d; i++) {
            count[expenditure.get(i)]++;
        }

        // Traverse the rest of the expenditures
        for (int i = d; i < expenditure.size(); i++) {
            // Calculate the median
            double median = getMedian(count, d);

            // Check if the current expenditure triggers a notification
            if (expenditure.get(i) >= 2 * median) {
                notifications++;
            }

            // Update the sliding window
            count[expenditure.get(i)]++; // Add the current day's expenditure
            count[expenditure.get(i - d)]--; // Remove the oldest day's expenditure
        }

        return notifications;
    }

    private static double getMedian(int[] count, int d) {
        int sum = 0;
        int median1 = -1, median2 = -1;

        // Odd `d`: find the middle element
        if (d % 2 != 0) {
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum >= (d / 2 + 1)) {
                    return i; // Median for odd `d`
                }
            }
        }
        // Even `d`: find the average of the two middle elements
        else {
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum >= d / 2 && median1 == -1) {
                    median1 = i;
                }
                if (sum >= d / 2 + 1) {
                    median2 = i;
                    return (median1 + median2) / 2.0; // Average of the two
                }
            }
        }

        return 0.0; // This should not happen
    }
}
