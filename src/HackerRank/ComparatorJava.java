package HackerRank;

import java.util.Comparator;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
public class ComparatorJava {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score == b.score) {
            return a.name.compareTo(b.name);
        }else{
            return Integer.compare(b.score, a.score);
        }
    }
}

//public class ComparatorJava2 {
//    public static Comparator<Player> playerComparator = Comparator
//            .comparingInt((Player p) -> p.score).reversed() // Compare scores in descending order
//            .thenComparing(p -> p.name); // If scores are equal, compare names in ascending order
//}
