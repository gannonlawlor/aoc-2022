fun main() {

    val alphabetMap = createAlphabetMap()

    fun part1(input: List<String>): Int {
        var points = 0
        for (line in input) {
            println(line)
            // split string into array
            val list = line.toList()
            val n = list.size
            val first = list.subList(0, (n + 1) / 2)
            val second = list.subList((n + 1) / 2, n)
            val difference = first.intersect(second).toList()
            println(difference)

            points += alphabetMap[difference[0]]!!
            println(points)

        }
        return points
    }

    fun part2(input: List<String>): Int {
        var points = 0
        for (i in input.indices step 3) {
            val first = input[i].toList()
            val second = input[i + 1].toList()
            val third = input[i + 2].toList()
            val difference = first.intersect(second).intersect(third).toList()
            println(difference)
            points += alphabetMap[difference[0]]!!
            println(points)
        }
        return points
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    println(part2(testInput))
//    check(part1(testInput) == 157)

    val input = readInput("Day03")
//    println(part1(input))
    println(part2(input))
}