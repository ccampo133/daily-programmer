fun main(args: Array<String>) {
    val input = readLine() ?: ""
    snake(input.split(' '))
}

fun snake(words: List<String>) {
    println(words.first())
    fun snake (words: List<String>, padding: Int, even: Boolean) {
        if (words.isEmpty()) return
        val word = words.first()
        if (even) {
            println(word.padStart(padding + word.length() - 1))
            snake(words.drop(1), padding + word.length() - 1, false)
        } else {
            (word.substring(1, word.length() - 1)) forEach { println(it.toString().padStart(padding)) }
            snake(words drop 1, padding, true)
        }
    }
    snake(words drop 1, words.first().length(), false)
}
