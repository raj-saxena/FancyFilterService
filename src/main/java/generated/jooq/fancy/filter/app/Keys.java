/*
 * This file is generated by jOOQ.
 */
package jooq.fancy.filter.app;


import javax.annotation.Generated;

import jooq.fancy.filter.app.tables.AppUser;
import jooq.fancy.filter.app.tables.City;
import jooq.fancy.filter.app.tables.FlywaySchemaHistory;
import jooq.fancy.filter.app.tables.SpatialRefSys;
import jooq.fancy.filter.app.tables.records.AppUserRecord;
import jooq.fancy.filter.app.tables.records.CityRecord;
import jooq.fancy.filter.app.tables.records.FlywaySchemaHistoryRecord;
import jooq.fancy.filter.app.tables.records.SpatialRefSysRecord;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AppUserRecord> APP_USER_PKEY = UniqueKeys0.APP_USER_PKEY;
    public static final UniqueKey<CityRecord> CITY_PKEY = UniqueKeys0.CITY_PKEY;
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<SpatialRefSysRecord> SPATIAL_REF_SYS_PKEY = UniqueKeys0.SPATIAL_REF_SYS_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AppUserRecord, CityRecord> APP_USER__APP_USER_CITY_ID_FKEY = ForeignKeys0.APP_USER__APP_USER_CITY_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<AppUserRecord> APP_USER_PKEY = Internal.createUniqueKey(AppUser.APP_USER, "app_user_pkey", AppUser.APP_USER.ID);
        public static final UniqueKey<CityRecord> CITY_PKEY = Internal.createUniqueKey(City.CITY, "city_pkey", City.CITY.ID);
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
        public static final UniqueKey<SpatialRefSysRecord> SPATIAL_REF_SYS_PKEY = Internal.createUniqueKey(SpatialRefSys.SPATIAL_REF_SYS, "spatial_ref_sys_pkey", SpatialRefSys.SPATIAL_REF_SYS.SRID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AppUserRecord, CityRecord> APP_USER__APP_USER_CITY_ID_FKEY = Internal.createForeignKey(jooq.fancy.filter.app.Keys.CITY_PKEY, AppUser.APP_USER, "app_user__app_user_city_id_fkey", AppUser.APP_USER.CITY_ID);
    }
}
