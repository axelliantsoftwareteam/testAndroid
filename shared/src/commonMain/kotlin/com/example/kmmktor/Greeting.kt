package com.example.kmmktor

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlinx.datetime.*
import kotlin.time.Duration.Companion.seconds


class Greeting {
    private val platform: Platform = getPlatform()
    private val rocketComponent = RocketComponent()


    /*fun greet(): String {
        return "Hello, ${platform.name}!"
    }*/

    /*fun greet(): String {
        val firstWord = if (Random.nextBoolean()) "Hi!" else "Hello!"

       return "$firstWord Guess what this is! > ${platform.name}!"
    }*/


  /*  fun greet(): List<String> = buildList {
        add(if (Random.nextBoolean()) "Hi!" else "Hello!")
        add("Guess what this is! > ${platform.name.reversed()}!")
        add("${daysPhrase()}")
    }*/

    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit("Guess what this is! > ${platform.name.reversed()}")
        delay(1.seconds)
        emit(daysPhrase())
        emit(rocketComponent.launchPhrase())
    }

    fun daysUntilNewYear(): Int {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val closestNewYear = LocalDate(today.year + 1, 1, 1)
        return today.daysUntil(closestNewYear)
    }

    fun daysPhrase(): String = "There are only ${daysUntilNewYear()} days left until New Year! 🎆"
}