package com.example.fancyFilterService.configs

import org.jooq.Converter
import org.postgresql.geometric.PGpoint

public class PostgresPointJooqConverter : Converter<Any, PGpoint> {
    override fun from(databaseObject: Any): PGpoint = when (databaseObject) {
        is PGpoint -> databaseObject
        else -> PGpoint(0.0, 0.0)
    }

    override fun to(userObject: PGpoint): Any = userObject

    override fun fromType(): Class<Any> = Any::class.java

    override fun toType(): Class<PGpoint> = PGpoint::class.java
}
