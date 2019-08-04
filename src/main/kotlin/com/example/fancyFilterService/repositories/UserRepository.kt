package com.example.fancyFilterService.repositories

import com.example.fancyFilterService.dtos.City
import com.example.fancyFilterService.dtos.FilterUserRequest
import com.example.fancyFilterService.dtos.User
import com.example.fancyFilterService.latitude
import com.example.fancyFilterService.longitude
import jooq.fancy.filter.app.Tables.APP_USER
import jooq.fancy.filter.app.Tables.CITY
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.impl.DSL
import org.postgresql.geometric.PGpoint
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepository(val jooq: DSLContext) {

    fun getUserCount() = jooq.fetchCount(APP_USER)

    fun save(users: List<User>) {
        users.forEach {
            val cityId = it.city.id ?: UUID.randomUUID()
            jooq.newRecord(CITY).apply {
                id = cityId
                cityName = it.city.name
                coordinates = PGpoint(it.city.longitude, it.city.latitude)
            }.insert()
            jooq.newRecord(APP_USER).apply {
                id = it.id ?: UUID.randomUUID()
                displayName = it.displayName
                age = it.age.toShort()
                jobTitle = it.jobTitle
                heightInCm = it.heightInCm.toShort()
                this.cityId = cityId
                mainPhoto = it.mainPhoto
                compatibilityScore = it.compatibilityScore.toBigDecimal()
                contactsExchanged = it.contactsExchanged.toShort()
                favourite = it.favourite
                religion = it.religion
            }.insert()
        }
    }

    fun getUsers(): List<User> = jooq.selectFrom(
        APP_USER.join(CITY).on(APP_USER.CITY_ID.eq(CITY.ID))
    ).map { toUser(it) }

    fun getUsersFilterBy(filterUserRequest: FilterUserRequest): List<User> = jooq.selectFrom(
        APP_USER.join(CITY).on(APP_USER.CITY_ID.eq(CITY.ID))
    ).where(addFilterConditions(filterUserRequest))
        .map { toUser(it) }

    private fun addFilterConditions(filterUserRequest: FilterUserRequest) = DSL.trueCondition()
        .and(addHasPhotoCondition(filterUserRequest))
        .and(addInContactCondition(filterUserRequest))
        .and(addFavoriteCondition(filterUserRequest))

    private fun addFavoriteCondition(filterUserRequest: FilterUserRequest) = filterUserRequest.favourite?.let {
        when (it) {
            true -> APP_USER.FAVOURITE.isTrue
            false -> APP_USER.FAVOURITE.isFalse
        }
    } ?: DSL.trueCondition()

    private fun addInContactCondition(filterUserRequest: FilterUserRequest) =
        filterUserRequest.inContact?.let {
            when (it) {
                true -> APP_USER.CONTACTS_EXCHANGED.greaterThan(0)
                false -> APP_USER.CONTACTS_EXCHANGED.equal(0)
            }
        } ?: DSL.trueCondition()

    private fun addHasPhotoCondition(filterUserRequest: FilterUserRequest) =
        filterUserRequest.hasPhoto?.let {
            when (it) {
                true -> APP_USER.MAIN_PHOTO.isNotNull
                false -> APP_USER.MAIN_PHOTO.isNull
            }
        } ?: DSL.trueCondition()

    private fun toUser(it: Record): User = User(
        it.get(APP_USER.ID),
        it.get(APP_USER.DISPLAY_NAME),
        it.get(APP_USER.AGE).toInt(),
        it.get(APP_USER.JOB_TITLE),
        it.get(APP_USER.HEIGHT_IN_CM).toInt(),
        City(
            it.get(CITY.ID),
            it.get(CITY.CITY_NAME),
            it.get(CITY.COORDINATES).latitude(),
            it.get(CITY.COORDINATES).longitude()
        ),
        it.get(APP_USER.MAIN_PHOTO),
        it.get(APP_USER.COMPATIBILITY_SCORE).toFloat(),
        it.get(APP_USER.CONTACTS_EXCHANGED).toInt(),
        it.get(APP_USER.FAVOURITE),
        it.get(APP_USER.RELIGION)
    )
}
