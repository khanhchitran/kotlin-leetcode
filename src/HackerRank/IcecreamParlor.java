package HackerRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IcecreamParlor {
    public static void whatFlavors(List<Integer> cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< cost.size(); i++) {
            int firstFlavor = money - cost.get(i);
            int secondFlavor = cost.get(i);
            if (map.containsKey(firstFlavor)) {
                System.out.println(map.get(firstFlavor) + " " + (i+1));
                return;
            }
            map.put(secondFlavor, i+1);
        }
    }
}
