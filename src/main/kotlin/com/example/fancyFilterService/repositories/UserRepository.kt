package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.dtos.City
import com.example.fancyFilterService.dtos.User
import com.example.fancyFilterService.latitude
import com.example.fancyFilterService.longitude
import jooq.fancy.filter.app.Tables.APP_USER
import jooq.fancy.filter.app.Tables.CITY
import org.jooq.DSLContext
import org.postgresql.geometric.PGpoint
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepository(val jooq: DSLContext) {

    fun getUserCount() = 0

    fun save(users: List<User>) {
        users.forEach {
            val cityId = UUID.randomUUID()
            jooq.newRecord(CITY).apply {
                id = cityId
                cityName = it.city.name
                coordinates = PGpoint(it.city.longitude, it.city.latitude)
            }.insert()
            jooq.newRecord(APP_USER).apply {
                id = UUID.randomUUID()
                displayName = it.displayName
                age = it.age.toShort()
                jobTitle = it.jobTitle
                heightInCm = it.heightInCm.toShort()
                this.cityId = cityId
                mainPhoto = it.mainPhoto
                compatibilityScore = it.compatibilityScore.toBigDecimal()
                contactsExchanged = it.contactsExchanged.toShort()
                favorite = it.favourite
                religion = it.religion
            }.insert()
        }
    }

    fun getUsers(): List<User> = jooq.selectFrom(
        APP_USER.join(CITY).on(APP_USER.CITY_ID.eq(CITY.ID))
    ).map {
        User(
            it.get(APP_USER.DISPLAY_NAME),
            it.get(APP_USER.AGE).toInt(),
            it.get(APP_USER.JOB_TITLE),
            it.get(APP_USER.HEIGHT_IN_CM).toInt(),
            City(
                it.get(CITY.CITY_NAME), it.get(CITY.COORDINATES).latitude(), it.get(CITY.COORDINATES).longitude()
            ),
            it.get(APP_USER.MAIN_PHOTO),
            it.get(APP_USER.COMPATIBILITY_SCORE).toFloat(),
            it.get(APP_USER.CONTACTS_EXCHANGED).toInt(),
            it.get(APP_USER.FAVORITE),
            it.get(APP_USER.RELIGION)
        )
    }
}
