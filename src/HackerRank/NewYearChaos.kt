package HackerRank

class NewYearChaos {
    fun minimumBribes(q: Array<Int>) {
        var bribes = 0

        for (i in q.indices) {
            // Check if current person has moved more than 2 positions ahead
            if (q[i] - (i + 1) > 2) {
                println("Too chaotic")
                return
            }

            // Count the number of overtakes (bribes) this person has received
            for (j in maxOf(0, q[i] - 2) until i) {
                if (q[j] > q[i]) {
                    bribes++
                }
            }
        }

        println(bribes)
    }
}
