fun main() {

    // 0 if you lost, 3 if the round was a draw, and 6 if you won
    // 1 for Rock, 2 for Paper, and 3 for Scissors
    // Opponent, Me --> Score
    val map = mutableMapOf<String, Int>()
    map["A Y"] = 8
    map["A X"] = 4
    map["A Z"] = 3

    map["B Y"] = 5
    map["B X"] = 1
    map["B Z"] = 9

    map["C Y"] = 2
    map["C X"] = 7
    map["C Z"] = 6


    // A for Rock, B for Paper, and C for Scissors
    // X for Rock, Y for Paper, and Z for Scissors
    // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win

    val part2Map = mutableMapOf<String, String>()
    part2Map["A X"] = "Z"
    part2Map["A Y"] = "X"
    part2Map["A Z"] = "Y"

    part2Map["B X"] = "X"
    part2Map["B Y"] = "Y"
    part2Map["B Z"] = "Z"

    part2Map["C X"] = "Y"
    part2Map["C Y"] = "Z"
    part2Map["C Z"] = "X"

    fun part1(input: List<String>): Int {
        var points = 0
        for (line in input) {
            points += map[line]!!
        }

        return points
    }

    fun part2(input: List<String>): Int {
        var points = 0
        for (line in input) {
            val opponentMove = line.splitToArray()[0]
            val shouldMove = part2Map[line]!!
            val s = "$opponentMove $shouldMove"
            points += map[s]!!
        }
        return points
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    println(part2(testInput))
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
