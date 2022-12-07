fun main() {

    var testStack1 = ArrayDeque(listOf('N', 'Z'))
    var testStack2 = ArrayDeque(listOf('D', 'C', 'M'))
    var testStack3 = ArrayDeque(listOf('P'))
    val testStacks = mutableListOf(testStack1, testStack2, testStack3)

    /*

[N]         [C]     [Z]
[Q] [G]     [V]     [S]         [V]
[L] [C]     [M]     [T]     [W] [L]
[S] [H]     [L]     [C] [D] [H] [S]
[C] [V] [F] [D]     [D] [B] [Q] [F]
[Z] [T] [Z] [T] [C] [J] [G] [S] [Q]
[P] [P] [C] [W] [W] [F] [W] [J] [C]
[T] [L] [D] [G] [P] [P] [V] [N] [R]
 1   2   3   4   5   6   7   8   9
     */

    var stack1 = ArrayDeque(listOf('N', 'Q', 'L', 'S', 'C', 'Z', 'P', 'T'))
    var stack2 = ArrayDeque(listOf('G', 'C', 'H', 'V', 'T', 'P', 'L'))
    var stack3 = ArrayDeque(listOf('F', 'Z', 'C', 'D'))
    var stack4 = ArrayDeque(listOf('C', 'V', 'M', 'L', 'D', 'T', 'W', 'G'))
    var stack5 = ArrayDeque(listOf('C', 'W', 'P'))
    var stack6 = ArrayDeque(listOf('Z', 'S', 'T', 'C', 'D', 'J', 'F', 'P'))
    var stack7 = ArrayDeque(listOf('D', 'B', 'G', 'W', 'V'))
    var stack8 = ArrayDeque(listOf('W', 'H', 'Q', 'S', 'J', 'N'))
    var stack9 = ArrayDeque(listOf('V', 'L', 'S', 'F', 'Q', 'C', 'R'))
    val realStacks = mutableListOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9)

    fun getMoves(list: List<String>) : List<String> {
        return list.filter { it.contains("move") }
    }

    data class Move(val from: Int, val to: Int, val amount: Int)

    fun getMove(move: String) : Move {
        val from = move.split(" ")[3].toInt() - 1
        val to = move.split(" ")[5].toInt() - 1
        val amount = move.split(" ")[1].toInt()
        return Move(from, to, amount)
    }

    fun part1(list: List<String>, stacks: MutableList<ArrayDeque<Char>>): String {
        val moves = getMoves(list)
        for (move in moves) {
            val move = getMove(move)
            val fromStack = stacks[move.from]
            val toStack = stacks[move.to]
            for (i in 0 until move.amount) {
                toStack.addFirst(fromStack.removeFirst())
            }
        }

        var answer = ""
        for (stack in stacks) {
            answer += stack.first()
        }
        return answer
    }

    // Bottom is size
    // Top is zero
    fun part2(list: List<String>, stacks: MutableList<ArrayDeque<Char>>): String {
        val moves = getMoves(list)
        for (move in moves) {
            val move = getMove(move)
            val fromStack = stacks[move.from]
            val toStack = stacks[move.to]
            val toBeAdded = fromStack.take(move.amount)
            for (i in 0 until move.amount) {
                fromStack.removeFirst()
            }

            val c = toBeAdded.reversed()
            for (i in 0 until move.amount) {
                toStack.addFirst(c[i])
            }
        }
        var answer = ""
        for (stack in stacks) {
            answer += stack.first()
        }
        return answer
    }

    val input = readInput("Day05")
//    println("Part 1: ${part1(input, realStacks)}")
    println("Part 2: ${part2(input, realStacks)}")


}
