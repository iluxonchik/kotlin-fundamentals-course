package rsk

fun main(args: Array<String>) {
    var h1 = Header("h1")
    var h2 = Header("h2")

    val h3 = h1 plus h2
    println(h3.Name)

    val h4 = h1 - h2
    println(h4.Name)
}

class Header(var Name: String) { }

infix fun Header.plus(other: Header) : Header {
    return Header(this.Name + other.Name)
}
// operator overloading; Kotlin only allows certain operators to be overloaded
operator infix fun Header.minus(other: Header) : Header {
    return Header("${this.Name} - ${other.Name}")
}