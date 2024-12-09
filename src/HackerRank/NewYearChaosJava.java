package HackerRank;

import java.util.List;

public class NewYearChaosJava {
    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;

        for (int i = 0; i < q.size(); i++) {
            // Check if the person has moved more than 2 positions forward
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Bubble Sort for the range of two positions behind the current index
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }
}
