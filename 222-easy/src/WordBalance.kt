fun main(args: Array<String>) {
    balance(readLine()?.toLowerCase() as String)
}

fun balance(word: String) {
    fun balance(pivot: Int) {
        if (pivot >= word.length()) return println("$word does not balance")
        val left = word.take(pivot)
        val right = word.substring(pivot + 1, word.length())
        val leftSum = left.withIndex() sumBy { (pivot - it.index) * (it.value.toInt() - 96) }
        val rightSum = right.withIndex() sumBy { (it.index + 1) * (it.value.toInt() - 96) }
        if (leftSum == rightSum) println("$left ${word[pivot]} $right - $leftSum") else balance(pivot + 1)
    }
    balance(1)
}
