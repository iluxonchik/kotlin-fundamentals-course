package rsk

fun main(args: Array<String>) {
    val text = "With      multiple   \t whitespace"
    println(text)
    println(replaceMultipleWithWhiteSpace(text))
    println(text.replaceMultipleWithWhiteSpaceEx())
}

fun replaceMultipleWithWhiteSpace(value: String) : String {
    var regex = Regex("\\s+")
    return regex.replace(value, " ")
}

// here's an example of an extension method
fun String.replaceMultipleWithWhiteSpaceEx() : String {
    // "this" is the value of the receiver, i.e. the value of whatever string
    // this method is being called on
    var regex = Regex("\\s+")
    return regex.replace(this, " ")
}
