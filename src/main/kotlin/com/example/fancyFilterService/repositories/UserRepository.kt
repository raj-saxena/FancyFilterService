package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.dtos.User
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
}
