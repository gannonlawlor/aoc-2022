fun main() {
    fun part1(list: List<String>): Int {
        var count = 0
        for (line in list) {
            val firstPair = line.split(",")[0].split("-")
            val secondPair = line.split(",")[1].split("-")

            val firstStart = firstPair[0].toInt()
            val firstEnd = firstPair[1].toInt()

            val secondStart = secondPair[0].toInt()
            val secondEnd = secondPair[1].toInt()

//            println("${firstPair[0]}..${firstPair[1]} ${secondPair[0]}..${secondPair[1]}")
            // Pair 38-41,5-40
            if (firstStart <= secondStart && firstEnd >= secondEnd) {
                count++
//                println("Pair ${line}")
            } else if (secondStart <= firstStart && secondEnd >= firstEnd) {
                count++
//                println("Pair2 ${line}")
            }
        }
        return count
    }

    fun part2(list: List<String>): Int {
        var count = 0
        for (line in list) {
            val firstPair = line.split(",")[0].split("-")
            val secondPair = line.split(",")[1].split("-")

            val firstStart = firstPair[0].toInt()
            val firstEnd = firstPair[1].toInt()

            val secondStart = secondPair[0].toInt()
            val secondEnd = secondPair[1].toInt()

            // 5-7,4-5
            if (firstEnd >= secondStart && secondEnd >= firstStart) {
                count++
            }
        }
        return count
    }

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}