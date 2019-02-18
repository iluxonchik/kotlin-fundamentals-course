import java.io.FileReader
import java.io.IOException
import java.util.*

fun main(args: Array<String>) {
    println("Hello, world!")

    val q = Question()

    // q = Question() does not work
    q.Answer = "Yes"
    // q.Question = "Yes?" does not work

    q.display()

    // NOTE: here, $ gets bound to the Question instance and not to the Answer variable
    println("The answer is $q.Answer")
    // to bind the $ to variable q.Answer, we use {}
    println("The answer to the question ${q.Question} is ${q.Answer}")

    // In Kotlin, if is an expression and it returns a value from *within the if and else blocks*
    // For this reason, the following code:

    var message: String
    if (q.Answer == q.CorrectAnswer) {
        message = "You were correct"
    } else {
        message = "Try again"
    }

    println(message)

    // Into the following code:
    val message2 = if (q.Answer == q.CorrectAnswer) {
        "You were correct"
    } else {
        "Try again"
    }

    println(message2)

    // in Kotlin, you have to explicitly tell that a variable can be null. This is done with the
    // "?" operator (syntax similar to C# ;) )
    var q2:Question? = null
    // now you have to safe-guard each call to the variable with a "?"
    println("The correct answer is ${q2?.Answer}")

    q2 = Question()
    println("The correct answer is ${q2.Answer}")

    q.printResult()

    forLoops()

    // Exceptions are simplified. Kotlin uses unchecked exceptions
    // NOTE: the code below will blow-up on a non-unix machine, but this is just a demo anyways...
    var reader = FileReader("/dev/urandom")

    // we can, however, still use the try/catch/finally block:

    try {
        reader.read()
    } catch (e: IOException) {
        println("No file with the specified filename")
    } finally {
        println("Good-byte, this is the end of this part!")
    }

}

fun forLoops() {
    for (i in 1..10) {
        println(i)
    }

    for (i in 1..10 step 2) {
        println(i)
    }

    for (i in 10 downTo 1 step 2) {
       println(i)
    }

    for (i in 1 until 10) {
        println(i)
    }

    var numbers = listOf(1, 2 ,3)

    for (i in numbers) {
        println(i)
    }

    var nums = TreeMap<String, Int>()
    nums["uno"] = 1
    nums["dos"] = 2
    nums["tres"] = 3
    nums["quatro"] = 4

    // Kotlin trying to be Pythonic
    for ((value, number) in nums) {
        println("$value = $number")
    }

    for ((index, element) in numbers.withIndex()) {
        println("$element is at $index")
    }

    // ranges work not only with numbers, but with any type that implements the Comparable
    // interface. For example, we can use it with Strings:
    var strRange = 'a'..'c'
    for (value in strRange) {
        println(value)
    }
}

// classes are public by default
class Question {
    var Answer: String = ""
    val CorrectAnswer = "Yes"
    val Question = "Would you do it if my name was Dre?"

    fun display() {
        println("You said" + Answer)
        println("You said $Answer")
    }

    fun printResult() {
        // This code is equivalent...
        if (Answer == CorrectAnswer) {
            println("You are correct")
        } else {
            println("You are wrong")
        }

        //... to this one:
        when (Answer) {
            CorrectAnswer -> println("You are correct")
            else -> println("You are wrong")
        }
    }
}