package main.java.com.github.uuidcode.exposed.test

import org.jetbrains.exposed.sql.Table

object City : Table("city") {
    val id = long("id").autoIncrement().primaryKey()
    val name = varchar("name", 50)
    val displayName = varchar("display_name", 50)
}