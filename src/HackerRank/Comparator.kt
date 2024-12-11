package HackerRank

class Comparator {
    data class Player(val name: String, val score: Int)

    fun main(args: Array<String>){
        //Read input from STDIN
        val n = readln().toInt()
        val players = mutableListOf<Player>()

        repeat(n) {
            val (name, score) = readln().split(" ")
            players.add(Player(name, score.toInt()))
        }
        //Sort the players
        players.sortWith(compareByDescending<Player> {it.score}.thenBy { it.name } )

        //Print the sorted players
        players.forEach{ println("${it.name} ${it.score}") }
    }
}
