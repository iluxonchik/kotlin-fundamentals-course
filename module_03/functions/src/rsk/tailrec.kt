package rsk

import java.math.BigInteger

fun main(args: Array<String>) {
    println(fib(100000, BigInteger("1"), BigInteger("0")))
}

// compiler will now turn this into a loop internally
tailrec fun fib(n: Int, a: BigInteger, b:BigInteger) : BigInteger {
    return if (n == 0) b else fib(n - 1, a + b, a)
}