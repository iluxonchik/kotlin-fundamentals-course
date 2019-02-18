import com.rsk.Person
import com.rsk.PersonWithCtor

fun main(args: Array<String>) {
    println("Hello, world!")

    val jason = Person()
    jason.Name = "Jason"

    println("The name is ${jason.Name}")

    val harry = PersonWithCtor("Harry")
    println("The second name is ${harry.Name}")
    harry.display()

    // :: creates a member or a class reference
    harry.displayWithLambda(::printName)

}

fun printName(name: String) {
    println(name)
}