import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

fun String.splitToSpaceSeperatedArray() = split("\\s".toRegex())

fun createAlphabetMap(): Map<Char, Int> {
    val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val map = mutableMapOf<Char, Int>()
    for (i in alphabet.indices) {
        map[alphabet[i]] = i + 1
    }
    return map
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
