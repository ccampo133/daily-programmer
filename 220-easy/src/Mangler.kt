fun main(args: Array<String>) {
    println(mangle(readLine() ?: ""))
}

fun mangle(input: String): String {
    if (input.isBlank()) return input
    val parts = ((input split "\\W+".toRegex()) dropLastWhile { it.isEmpty() }).toTypedArray()
    val sortedParts = parts map { it.toLowerCase().toCharArray() } map { it.sort(); it } map { it joinToString "" }
    val capitals = input map { it.isUpperCase() }
    fun replace(i: Int, prevStart: Int, mangled: String): String {
        if (i == parts.size()) return mangled
        val word = parts[i]
        val sorted = sortedParts[i]
        val sub = input.substring(prevStart)
        val offset = input.length() - sub.length()
        val start = offset + sub.indexOf(word)
        val end = start + sorted.length()
        val replacement = if (capitals[start]) sorted.capitalize() else sorted
        val replaced = mangled.replaceRange(start, end, replacement)
        return replace(i + 1, start, replaced)
    }
    return replace(0, 0, input)
}
