package com.rsk

class PersonWithCtor (val Name: String) {

    fun display() {
        println("Display: ${Name}")
    }

    // Unit in Kotlin is void in Java
    fun displayWithLambda(func: (s:String) -> Unit) {
        func(Name)
    }
}