fun main() {

    fun part1(input: List<String>): Int {
        var elfSum = 0
        var biggestElf = -1
        for (i in input) {
            if (i.isEmpty()) {
                biggestElf = biggestElf.coerceAtLeast(elfSum)
                elfSum = 0
            } else {
                elfSum += i.toInt()
            }
        }
        return biggestElf
    }

    fun part2(input: List<String>): Int {
        var elfSum = 0
        var biggestElf = mutableListOf<Int>(-1, -1, -1)
        for (i in input) {
            if (i.isEmpty()) {
                val min = biggestElf.min()
                val index = biggestElf.indexOf(min)
                biggestElf[index] = min.coerceAtLeast(elfSum)
                println(biggestElf[index])
                elfSum = 0
            } else {
                elfSum += i.toInt()
            }
        }

        val min = biggestElf.min()
        val index = biggestElf.indexOf(min)
        biggestElf[index] = min.coerceAtLeast(elfSum)
        println(biggestElf[index])

        return biggestElf.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part2(testInput))
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
