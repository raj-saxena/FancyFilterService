/*
 * This file is generated by jOOQ.
 */
package jooq.fancyFilterApp;


import javax.annotation.Generated;

import jooq.fancyFilterApp.tables.AppUser;
import jooq.fancyFilterApp.tables.City;
import jooq.fancyFilterApp.tables.FlywaySchemaHistory;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.app_user</code>.
     */
    public static final AppUser APP_USER = jooq.fancyFilterApp.tables.AppUser.APP_USER;

    /**
     * The table <code>public.city</code>.
     */
    public static final City CITY = jooq.fancyFilterApp.tables.City.CITY;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = jooq.fancyFilterApp.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;
}
