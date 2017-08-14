package com.github.uuidcode.exposed.test

import main.java.com.github.uuidcode.exposed.test.City
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test

class CityTest {
    @Test
    fun test() {
        val url = System.getProperty("url")
        val user = System.getProperty("user")
        val password = System.getProperty("password")

        Database.connect(url = url,
                driver = "com.mysql.jdbc.Driver",
                user = user,
                password = password)

        transaction {
            SchemaUtils.create(City)

            val city = main.java.com.github.uuidcode.exposed.test.City.insert {
                it[name] = "test"
                it[displayName] = "display_test"
            }

            main.java.com.github.uuidcode.exposed.test.City.update({
                City.id eq 1
            }) {
                it[displayName] = "display_test_111"
            }

            val list = main.java.com.github.uuidcode.exposed.test.City.select {
                City.id greaterEq 1
            }

            list.forEach {
                println(it)
            }

            main.java.com.github.uuidcode.exposed.test.City.deleteWhere {
                City.id eq city[City.id]
            }
        }
    }
}