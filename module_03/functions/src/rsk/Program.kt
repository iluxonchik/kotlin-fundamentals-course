// if omitted, it would be called ProgramKt in Java
@file:JvmName("DisplayFunctions")

package rsk

fun main(args: Array<String>) {
   println(max(1, 2))
   display("Jason")
   displayWithReturnType("Harry")
   log("Logger", 3)
   log("Logger", logLevel = 4)
   log(message = "Logger", logLevel = 4)
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun display(message: String) {
   println("Hello, $message")
}

fun displayWithReturnType(message: String): Boolean {
   println("Hello, there $message")
   return true
}

// default parameter example
@JvmOverloads // creates overloads with default params in Java
fun log(message: String, logLevel: Int = 1) {
   println("$message $logLevel")
}