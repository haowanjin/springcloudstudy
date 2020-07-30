package com.ddup.kotlin

import java.util.*

class Person(name: String, age: Int) {
    var nick: String = "$name" + "abc" + 1111222 + Date()

    init {
        println(nick)
    }


}

fun main(args: Array<String>) {
    val a: Person? = null

    a.apply {
        if (this != null)
            println("aaaaaaaaaaa")
    }
    val person = Person("lsit", 13)
    println(person.nick)
}

